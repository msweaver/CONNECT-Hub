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

/**
 * @author msw
 *
 */
public class RegisterImpl {

    public void saveInfo(String hcid, Certificate cert, DocumentInfo doc, List<Endpoint> endpoints, PatientInfo patient) {

        List<DocumentInfo> documents = new ArrayList<DocumentInfo>();
        documents.add(doc);
        List<PatientInfo> patients = new ArrayList<PatientInfo>();
        patients.add(patient);
        
        CertificateInfo certInfo = new CertificateInfo(cert);
        OrganizationInfo org = new OrganizationInfo(hcid, certInfo, patients, documents);        
        
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
            service.signCertificate(certInfo);                        
        } 
    }

    /**
     * @param org
     */
    private void saveOrganization(OrganizationInfo org) {
        DataService service = new JpaDataService();
        service.saveData(org);
    }
}
