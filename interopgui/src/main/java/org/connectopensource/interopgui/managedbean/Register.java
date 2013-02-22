/**
 * 
 */
package org.connectopensource.interopgui.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.connectopensource.interopgui.controller.RegisterImpl;
import org.connectopensource.interopgui.dataobject.DocumentInfo;
import org.connectopensource.interopgui.dataobject.EndpointInfo;
import org.connectopensource.interopgui.dataobject.PatientInfo;
import org.connectopensource.interopgui.view.Certificate;
import org.connectopensource.interopgui.view.Document;
import org.connectopensource.interopgui.view.Endpoint;
import org.connectopensource.interopgui.view.Patient;
import org.connectopensource.interopgui.view.impl.CertificateImpl;

/**
 * @author msw
 *
 */
@ManagedBean
public class Register {

    public enum CertificateType { CERT_REQ, CERT_TO_TRUST }
    private String hcid = null;
    
    private List<Endpoint> endpoints = null;
    
    private Certificate certificate = null;

    private PatientInfo demographics = null;    
    private DocumentInfo doc = null;
    
    public Register() {        
        endpoints = new ArrayList<Endpoint>();        
        certificate = new CertificateImpl();        
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
     * 
     */
    public Endpoint getEndpoint() {
        return new EndpointInfo();
    }
    /**
     * 
     */
    public void setEndpoint(Endpoint endpoint) {
        endpoints.add(endpoint);
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
        this.demographics.setFirstName(demographics.getFirstName());
        this.demographics.setLastName(demographics.getLastName());
        this.demographics.setGender(demographics.getGender());
        this.demographics.setDateOfBirth(demographics.getDateOfBirth());
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
        this.doc.setDocumentId(document.getDocumentId());
        this.doc.setDocumentType(document.getDocumentType());
        this.doc.setComment(document.getComment());
    }
    
    public String saveInfo() {
        System.out.println("saveInfo, hcid: " + hcid);
                
        System.out.println("saveInfo, first name:" + demographics.getFirstName());
        System.out.println("saveInfo, last name:" + demographics.getLastName());
        System.out.println("saveInfo, dob:" + demographics.getDateOfBirth());
        System.out.println("saveInfo, gender:" + demographics.getGender());
        
        System.out.println("saveInfo, doc id:" + doc.getDocumentId());
        System.out.println("saveInfo, doc type:" + doc.getDocumentType());
        System.out.println("saveInfo, doc comment:" + doc.getComment());
        
        try {
            System.out.println("saveInfo, cert size: " + certificate.getFile());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        RegisterImpl impl = new RegisterImpl();
        impl.saveInfo(hcid, certificate, doc, endpoints, demographics);
        return "ListInformation?faces-direct=true";
    }
}
