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
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.commons.io.IOUtils;
import org.connectopensource.interopgui.dataobject.CertificateInfo;

/**
 * Implementation of {@link CertificateService} that relies on JCE libraries.
 */
public class JceCertificateService implements CertificateService {
        
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
        throw new UnsupportedOperationException();
    }
    

    private X509Certificate createX509Cert(CertificateInfo certInfo) 
            throws URISyntaxException, IOException, CertificateException {

        FileInputStream inputStream = null;
        ByteArrayInputStream bais = null;
        try {
            inputStream = new FileInputStream(new File(certInfo.getPathToCert().getPath()));

            byte value[] = new byte[inputStream.available()];
            inputStream.read(value);
            bais = new ByteArrayInputStream(value);

            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

            return (X509Certificate) certFactory.generateCertificate(bais);
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(bais);
        }
    }

    
}
