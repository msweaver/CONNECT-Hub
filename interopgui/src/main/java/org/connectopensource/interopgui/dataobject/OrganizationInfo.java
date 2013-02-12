/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author msw
 *
 */
public class OrganizationInfo {
    
    String homeCommunityId;
    List<PatientInfo> patients;
    List<DocumentInfo> documents;
    CertificateInfo cert;
    
    public OrganizationInfo() {
        patients = new ArrayList<PatientInfo>();
        documents = new ArrayList<DocumentInfo>();
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
    public CertificateInfo getCert() {
        return cert;
    }

    /**
     * @param cert the cert to set
     */
    public void setCert(CertificateInfo cert) {
        this.cert = cert;
    }

    /**
     * @return the patients
     */
    public List<PatientInfo> getPatients() {
        return patients;
    }

    /**
     * @return the documents
     */
    public List<DocumentInfo> getDocuments() {
        return documents;
    }
    
    

}
