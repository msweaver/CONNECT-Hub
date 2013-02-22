/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author msw
 */
@Entity
@Table(name="orginfo")
public class OrganizationInfo {
    
    Long id;
    String homeCommunityId;        
    List<PatientInfo> patients;
    List<DocumentInfo> documents;
    CertificateInfo certInfo;
    
    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public OrganizationInfo() {
        patients = new ArrayList<PatientInfo>();
        documents = new ArrayList<DocumentInfo>();
    }

    public OrganizationInfo(String homeCommunityId, CertificateInfo certInfo, List<PatientInfo> patients,
            List<DocumentInfo> documents) {

        this.homeCommunityId = homeCommunityId;
        this.certInfo = certInfo;
        
        this.patients = new ArrayList<PatientInfo>();
        this.patients.addAll(patients);
        
        this.documents = new ArrayList<DocumentInfo>();
        this.documents.addAll(documents);
    }

    /**
     * @return the homeCommunityId
     */
    @Column(name = "hcid")
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
    @Embedded
    public CertificateInfo getCertInfo() {
        return certInfo;
    }

    /**
     * @param cert the cert to set
     */
    public void setCertInfo(CertificateInfo certInfo) {
        this.certInfo = certInfo;
    }

    /**
     * @return the patients
     */
    @OneToMany(mappedBy="organizationInfo")
    public List<PatientInfo> getPatients() {
        return patients;
    }

    /**
     * @return the documents
     */
    @OneToMany(mappedBy="organizationInfo")
    public List<DocumentInfo> getDocuments() {
        return documents;
    }

    /**
     * @param patients the patients to set
     */
    public void setPatients(List<PatientInfo> patients) {
        this.patients = patients;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<DocumentInfo> documents) {
        this.documents = documents;
    }
    
    

}
