/**
 * 
 */
package org.connectopensource.interopgui.services;

import java.util.List;

import org.connectopensource.interopgui.dataobject.EndpointInfo;

/**
 * @author msw
 *
 */
public interface EndpointService {
    
    public void saveEndpoint(EndpointInfo endpoint);
    public List<EndpointInfo> getEndpoints(String homeCommunityId);
    public List<EndpointInfo> getAllEndpoints();

}
