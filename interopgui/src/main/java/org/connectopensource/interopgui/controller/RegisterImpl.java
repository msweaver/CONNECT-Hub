/**
 * 
 */
package org.connectopensource.interopgui.controller;

import java.util.ArrayList;
import java.util.List;

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
        
        processCertificate(cert);
        
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
     */
    private void processCertificate(Certificate cert) {
        CertificateService service = new JceCertificateService();
        service.trustCertificate(cert);
    }

    /**
     * @param org
     */
    private void saveOrganization(OrganizationInfo org) {
        DataService service = null;
        //service.saveData(org);
    }
}
