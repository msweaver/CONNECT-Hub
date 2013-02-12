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
    
    public void saveData(OrganizationInfo org);
    public List<OrganizationInfo> getData();
    public List<OrganizationInfo> getData(String homeCommunityId);

}
