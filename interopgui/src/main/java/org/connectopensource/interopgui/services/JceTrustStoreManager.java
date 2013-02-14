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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

import org.apache.commons.io.IOUtils;

/**
 * Thread Safe Trust Store Manager provides synchronized read/write operations against a JCE Keystore.
 */
public class JceTrustStoreManager {
    
    private KeyStore trustStore = null;
//    private KeyStore pks = null;

    private static final String TRUSTSTORE_PATH = "cacerts.jks";
    private static final String TRUSTSTORE_PASS = "changeit";
    private static final String KEYSTORE_TYPE_JKS = "JKS";

    private char[] trustStorePass = TRUSTSTORE_PASS.toCharArray();    
    
    // Private constructor prevents instantiation from other classes
    private JceTrustStoreManager() {
        load();
    }

    private static class SingletonHolder { 
        public static final JceTrustStoreManager INSTANCE = new JceTrustStoreManager();
    }

    public static JceTrustStoreManager getInstance() {
        return SingletonHolder.INSTANCE;
    }    

    private synchronized void load() {

        FileInputStream inputStream = null;
        try {
            File file = new File(TRUSTSTORE_PATH);
            if (file.exists()) {
                inputStream = new FileInputStream(TRUSTSTORE_PATH);
            }
            trustStore = KeyStore.getInstance(KEYSTORE_TYPE_JKS);
//            pks = KeyStore.getInstance(KEYSTORE_TYPE_JKS);
//            pks.load(fis, null);
//            if (file.exists()) {
//                fis.close();
//                fis = new FileInputStream(TRUSTSTORE_PATH);
//            }
            trustStore.load(inputStream, null);
        } catch (Exception e) {
            throw new CertificateServiceException("Unable to load trust store.", e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    /**
     * Disclaimer: This private method is not thread-safe. Caller beware (...or be synchronized).
     */
    private void store() {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(TRUSTSTORE_PATH);
            trustStore.store(outputStream, trustStorePass);
//            pks.store(fos, trustStorePass);
        } catch (Exception e) {
            throw new CertificateServiceException("Unable to save trust store to file.", e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    public synchronized KeyStore getKeyStore() {
        return trustStore;
    }

    /**
     * @param cert X509 certificate to be added to the trust store.
     * @param alias linked to the certificate and included in the keystore entry.
     */
    public synchronized void addTrustedCert(X509Certificate cert, String alias) {

        try {
            KeyStore.PasswordProtection kspp = new KeyStore.PasswordProtection(trustStorePass);
            KeyStore.TrustedCertificateEntry trust = new KeyStore.TrustedCertificateEntry(cert);
            trustStore.setEntry(alias, trust, null);
//            pks.setEntry(alias, trust, null);
            store();
        }        
        catch (Exception e) {
            throw new CertificateServiceException("Unable to save trust store to file.", e);
        }

    }
}