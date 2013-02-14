package org.connectopensource.interopgui.services;

import org.connectopensource.interopgui.dataobject.CertificateInfo;

/**
 * @author msw
 *
 */
public interface CertificateService {
    
    /**
     * Add certificate to the configured truststore for the connect gateway.
     * @param certificateInfo to be trusted.
     */
    public void trustCertificate(CertificateInfo certificateInfo);

    /**
     * Sign a certificate programmatically.
     * @param certificateInfo to be signed by the CONNECT Gateway CA 
     * @return signed certificate
     */
    public CertificateInfo signCertificate(CertificateInfo certificateInfo);
    
}
