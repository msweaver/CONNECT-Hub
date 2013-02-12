/**
 * 
 */
package org.connectopensource.interopgui.dataobject;

/**
 * @author msw
 *
 */
public class EndpointInfo {
    
    public enum SpecVersion { JAN_2010, SUMMER_2011 }
    
    private String endpoint;
    private SpecVersion version;
    
    /**
     * @return the endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }
    /**
     * @param endpoint the endpoint to set
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    /**
     * @return the version
     */
    public SpecVersion getVersion() {
        return version;
    }
    /**
     * @param version the version to set
     */
    public void setVersion(SpecVersion version) {
        this.version = version;
    }

}
