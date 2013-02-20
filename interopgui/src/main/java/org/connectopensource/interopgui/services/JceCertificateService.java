/*
 * Copyright (c) 2013, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of the United States Government nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.connectopensource.interopgui.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.ssl.PEMItem;
import org.apache.commons.ssl.PEMUtil;
import org.bouncycastle.jce.PKCS10CertificationRequest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.connectopensource.interopgui.PropertiesHolder;
import org.connectopensource.interopgui.dataobject.CertificateInfo;

/**
 * Implementation of {@link CertificateService} that relies on JCE libraries.
 */
public class JceCertificateService implements CertificateService {
  
    private static final String BEGIN_CERT = "-----BEGIN CERTIFICATE-----\n";    
    private static final String END_CERT = "-----END CERTIFICATE-----\n";
    
    private static final String EXTENSION_SIGNED_CERT = PropertiesHolder.getProps().getProperty(
            "file.extension.signed.pem");
    private static final String PRIVKEY_PEM_PATH = PropertiesHolder.getProps().getProperty(
            "privkeypem.path");    
    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void trustCertificate(CertificateInfo certInfo) {
        try {
            X509Certificate x509Cert = createX509Cert(certInfo);
            JceTrustStoreManager.getInstance().addTrustedCert(x509Cert, certInfo.getAlias());
        } catch (Exception e) {
            throw new CertificateServiceException("Error while trusting cert, alias = " + certInfo.getAlias()
                    + ", path uri = " + certInfo.getPathToCert(), e);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public CertificateInfo signCertificate(CertificateInfo certInfo) {
        
        CertificateInfo signedCertInfo = null;
        try {
            signedCertInfo = new CertificateInfo();
            signedCertInfo.setPathToCert(new URI(certInfo.getPathToCert().getPath() + EXTENSION_SIGNED_CERT));
            
            PKCS10CertificationRequest csr = createCsr(certInfo);
            X509Certificate signedCert = JceCsrSignedCertGenerator.sign(csr, getCaPrivateKey());
            
            // drop the signed certificate in the same spot as the original path with an addtl extension
            writeCertToFile(signedCertInfo, signedCert);
            
        } catch (Exception e) {
            throw new CertificateServiceException("Error while creating signed cert from CSR", e);
        }
        
        return signedCertInfo;
    }


    private void writeCertToFile(CertificateInfo signedCertInfo, X509Certificate signedCert)
            throws IOException, CertificateEncodingException {        
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(signedCertInfo.getPathToCert().getPath()));
            outputStream.write((BEGIN_CERT).getBytes(Charset.forName("US-ASCII")));
            outputStream.write(Base64.encodeBase64(signedCert.getEncoded()));
            outputStream.write((END_CERT).getBytes(Charset.forName("US-ASCII")));
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    private X509Certificate createX509Cert(CertificateInfo certInfo) 
            throws URISyntaxException, IOException, CertificateException {

        FileInputStream inputStream = null;
        ByteArrayInputStream bais = null;
        try {
            inputStream = new FileInputStream(new File(certInfo.getPathToCert().getPath()));

            byte[] value = new byte[inputStream.available()];
            inputStream.read(value);
            bais = new ByteArrayInputStream(value);

            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

            return (X509Certificate) certFactory.generateCertificate(bais);
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(bais);
        }
    }
    
    private PKCS10CertificationRequest createCsr(CertificateInfo certInfo) {

        final PEMItem csrPemFormat = getPemItem(certInfo.getPathToCert().getPath());

        // Verify the type.
        if (!"CERTIFICATE REQUEST".equals(csrPemFormat.pemType)) {
            throw new CertificateServiceException("pem does not appear to contain a CSR.");            
        }
         
        return new PKCS10CertificationRequest(csrPemFormat.getDerBytes());
    }
    
    private PrivateKey getCaPrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        
        final PEMItem privKeyPem = getPemItem(PRIVKEY_PEM_PATH);
        
        // PKCS8 decode the encoded RSA private key
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privKeyPem.getDerBytes());
        KeyFactory kf = KeyFactory.getInstance("RSA");

        return kf.generatePrivate(keySpec);
    }
    
    private PEMItem getPemItem(String filepath) { 

        FileInputStream inputStream = null;
        byte[] value = null;
        try {
            inputStream = new FileInputStream(new File(filepath));
            value = new byte[inputStream.available()];
            inputStream.read(value);
        } catch (Exception e) {
            throw new CertificateServiceException("pem is empty.", e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        
        @SuppressWarnings("rawtypes")
        final List pemItems = PEMUtil.decode(value);
                
        // Verify list isn't empty - uses Apache Commons Lang.
        if (pemItems.isEmpty()) {
            throw new CertificateServiceException("privkey pem is empty: " + filepath);
        }
        
        return (PEMItem) pemItems.get(0);
    }
    
}
