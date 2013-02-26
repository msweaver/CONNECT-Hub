/**
 * 
 */
package org.connectopensource.interopgui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.connectopensource.interopgui.dataobject.CertificateInfo;
import org.connectopensource.interopgui.dataobject.DocumentInfo;
import org.connectopensource.interopgui.dataobject.OrganizationInfo;
import org.connectopensource.interopgui.dataobject.PatientInfo;
import org.connectopensource.interopgui.services.CertificateService;
import org.connectopensource.interopgui.services.DataService;
import org.connectopensource.interopgui.services.EndpointService;
import org.connectopensource.interopgui.services.JceCertificateService;
import org.connectopensource.interopgui.services.JpaDataService;
import org.connectopensource.interopgui.services.UddiEndpointService;
import org.connectopensource.interopgui.view.Certificate;
import org.connectopensource.interopgui.view.Certificate.CertificateType;
import org.connectopensource.interopgui.view.DirectEndpoint;
import org.connectopensource.interopgui.view.Endpoint;
import org.connectopensource.interopgui.view.Organization;
import org.connectopensource.interopgui.view.impl.CertificateImpl;
import org.connectopensource.interopgui.view.impl.DirectEndpointImpl;
import org.connectopensource.interopgui.view.impl.OrganizationImpl;

/**
 * @author msw
 *
 */
public class RegisterController {

    /**
     * @param hcid home community id
     * @param orgName organization name
     * @param cert certificate
     * @return id of the persisted org
     */
    public Long saveInfo(String hcid, String orgName, Certificate cert) {
        
        CertificateInfo certInfo = new CertificateInfo(cert);
        OrganizationInfo org = new OrganizationInfo(hcid, orgName, certInfo);        
        
        try {
            processCertificate(certInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return saveOrganization(org);
    }
    
    /**
     * Persist a new patient with an organization.
     * 
     * @param patient information to be persisted
     * @param orgId organization parent for this patient
     */
    public void savePatient(PatientInfo patient, String orgId)  {        
        DataService service = new JpaDataService();        
        service.addPatient(patient, orgId);        
    }

    /**
     * Persist a new patient with an organization.
     * @param document information to be persisted
     * @param orgId organization parent for this patient
     */
    public void saveDocument(DocumentInfo document, String orgId)  {        
        DataService service = new JpaDataService();        
        service.addDocument(document, orgId);        
    }
    
    /**
     * Persist a new endpoint with an organization.
     * @param document information to be persisted
     * @param orgId organization parent for this patient
     */
    public void saveEndpoint(Endpoint endpoint, String orgId)  {

        EndpointService endpointService = new UddiEndpointService();        

        OrganizationInfo orgInfo = retrieveOrgInfo(orgId);        
        Organization orgView = new OrganizationImpl();
        orgView.setHCID(orgInfo.getHomeCommunityId());
        orgView.setOrgName(orgInfo.getOrgName());
        orgView.setOrgId(orgInfo.getId().toString());

        endpointService.saveEndpoint(orgView, endpoint);
    }
    
    /**
     * @param cert
     * @throws IOException 
     */
    private void processCertificate(CertificateInfo certInfo) throws IOException {

        CertificateService service = new JceCertificateService();
        if (certInfo.getCertType() == CertificateType.CERT) {
            service.trustCertificate(certInfo);            
        } else if (certInfo.getCertType() == CertificateType.CERT_REQ) {
            CertificateInfo signedCert = service.signCertificate(certInfo);
            certInfo.setCertBytes(signedCert.getCertBytes());
        } 
    }

    /**
     * @param org to be saved.
     * @return id of newly persisted record.
     */
    private Long saveOrganization(OrganizationInfo org) {
        DataService service = new JpaDataService();
        return service.saveData(org);
    }

    /**
     * @param orgId
     * @return
     */
    public Organization retrieveOrganization(String orgId) {
        
        OrganizationInfo orgInfo = retrieveOrgInfo(orgId);
        Organization orgView = new OrganizationImpl();
        
        System.out.println("hcid: " + orgInfo.getHomeCommunityId());
        System.out.println("orgname: " + orgInfo.getOrgName());
        orgView.setHCID(orgInfo.getHomeCommunityId());
        orgView.setOrgName(orgInfo.getOrgName());
        orgView.setOrgId(orgInfo.getId().toString());
        
        CertificateInfo certInfo = orgInfo.getCertInfo();
        Certificate cert = new CertificateImpl(certInfo);
        orgView.setCertificate(cert);
        
        List<PatientInfo> patients = new ArrayList<PatientInfo>(orgInfo.getPatients().size());
        patients.addAll(orgInfo.getPatients());        
        orgView.setPatients(patients);
        
//        EndpointService endpointService = new UddiEndpointService();
//        orgView.setEndPoints(endpointService.getEndpoints(orgInfo.getHomeCommunityId()));

        // TODO: populate endpoints
        List<DirectEndpoint> directEndpoints = new ArrayList<DirectEndpoint>(orgInfo.getDirectEndpoints().size());
        directEndpoints.addAll(orgInfo.getDirectEndpoints());
        orgView.setDirectEndpoints(directEndpoints);
        
                
        List<DocumentInfo> documents = new ArrayList<DocumentInfo>(orgInfo.getDocuments().size());
        documents.addAll(orgInfo.getDocuments());        
        orgView.setDocuments(documents);
        
        return orgView;
    }

    /**
     * @param orgId
     * @return
     */
    private OrganizationInfo retrieveOrgInfo(String orgId) {
        DataService service = new JpaDataService();
        return service.getData(orgId);
    }

    /**
     * @param currentDirectEndpoint
     * @param orgId
     */
    public void saveDirectEndpoint(DirectEndpoint directEndpoint, String orgId) {
        DataService service = new JpaDataService();
        service.addDirectEndpoint((DirectEndpointImpl)directEndpoint, orgId);
}
}
