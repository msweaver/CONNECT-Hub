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
    public enum Specification { PATIENT_DISCOVERY, DOCUMENT_QUERY, DOCUMENT_RETRIEVE, DOCUMENT_SUBMISSION, ADMINISTRATIVE_DISTRIBUTION }
    
    public SpecVersion[] getSpecVersions();
    
    public Specification getSpecification();
    public void setSpecification(Specification spec);
    
    public SpecVersion getSpecVersion();
    public void setSpecVersion(SpecVersion version);
    
    public String getEndpoint();
    public void setEndpoint(String endpoint);
}
