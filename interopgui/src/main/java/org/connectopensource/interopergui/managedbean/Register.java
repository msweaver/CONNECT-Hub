/**
 * 
 */
package org.connectopensource.interopergui.managedbean;

import javax.faces.bean.ManagedBean;

import org.connectopensource.interopgui.view.Endpoint;
import org.connectopensource.interopgui.view.EndpointImpl;

/**
 * @author msw
 *
 */
@ManagedBean
public class Register {
    
    public enum SpecVersion { JAN_2010, SUMMER_2011 }
    public enum CertificateType { CERT_REQ, CERT_TO_TRUST }
    private String hcid = null;
    
    private Endpoint PDEndpoint = null;
    private Endpoint DQEndpoint = null;
    private Endpoint DREndpoint = null;
    private Endpoint DSEndpoint = null;
    private Endpoint ADEndpoint = null;
    
    private CertificateType certType;
    private String certPath = null;
    
    private String firstName = null;
    private String lastName = null;
    private String DoB = null;
    private String gender = null;
    
    private String documentUniqueId = null;
    private String documentType = null;
    private String documentComment = null;
    
    public Register() {
        PDEndpoint = new EndpointImpl();
    }
    
    /**
     * @return the hcid
     */
    public String getHcid() {
        return hcid;
    }
    /**
     * @param hcid the hcid to set
     */
    public void setHcid(String hcid) {
        this.hcid = hcid;
    }
    /**
     * @return the PDEndpoint
     */
    public Endpoint getPDEndpoint() {
        return PDEndpoint;
    }
    /**
     * @param pDEndpoint the pDEndpoint to set
     */
    public void setPDEndpoint(Endpoint PDEndpoint) {
        this.PDEndpoint = PDEndpoint;
    }
    /**
     * @return the DQEndpoint
     */
    public Endpoint getDQEndpoint() {
        return DQEndpoint;
    }
    /**
     * @param DQEndpoint the DQEndpoint to set
     */
    public void setDQEndpoint(Endpoint DQEndpoint) {
        this.DQEndpoint = DQEndpoint;
    }
    /**
     * @return the DREndpoint
     */
    public Endpoint getDREndpoint() {
        return DREndpoint;
    }
    /**
     * @param DREndpoint the DREndpoint to set
     */
    public void setDREndpoint(Endpoint DREndpoint) {
        this.DREndpoint = DREndpoint;
    }
    /**
     * @return the DSEndpoint
     */
    public Endpoint getDSEndpoint() {
        return DSEndpoint;
    }
    /**
     * @param DSEndpoint the DSEndpoint to set
     */
    public void setDSEndpoint(Endpoint DSEndpoint) {
        this.DSEndpoint = DSEndpoint;
    }
    /**
     * @return the ADEndpoint
     */
    public Endpoint getADEndpoint() {
        return ADEndpoint;
    }
    /**
     * @param ADEndpoint the ADEndpoint to set
     */
    public void setADEndpoint(Endpoint ADEndpoint) {
        PDEndpoint = ADEndpoint;
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
    /**
     * @return the certPath
     */
    public String getCertPath() {
        return certPath;
    }
    /**
     * @param certPath the certPath to set
     */
    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return the doB
     */
    public String getDoB() {
        return DoB;
    }
    /**
     * @param doB the doB to set
     */
    public void setDoB(String doB) {
        DoB = doB;
    }
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * @return the documentUniqueId
     */
    public String getDocumentUniqueId() {
        return documentUniqueId;
    }
    /**
     * @param documentUniqueId the documentUniqueId to set
     */
    public void setDocumentUniqueId(String documentUniqueId) {
        this.documentUniqueId = documentUniqueId;
    }
    /**
     * @return the documentType
     */
    public String getDocumentType() {
        return documentType;
    }
    /**
     * @param documentType the documentType to set
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
    /**
     * @return the documentComment
     */
    public String getDocumentComment() {
        return documentComment;
    }
    /**
     * @param documentComment the documentComment to set
     */
    public void setDocumentComment(String documentComment) {
        this.documentComment = documentComment;
    }
    
    public String saveInfo() {
        System.out.println("saveInfo, hcid: " + hcid);
        System.out.println("saveInfo, pd version: " + PDEndpoint.getSpecVersion());
        System.out.println("saveInfo, pd endpoint: " + PDEndpoint.getEndpoint());
        return "";
    }
}
