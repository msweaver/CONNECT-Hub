package org.connectopensource.interopgui.services;

import org.connectopensource.interopgui.view.Certificate;

/**
 * @author msw
 *
 */
public interface CertificateService {
    
    /**
     * Add certInfo to the configured truststore for the connect gateway.
     * @param certInfo containing cert to be trusted.
     */
    void trustCertificate(Certificate certInfo);

    /**
     * Sign a certificate programmatically.
     * @param certInfo to be signed by the CONNECT Gateway CA 
     * @return signed certificate
     */
    Certificate signCertificate(Certificate certInfo);
}
