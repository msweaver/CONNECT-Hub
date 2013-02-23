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
import org.connectopensource.interopgui.view.Certificate;
import org.connectopensource.interopgui.view.Certificate.CertificateType;
import org.connectopensource.interopgui.view.Endpoint;
import org.connectopensource.interopgui.view.Organization;
import org.connectopensource.interopgui.view.impl.CertificateImpl;
import org.connectopensource.interopgui.view.impl.OrganizationImpl;

/**
 * @author msw
 *
 */
public class RegisterController {

    public void saveInfo(String hcid, String orgName, Certificate cert, DocumentInfo doc, List<Endpoint> endpoints,
            PatientInfo patient) {

        List<DocumentInfo> documents = new ArrayList<DocumentInfo>();
        documents.add(doc);
        List<PatientInfo> patients = new ArrayList<PatientInfo>();
        patients.add(patient);
        
        CertificateInfo certInfo = new CertificateInfo(cert);
        OrganizationInfo org = new OrganizationInfo(hcid, orgName, certInfo, patients, documents);        
        
        // set the org info on the patient and document data so they are also persisted...
        doc.setOrganizationInfo(org);
        patient.setOrganizationInfo(org);
        
        try {
            processCertificate(cert);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        saveOrganization(org);
        
        saveEndpoints(endpoints);
    }

    /**
     * @param endpoints
     */
    private void saveEndpoints(List<Endpoint> endpoints) {
        EndpointService service = null;
        //service.saveEndpoints(endpoints);
    }

    /**
     * @param cert
     * @throws IOException 
     */
    private void processCertificate(Certificate cert) throws IOException {

        CertificateService service = new JceCertificateService();
        CertificateInfo certInfo = new CertificateInfo(cert);
        
        if (cert.getCertType() == CertificateType.CERT) {
            service.trustCertificate(certInfo);            
        } else if (cert.getCertType() == CertificateType.CERT_REQ) {
            CertificateInfo signedCert = service.signCertificate(certInfo);
            certInfo.setCertBytes(signedCert.getCertBytes());
        } 
    }

    /**
     * @param org
     */
    private void saveOrganization(OrganizationInfo org) {
        DataService service = new JpaDataService();
        service.saveData(org);
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
        
        // TODO: populate patients
        
        // TODO: populate endpoints
        
        // TODO: populate documents
        
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
}
