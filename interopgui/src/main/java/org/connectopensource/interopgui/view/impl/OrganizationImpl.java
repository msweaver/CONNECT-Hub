/**
 * 
 */
package org.connectopensource.interopgui.view.impl;

import java.util.ArrayList;
import java.util.List;

import org.connectopensource.interopgui.dataobject.DocumentInfo;
import org.connectopensource.interopgui.dataobject.PatientInfo;
import org.connectopensource.interopgui.view.Certificate;
import org.connectopensource.interopgui.view.Endpoint;
import org.connectopensource.interopgui.view.Organization;

/**
 * @author msw
 *
 */
public class OrganizationImpl implements Organization {

    private List<Endpoint> endpoints = null;
    private Certificate cert = null;
    
    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Organization#getEndpoints()
     */
    @Override
    public List<Endpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new ArrayList<Endpoint>();
        }
        return endpoints;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Organization#getCertificate()
     */
    @Override
    public Certificate getCertificate() {
        return cert;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Organization#setCertificate(org.connectopensource.interopgui.view.Certificate)
     */
    @Override
    public void setCertificate(Certificate cert) {
        this.cert = cert;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Organization#getDocuments()
     */
    @Override
    public DocumentInfo getDocuments() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Organization#setDocuments(org.connectopensource.interopgui.dataobject.DocumentInfo)
     */
    @Override
    public void setDocuments(DocumentInfo doc) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Organization#getPatients()
     */
    @Override
    public PatientInfo getPatients() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Organization#setPatients(org.connectopensource.interopgui.dataobject.PatientInfo)
     */
    @Override
    public void setPatients(PatientInfo patient) {
        // TODO Auto-generated method stub

    }

}
