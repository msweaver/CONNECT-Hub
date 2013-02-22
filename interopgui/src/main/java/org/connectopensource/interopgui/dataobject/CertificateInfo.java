package org.connectopensource.interopgui.dataobject;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import org.connectopensource.interopgui.services.CertificateServiceException;
import org.connectopensource.interopgui.view.Certificate;

/**
 * @author msw
 *
 */
@Embeddable 
public class CertificateInfo {
    
    private Certificate.CertificateType certType;
    private byte[] certBytes;
    private String alias;
    
    /**
     * Default constructor specifies a timestamp for an alias.
     */
    public CertificateInfo() {
        this.alias = String.valueOf(System.currentTimeMillis());
    }
    
    public CertificateInfo(Certificate cert) {
        this.alias = String.valueOf(System.currentTimeMillis());
        this.certType = cert.getCertType();
        try {
            this.certBytes = cert.getFile().getBytes();
        } catch (IOException e) { 
            throw new CertificateServiceException("Error getting bytes from UploadedFile.", e);
        }
    }

    /**
     * @return the alias
     */
    @Column(name = "alias")
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
    @Lob
    @Column(name = "cert")
    public byte[] getCertBytes() {
        return certBytes;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#setFile(org.apache.myfaces.custom.fileupload.UploadedFile)
     */
    public void setCertBytes(byte[] uploadedCert) {
        this.certBytes = uploadedCert;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Certificate#getCertType()
     */
    @Column(name="certtype")
    @Enumerated(EnumType.STRING)
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
