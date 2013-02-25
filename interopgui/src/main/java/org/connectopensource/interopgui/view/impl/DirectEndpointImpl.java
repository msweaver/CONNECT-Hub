/**
 * 
 */
package org.connectopensource.interopgui.view.impl;

import org.connectopensource.interopgui.view.DirectEndpoint;

/**
 * @author msw
 *
 */
public class DirectEndpointImpl implements DirectEndpoint {
    
    private String endpoint = null;
    private boolean dnsDomainBound = false;
    private boolean dnsAddressBound = false;
    private boolean ldapDomainBound = false;
    private boolean ldapAddressBound = false;

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#getEndpoint()
     */
    @Override
    public String getEndpoint() {
        return endpoint;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#setEndpoint(java.lang.String)
     */
    @Override
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#getDnsAddressBound()
     */
    @Override
    public boolean getDnsAddressBound() {
        return dnsAddressBound;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#setDnsAddressBound(boolean)
     */
    @Override
    public void setDnsAddressBound(boolean dnsAddressBound) {
        this.dnsAddressBound = dnsAddressBound;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#getDnsDomainBound()
     */
    @Override
    public boolean getDnsDomainBound() {
        return dnsDomainBound;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#setDnsDomainBound(boolean)
     */
    @Override
    public void setDnsDomainBound(boolean dnsDomainBound) {
        this.dnsDomainBound = dnsDomainBound;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#getLdapAddressBound()
     */
    @Override
    public boolean getLdapAddressBound() {
        return ldapAddressBound;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#setLdapAddressBound(boolean)
     */
    @Override
    public void setLdapAddressBound(boolean ldapAddressBound) {
        this.ldapAddressBound = ldapAddressBound;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#getLdapDomainBound()
     */
    @Override
    public boolean getLdapDomainBound() {
        return ldapDomainBound;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.DirectEndpoint#setLdapDomainBound(boolean)
     */
    @Override
    public void setLdapDomainBound(boolean ldapDomainBound) {
        this.ldapDomainBound = ldapDomainBound;
    }

}
