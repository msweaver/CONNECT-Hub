/**
 * 
 */
package org.connectopensource.interopgui.view;

/**
 * @author msw
 *
 */
public interface Endpoint {
    
    public enum SpecVersion { JAN_2010, SUMMER_2011 }
    public SpecVersion[] getSpecVersions();
    
    public SpecVersion getSpecVersion();
    public void setSpecVersion(SpecVersion version);
    
    public String getEndpoint();
    public void setEndpoint(String endpoint);
}
