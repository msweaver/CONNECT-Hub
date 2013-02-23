/**
 * 
 */
package org.connectopensource.interopgui.view;

import java.util.List;

import org.connectopensource.interopgui.dataobject.DocumentInfo;
import org.connectopensource.interopgui.dataobject.PatientInfo;

/**
 * @author msw
 *
 */
public interface Organization {

    /**
     * @return
     */
    public List<Endpoint> getEndpoints();

    /**
     * @return
     */
    public Certificate getCertificate();
    
    /**
     * @return
     */
    public void setCertificate(Certificate cert);

    /**
     * @return
     */
    public DocumentInfo getDocuments();
    
    /**
     * @return
     */
    public void setDocuments(DocumentInfo doc);

    /**
     * @return
     */
    public PatientInfo getPatients();
    
    /**
     * @return
     */
    public void setPatients(PatientInfo patient);

}
