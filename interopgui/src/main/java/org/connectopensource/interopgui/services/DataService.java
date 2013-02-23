/**
 * 
 */
package org.connectopensource.interopgui.services;

import java.util.List;

import org.connectopensource.interopgui.dataobject.OrganizationInfo;

/**
 * @author msw
 *
 */
public interface DataService {
    
    /**
     * @param org
     */
    public void saveData(OrganizationInfo org);
    
    /**
     * @return list of all Organization Info
     */
    public List<OrganizationInfo> getData();
    
    /**
     * @param homeCommunityId
     * @return list of organization info matching a home community.
     */
    public List<OrganizationInfo> getData(String homeCommunityId);

}
