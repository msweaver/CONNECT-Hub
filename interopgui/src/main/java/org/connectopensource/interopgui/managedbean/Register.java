/**
 * 
 */
package org.connectopensource.interopgui.managedbean;

import javax.faces.bean.ManagedBean;

import org.connectopensource.interopgui.dataobject.CertificateInfo;
import org.connectopensource.interopgui.dataobject.DocumentInfo;
import org.connectopensource.interopgui.dataobject.EndpointInfo;
import org.connectopensource.interopgui.dataobject.PatientInfo;
import org.connectopensource.interopgui.view.Certificate;
import org.connectopensource.interopgui.view.Document;
import org.connectopensource.interopgui.view.Endpoint;
import org.connectopensource.interopgui.view.Patient;

/**
 * @author msw
 *
 */
@ManagedBean
public class Register {

    public enum CertificateType { CERT_REQ, CERT_TO_TRUST }
    private String hcid = null;
    
    private Endpoint PDEndpoint = null;
    private Endpoint DQEndpoint = null;
    private Endpoint DREndpoint = null;
    private Endpoint DSEndpoint = null;
    private Endpoint ADEndpoint = null;
    
    private Certificate certificate = null;

    private Patient demographics = null;
    
    private Document doc = null;
    
    public Register() {
        PDEndpoint = new EndpointInfo();
        DQEndpoint = new EndpointInfo();
        DREndpoint = new EndpointInfo();
        DSEndpoint = new EndpointInfo();
        ADEndpoint = new EndpointInfo();
        
        certificate = new CertificateInfo();
        
        demographics = new PatientInfo();
        
        doc = new DocumentInfo();
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
     * @return the certificate
     */
    public Certificate getCertificate() {
        return certificate;
    }
    /**
     * @param certificate the certificate to set
     */
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
    /**
     * @return the demographics
     */
    public Patient getDemographics() {
        return demographics;
    }
    /**
     * @param demographics the demographics to set
     */
    public void setDemographics(Patient demographics) {
        this.demographics = demographics;
    }
    /**
     * @return the document
     */
    public Document getDocument() {
        return doc;
    }
    /**
     * @param document the document to set
     */
    public void setDocument(Document document) {
        this.doc = document;
    }
    
    public String saveInfo() {
        System.out.println("saveInfo, hcid: " + hcid);
        System.out.println("saveInfo, pd version: " + PDEndpoint.getSpecVersion());
        System.out.println("saveInfo, pd endpoint: " + PDEndpoint.getEndpoint());
        System.out.println("saveInfo, dq version: " + DQEndpoint.getSpecVersion());
        System.out.println("saveInfo, dq endpoint: " + DQEndpoint.getEndpoint());
        System.out.println("saveInfo, dr version: " + DREndpoint.getSpecVersion());
        System.out.println("saveInfo, dr endpoint: " + DREndpoint.getEndpoint());
        System.out.println("saveInfo, ds version: " + DSEndpoint.getSpecVersion());
        System.out.println("saveInfo, ds endpoint: " + DSEndpoint.getEndpoint());
        System.out.println("saveInfo, ad version: " + ADEndpoint.getSpecVersion());
        System.out.println("saveInfo, ad endpoint: " + ADEndpoint.getEndpoint());
        
        System.out.println("saveInfo, cert type:" + certificate.getCertType());
        System.out.println("saveInfo, cert path:" + certificate.getPathToCert());
        
        System.out.println("saveInfo, first name:" + demographics.getFirstName());
        System.out.println("saveInfo, last name:" + demographics.getLastName());
        System.out.println("saveInfo, dob:" + demographics.getDateOfBirth());
        System.out.println("saveInfo, gender:" + demographics.getGender());
        
        System.out.println("saveInfo, doc id:" + doc.getDocumentId());
        System.out.println("saveInfo, doc type:" + doc.getDocumentType());
        System.out.println("saveInfo, doc comment:" + doc.getComment());
        return "";
    }
}
