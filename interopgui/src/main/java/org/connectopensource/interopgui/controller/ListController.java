/**
 * 
 */
package org.connectopensource.interopgui.controller;

import java.util.ArrayList;
import java.util.List;

import org.connectopensource.interopgui.dataobject.OrganizationInfo;
import org.connectopensource.interopgui.services.DataService;
import org.connectopensource.interopgui.services.JpaDataService;
import org.connectopensource.interopgui.view.Certificate.CertificateType;
import org.connectopensource.interopgui.view.OrganizationSummary;
import org.connectopensource.interopgui.view.impl.OrganizationSummaryImpl;

/**
 * @author msw
 * 
 */
public class ListController {

    /**
     * @return
     */
    public List<OrganizationSummary> getSummaries() {
        return processInformationForDisplay();
    }
    
    private List<OrganizationSummary> processInformationForDisplay() {
        
        /*List<OrganizationInfo> dataList = getOrganizationInfoFromService();
        for (OrganizationInfo info : dataList) {
            OrganizationSummary osImpl = new OrganizationSummaryImpl();
            
            // TODO: Need to get the number of Direct Endpoints
            int countDirectEndpoints = 0;
            osImpl.setCountDirectEndpoints(String.valueOf(countDirectEndpoints));
            
            int countDocuments = info.getDocuments().size();
            osImpl.setCountDocuments(String.valueOf(countDocuments));
            
            // TODO: Need to get the number of Exchange Endpoints
            int countExchangeEndpoints = 0;
            osImpl.setCountExchangeEndpoints(String.valueOf(countExchangeEndpoints));
      
            int countPatients = info.getPatients().size();
            osImpl.setCountPatients(String.valueOf(countPatients));
            
            boolean hasSignedCert = (info.getCert().getCertType() == Certificate.CertificateType.CERT_REQ);
            osImpl.setHasSignedCert(hasSignedCert);
            
            String hcid = info.getHomeCommunityId();
            osImpl.setHcid(hcid);
            
            // TODO: Need to get the id
            int id = 0;
            osImpl.setId(id);
            
            // TODO: Need the org name
            String organizationName = info.getHomeCommunityId();
            osImpl.setOrganizationName(organizationName);
        }
        */
        
        return getOrganizationSummaries();
    }
    
    private List<OrganizationSummary> getOrganizationSummaries() {

        DataService service = new JpaDataService();
        List<OrganizationInfo> orgs = service.getData();
        List<OrganizationSummary> summaries = new ArrayList<OrganizationSummary>(orgs.size());
        
        for (OrganizationInfo orgInfo : orgs) {
            OrganizationSummary summary = new OrganizationSummaryImpl();
            summary.setCountDirectEndpoints(String.valueOf(orgInfo.getDirectEndpoints().size()));
            summary.setCountDocuments(String.valueOf(orgInfo.getDocuments().size()));
            summary.setCountPatients(String.valueOf(orgInfo.getPatients().size()));
            summary.setHcid(orgInfo.getHomeCommunityId());
            summary.setHasSignedCert(orgInfo.getCertInfo().getCertType() == CertificateType.CERT_REQ);
            summary.setId(orgInfo.getId());
            summary.setOrganizationName(orgInfo.getOrgName());
            summaries.add(summary);
        }
        
        return summaries;
    }

}
