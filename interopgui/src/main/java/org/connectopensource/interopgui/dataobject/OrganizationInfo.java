/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.connectopensource.interopgui.view.impl.DirectEndpointImpl;
import org.connectopensource.interopgui.view.impl.EndpointImpl;

/**
 * @author msw
 */
@Entity
@Table(name="orginfo")
public class OrganizationInfo {
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OrganizationInfo [id=" + id + ", homeCommunityId=" + homeCommunityId + ", orgName=" + orgName
                + ", patients=" + patients + ", documents=" + documents + ", certInfo=" + certs
                + ", directEndpoints=" + directEndpoints + ", endpoints=" + endpoints + "]";
    }

    Long id;
    String homeCommunityId;        
    String orgName;
    Set<PatientInfo> patients;
    Set<DocumentInfo> documents;
    Set<CertificateInfo> certs;
    Set<DirectEndpointImpl> directEndpoints;
    Set<EndpointImpl> endpoints;
    
    /**
     * @return the directEndpoints
     */
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="organizationInfo", fetch = FetchType.EAGER)
    public Set<DirectEndpointImpl> getDirectEndpoints() {
        return directEndpoints;
    }

    /**
     * @param directEndpoints the directEndpoints to set
     */
    public void setDirectEndpoints(Set<DirectEndpointImpl> directEndpoints) {
        this.directEndpoints = directEndpoints;
    }

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
        patients = new HashSet<PatientInfo>();
        documents = new HashSet<DocumentInfo>();
    }

    /**
     * @param homeCommunityId
     * @param orgName
     * @param certInfo
     */
    public OrganizationInfo(String homeCommunityId, String orgName, Set<CertificateInfo> certs) {

        this.homeCommunityId = homeCommunityId;
        this.orgName = orgName;
        this.certs = certs;

        this.patients = new HashSet<PatientInfo>();
        this.documents = new HashSet<DocumentInfo>();
    }

    /**
     * @return the directCertInfo
     */
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="organizationInfo", fetch = FetchType.EAGER)
    public Set<CertificateInfo> getCertificates() {
        return certs;
    }

    /**
     * @param directCertInfo the directCertInfo to set
     */
    public void setCertificates(Set<CertificateInfo> certs) {
        this.certs = certs;
    }

    public OrganizationInfo(String homeCommunityId, String orgName, Set<CertificateInfo> certs,
            List<PatientInfo> patients, List<DocumentInfo> documents) {

        this.homeCommunityId = homeCommunityId;
        this.orgName = orgName;
        this.certs = certs;

        this.patients = new HashSet<PatientInfo>();
        this.patients.addAll(patients);

        this.documents = new HashSet<DocumentInfo>();
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
     * @return the orgName
     */
    @Column(name = "orgname")
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
     * @return the patients
     */
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="organizationInfo", fetch = FetchType.EAGER)    
    public Set<PatientInfo> getPatients() {
        return patients;
    }

    /**
     * @param patients the patients to set
     */
    public void setPatients(Set<PatientInfo> patients) {
        this.patients = patients;
    }

    /**
     * @return the documents
     */
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="organizationInfo", fetch = FetchType.EAGER)
    public Set<DocumentInfo> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(Set<DocumentInfo> documents) {
        this.documents = documents;
    }
    
    /**
     * @return the endpoints
     */
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="organizationInfo", fetch = FetchType.EAGER)  
    public Set<EndpointImpl> getEndpoints() {
        return endpoints;
    }

    /**
     * @param endpoints the endpoints to set
     */
    public void setEndpoints(Set<EndpointImpl> endpoints) {
        this.endpoints = endpoints;
    }


}
