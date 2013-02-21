package org.connectopensource.interopgui.dataobject;

import java.io.IOException;
import java.net.URI;

import org.connectopensource.interopgui.view.Certificate;

/**
 * @author msw
 *
 */
public class CertificateInfo {
    
    private URI pathToCert;
    private URI pathToResult;
    private Certificate.CertificateType certType;
    private byte[] uploadedCert;
    private String alias;
    
    /**
     * Default constructor specifies a timestamp for an alias.
     */
    public CertificateInfo() {
        this.alias = String.valueOf(System.currentTimeMillis());
    }
    
    public CertificateInfo(Certificate cert) throws IOException {
        this.alias = String.valueOf(System.currentTimeMillis());
        this.certType = cert.getCertType();
        this.pathToCert = cert.getPathToCert();
        this.pathToResult = cert.getPathToResult();
        this.uploadedCert = cert.getFile().getBytes();
    }

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
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#getFile()
     */
    public byte[] getUploadedCert() {
        return uploadedCert;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#setFile(org.apache.myfaces.custom.fileupload.UploadedFile)
     */
    public void setUploadedCert(byte[] uploadedCert) {
        this.uploadedCert = uploadedCert;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#getPathToResult()
     */
    public URI getPathToResult() {
        return pathToResult;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#setPathToResult(java.net.URI)
     */
    public void setPathToResult(URI pathToResult) {
        this.pathToResult = pathToResult;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#getCertType()
     */
    public Certificate.CertificateType getCertType() {
        return certType;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#setCertType(org.connectopensource.interopgui.view.Certificate.CertificateType)
     */
    public void setCertType(Certificate.CertificateType certType) {
        this.certType = certType;
    }
}
