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

    /**
     * @param homeCommunityId
     */
    public String getHCID();
    
    /**
     * @param homeCommunityId
     */
    public void setHCID(String homeCommunityId);

    /**
     * @param orgName
     */
    public String getOrgName();
    
    /**
     * @param orgName
     */
    public void setOrgName(String orgName);
    
    /**
     * @param orgName
     */
    public String getOrgId();
    
    /**
     * @param orgName
     */
    public void setOrgId(String orgId);

}
