/*
 * Copyright (c) 2013, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of the United States Government nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.connectopensource.interopgui.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.connectopensource.interopgui.dataobject.OrganizationInfo;
import org.connectopensource.interopgui.jpa.AbstractJpaTemplate;

/**
 * JPA Implementation of {@link DataService}.
 */
public class JpaDataService implements DataService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Long saveData(final OrganizationInfo org) {
                
        try {
            new AbstractJpaTemplate<OrganizationInfo>() {
                @Override
                protected List<OrganizationInfo> execute(EntityManager entityManager) {
                    entityManager.persist(org);                
                    return Collections.singletonList(org);
                }            
            }.execute();        
        } catch (Exception e) {
            throw new DataServiceException("Error while persisting org info.", e);
        }
        
        return org.getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationInfo> getData() {
        
        try {
            return new AbstractJpaTemplate<OrganizationInfo>() {
                @Override
                protected List<OrganizationInfo> execute(EntityManager entityManager) {
                    return entityManager.createQuery("from OrganizationInfo", OrganizationInfo.class).getResultList();
                }            
            }.execute();
        } catch (Exception e) {
            throw new DataServiceException("Error while retrieving org info.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationInfo getData(final String id) {
        try {
            final Long lid = Long.valueOf(id);
            AbstractJpaTemplate<OrganizationInfo> jpa = new AbstractJpaTemplate<OrganizationInfo>() {
                @Override
                protected List<OrganizationInfo> execute(EntityManager entityManager) {
                    TypedQuery<OrganizationInfo> query = entityManager.createQuery("from OrganizationInfo where id = :id", OrganizationInfo.class);
                    query.setParameter("id", lid);
                    return query.getResultList(); 
                }            
            };
            List<OrganizationInfo> results = jpa.execute();
            
            //there should only be one result
            return results.get(0);
        } catch (Exception e) {
            throw new DataServiceException("Error while retrieving org info.", e);
        }
    }

    /* (non-Javadoc)
     * @see org.connectopensource.interopgui.services.DataService#getDataByHCID(java.lang.String)
     */
    @Override
    public List<OrganizationInfo> getDataByHCID(String homeCommunityId) {
        // TODO Auto-generated method stub
        return null;
    }
     
    
}
