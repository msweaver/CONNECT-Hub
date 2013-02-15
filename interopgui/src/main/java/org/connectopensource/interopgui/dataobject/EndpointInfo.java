/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

import org.connectopensource.interopgui.view.Endpoint;

/**
 * @author msw
 *
 */
public class EndpointInfo implements Endpoint {
    
    private SpecVersion specVersion;
    private String endpoint;
    
    public SpecVersion[] getSpecVersions() {
        return SpecVersion.values();
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interoperabilityshowcasegui.view.Endpoint#getSpecVersion()
     */
    @Override
    public SpecVersion getSpecVersion() {
        return specVersion;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interoperabilityshowcasegui.view.Endpoint#setSpecVersion(org.connectopensource.interoperabilityshowcasegui.managedbean.Register.SpecVersion)
     */
    @Override
    public void setSpecVersion(SpecVersion version) {
        this.specVersion = version;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interoperabilityshowcasegui.view.Endpoint#getEndpoint()
     */
    @Override
    public String getEndpoint() {
        return endpoint;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interoperabilityshowcasegui.view.Endpoint#setEndpoint(java.lang.String)
     */
    @Override
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
