package org.connectopensource.interopgui.dataobject;

import java.net.URI;

/**
 * @author msw
 *
 */
public final class CertificateInfo {
    
    private URI pathToCert;
    private String alias;
    
    /**
     * Default constructor specifies a timestamp for an alias.
     */
    public CertificateInfo() {
        super();
        this.alias = new Long(System.currentTimeMillis()).toString();
    }

    /**
     * @return the pathToCert
     */
    public URI getPathToCert() {
        return pathToCert;
    }
    
    /**
     * @param pathToCert the pathToCert to set
     */
    public void setPathToCert(URI pathToCert) {
        this.pathToCert = pathToCert;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
}
