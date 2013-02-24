/**
 * 
 */
package org.connectopensource.interopgui.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.connectopensource.interopgui.controller.RegisterController;
import org.connectopensource.interopgui.dataobject.DocumentInfo;
import org.connectopensource.interopgui.dataobject.EndpointInfo;
import org.connectopensource.interopgui.dataobject.PatientInfo;
import org.connectopensource.interopgui.view.Certificate;
import org.connectopensource.interopgui.view.Endpoint;
import org.connectopensource.interopgui.view.Organization;
import org.connectopensource.interopgui.view.impl.CertificateImpl;

/**
 * @author msw
 * 
 */
@ManagedBean
public class Register {

    public enum CertificateType {
        CERT_REQ, CERT_TO_TRUST
    }

    private String alert = StringUtils.EMPTY;
    private String orgId = StringUtils.EMPTY;
    private String hcid = null;
    private String orgName = null;

    private List<Endpoint> endpoints = null;
    private Certificate certificate = null;
    private List<PatientInfo> patients = null;
    private List<DocumentInfo> documents = null;
    
    public Register() {
        
        endpoints = new ArrayList<Endpoint>();        
        certificate = new CertificateImpl();        
        patients = new ArrayList<PatientInfo>();
        documents = new ArrayList<DocumentInfo>();

    }
    
    /**
     * This method needs to be kicked off in a pre-render view event 
     */
    public void loadDetail() {
        Map<String, Object> sessionMap = null;
        
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            sessionMap = context.getExternalContext().getSessionMap();
            orgId = (String) context.getExternalContext().getSessionMap().get("organizationId");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!StringUtils.isBlank(orgId)) {
            System.out.println("OrgId:" + orgId + ":");
            loadOrganization(orgId);
            sessionMap.put("organizationId", StringUtils.EMPTY);
        } else {
            orgId = StringUtils.EMPTY;
        }
    }

    /**
     * @param orgId
     */
    private void loadOrganization(String orgId) {
        // TODO Auto-generated method stub
        RegisterController controller = new RegisterController();
        Organization org = controller.retrieveOrganization(orgId);
        
        orgId = org.getOrgId();
        hcid = org.getHCID();
        orgName = org.getOrgName();
        
        endpoints = org.getEndpoints();       
        certificate = org.getCertificate();        
        patients = org.getPatients();
        documents = org.getDocuments();
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
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
     * @return the patients
     */
    public List<PatientInfo> getPatients() {
        return patients;
    }

    /**
     * @return the patients
     */
    public List<DocumentInfo> getDocuments() {
        return documents;
    }

//    /**
//     * @param demographics the demographics to set
//     */
//    public void setDemographics(Patient demographics) {
//        this.demographics.setFirstName(demographics.getFirstName());
//        this.demographics.setLastName(demographics.getLastName());
//        this.demographics.setGender(demographics.getGender());
//        this.demographics.setDateOfBirth(demographics.getDateOfBirth());
//    }
//
//    /**
//     * @param document the document to set
//     */
//    public void setDocument(Document document) {
//        this.doc.setDocumentId(document.getDocumentId());
//        this.doc.setDocumentType(document.getDocumentType());
//        this.doc.setComment(document.getComment());
//    }

    public String saveInfo() {
        try {
            System.out.println("saveInfo, cert size: " + certificate.getFile());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RegisterController impl = new RegisterController();
        Long id = impl.saveInfo(hcid, orgName, certificate);

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("organizationId", String.valueOf(id));

        // redirect back so we can gather more data from the registration form (endpoints, patients, etc...)
        alert = "Organization information saved. Now add patients, documents, endpoints and direct endpoints.";
        return "RegisterInformation?faces-direct=true";
    }

    public String back() {
        return "ListInformation?faces-direct=true";
    }

    /**
     * @return the orgId
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * @return the alert
     */
    public String getAlert() {
        return alert;
    }
    
    
}
