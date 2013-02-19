/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

import java.util.ArrayList;
import java.util.List;

import org.connectopensource.interopgui.view.Certificate;
import org.connectopensource.interopgui.view.Document;
import org.connectopensource.interopgui.view.Patient;

/**
 * @author msw
 *
 */
public class OrganizationInfo {
    
    String homeCommunityId;
    List<Patient> patients;
    List<Document> documents;
    Certificate cert;
    
    public OrganizationInfo() {
        patients = new ArrayList<Patient>();
        documents = new ArrayList<Document>();
    }
    
    public OrganizationInfo(String homeCommunityId, Certificate cert, List<Patient> patients, List<Document> doc) {
        this.homeCommunityId = homeCommunityId;
        this.cert = cert;
        
        this.patients = new ArrayList<Patient>();
        this.patients.addAll(patients);
        
        this.documents = new ArrayList<Document>();
        this.documents.addAll(documents);
    }

    /**
     * @return the homeCommunityId
     */
    public String getHomeCommunityId() {
        return homeCommunityId;
    }

    /**
     * @param homeCommunityId the homeCommunityId to set
     */
    public void setHomeCommunityId(String homeCommunityId) {
        this.homeCommunityId = homeCommunityId;
    }

    /**
     * @return the cert
     */
    public Certificate getCert() {
        return cert;
    }

    /**
     * @param cert the cert to set
     */
    public void setCert(Certificate cert) {
        this.cert = cert;
    }

    /**
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }
    
    

}
