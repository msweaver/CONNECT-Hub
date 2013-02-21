/**
 * 
 */
package org.connectopensource.interopgui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.connectopensource.interopgui.dataobject.CertificateInfo;
import org.connectopensource.interopgui.dataobject.OrganizationInfo;
import org.connectopensource.interopgui.services.CertificateService;
import org.connectopensource.interopgui.services.DataService;
import org.connectopensource.interopgui.services.EndpointService;
import org.connectopensource.interopgui.services.JceCertificateService;
import org.connectopensource.interopgui.view.Certificate;
import org.connectopensource.interopgui.view.Document;
import org.connectopensource.interopgui.view.Endpoint;
import org.connectopensource.interopgui.view.Patient;

/**
 * @author msw
 *
 */
public class RegisterImpl {

    public void saveInfo(String hcid, Certificate cert, Document doc, List<Endpoint> endpoints, Patient patient) {
        List<Document> documents = new ArrayList<Document>();
        documents.add(doc);
        List<Patient> patients = new ArrayList<Patient>();
        patients.add(patient);
        OrganizationInfo org = new OrganizationInfo(hcid, cert, patients, documents);
        
        saveOrganization(org);
        
        try {
            processCertificate(cert);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
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
        service.trustCertificate(certInfo);
    }

    /**
     * @param org
     */
    private void saveOrganization(OrganizationInfo org) {
        DataService service = null;
        //service.saveData(org);
    }
}
