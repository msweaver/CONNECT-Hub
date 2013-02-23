package org.connectopensource.interopgui.view.impl;

import java.net.URI;

import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.connectopensource.interopgui.dataobject.CertificateInfo;
import org.connectopensource.interopgui.view.Certificate;

/**
 * @author msw
 *
 */
public class CertificateImpl implements Certificate {
    
    private URI pathToCert;
    private URI pathToResult;
    private CertificateType certType;
    private UploadedFile file;
    private String alias;
    
    public CertificateType[] getCertificateTypes()
    {
        return CertificateType.values();
    }
    
    /**
     * Default constructor specifies a timestamp for an alias.
     */
    public CertificateImpl() {
        super();
        this.alias = String.valueOf(System.currentTimeMillis());
    }

    /**
     * @param certInfo
     */
    public CertificateImpl(CertificateInfo certInfo) {
        alias = certInfo.getAlias();
        //TODO: certInfo.getCertBytes();
        certType = certInfo.getCertType();
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
    @Override
    public UploadedFile getFile() {
        return file;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#setFile(org.apache.myfaces.custom.fileupload.UploadedFile)
     */
    @Override
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#getPathToResult()
     */
    @Override
    public URI getPathToResult() {
        return pathToResult;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#setPathToResult(java.net.URI)
     */
    @Override
    public void setPathToResult(URI pathToResult) {
        this.pathToResult = pathToResult;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#getCertType()
     */
    @Override
    public CertificateType getCertType() {
        return certType;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#setCertType(org.connectopensource.interopgui.view.Certificate.CertificateType)
     */
    @Override
    public void setCertType(CertificateType certType) {
        this.certType = certType;
    }
}
