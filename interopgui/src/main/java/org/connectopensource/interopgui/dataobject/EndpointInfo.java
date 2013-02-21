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
    private Specification spec;
    
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

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#getSpecification()
     */
    @Override
    public Specification getSpecification() {
        return spec;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#setSpecification(org.connectopensource.interopgui.view.Endpoint.Specification)
     */
    @Override
    public void setSpecification(Specification spec) {
        this.spec = spec;
    }
}
