/**
 * 
 */
package org.connectopensource.interopgui.services;

import java.util.List;

import org.connectopensource.interopgui.view.Endpoint;

/**
 * @author msw
 *
 */
public interface EndpointService {
    
    public void saveEndpoint(Endpoint endpoint);
    public void saveEndpoints(List<Endpoint> endpoints);
    public List<Endpoint> getEndpoints(String homeCommunityId);
 
}
