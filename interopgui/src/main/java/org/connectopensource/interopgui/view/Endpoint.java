/**
 * 
 */
package org.connectopensource.interopgui.view;

import org.connectopensource.interopergui.managedbean.Register;

/**
 * @author msw
 *
 */
public interface Endpoint {
    public Register.SpecVersion getSpecVersion();
    public void setSpecVersion(Register.SpecVersion version);
    
    public String getEndpoint();
    public void setEndpoint(String endpoint);
}
