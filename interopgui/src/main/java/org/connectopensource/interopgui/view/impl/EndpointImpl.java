/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *   * Redistributions of source code must retain the above
 *     copyright notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *   * Neither the name of the United States Government nor the
 *     names of its contributors may be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 *DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.connectopensource.interopgui.view.impl;

import org.connectopensource.interopgui.view.Endpoint;

/**
 * @author bhumphrey
 *
 */
public class EndpointImpl implements Endpoint {

    private Specification specification;
    private SpecVersion version;
    private String url;
    
    /**
     * @param specification
     * @param version
     * @param url
     */
    public EndpointImpl(Specification specification, SpecVersion version, String url) {
        this.specification = specification;
        this.version = version;
        this.url = url;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#getSpecVersions()
     */
    @Override
    public SpecVersion[] getSpecVersions() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#getSpecification()
     */
    @Override
    public Specification getSpecification() {
        return specification;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#setSpecification(org.connectopensource.interopgui.view.Endpoint.Specification)
     */
    @Override
    public void setSpecification(Specification spec) {
        this.specification = spec;

    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#getSpecVersion()
     */
    @Override
    public SpecVersion getSpecVersion() {
        return version;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#setSpecVersion(org.connectopensource.interopgui.view.Endpoint.SpecVersion)
     */
    @Override
    public void setSpecVersion(SpecVersion version) {
        this.version = version;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#getEndpoint()
     */
    @Override
    public String getEndpoint() {
        return url;
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.view.Endpoint#setEndpoint(java.lang.String)
     */
    @Override
    public void setEndpoint(String endpoint) {
        this.url = endpoint;

    }

}
