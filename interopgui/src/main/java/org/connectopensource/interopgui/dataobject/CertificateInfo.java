/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

import java.net.URI;

/**
 * @author msw
 *
 */
public class CertificateInfo {
    
    public enum CertificateType { CERT, CERT_REQ }
    
    private URI pathToCert;
    private URI pathToResult;
    
    private CertificateType certType;
    
    /**
     * @return the pathToCert
     */
    public URI getPathToCert() {
        return pathToCert;
    }
    /**
     * @param pathToCert the pathToCert to set
     */
    public void setPathToCert(URI pathToCert) {
        this.pathToCert = pathToCert;
    }
    /**
     * @return the pathToResult
     */
    public URI getPathToResult() {
        return pathToResult;
    }
    /**
     * @param pathToResult the pathToResult to set
     */
    public void setPathToResult(URI pathToResult) {
        this.pathToResult = pathToResult;
    }
    /**
     * @return the certType
     */
    public CertificateType getCertType() {
        return certType;
    }
    /**
     * @param certType the certType to set
     */
    public void setCertType(CertificateType certType) {
        this.certType = certType;
    }

}
