/**
 * 
 */
package org.connectopensource.interopgui.services;

import org.connectopensource.interopgui.dataobject.CertificateInfo;

/**
 * @author msw
 *
 */
public interface CertificateService {
    
    public void trustCertificate(CertificateInfo certInfo);
}
