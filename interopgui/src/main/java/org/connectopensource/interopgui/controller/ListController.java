/**
 * 
 */
package org.connectopensource.interopgui.controller;

import java.util.ArrayList;
import java.util.List;

import org.connectopensource.interopgui.dataobject.OrganizationInfo;
import org.connectopensource.interopgui.services.DataService;
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
        ArrayList<OrganizationSummary> orgSummaries = new ArrayList<OrganizationSummary>();
        OrganizationSummary impl = new OrganizationSummaryImpl();
        impl.setCountDirectEndpoints("0");
        impl.setCountDocuments("3");
        impl.setHcid("1.1");
        impl.setHasSignedCert(true);
        impl.setId(0);
        impl.setOrganizationName("CONNECT open source dot org");
        orgSummaries.add(impl);
        
        OrganizationSummary impl1 = new OrganizationSummaryImpl();
        impl1.setCountDirectEndpoints("0");
        impl1.setCountDocuments("1");
        impl1.setHcid("2.2");
        impl1.setHasSignedCert(true);
        impl1.setId(0);
        impl1.setOrganizationName("CGI");
        orgSummaries.add(impl1);
        
        OrganizationSummary impl2 = new OrganizationSummaryImpl();
        impl2.setCountDirectEndpoints("0");
        impl2.setCountDocuments("1");
        impl2.setHcid("6.6.6");
        impl2.setHasSignedCert(false);
        impl2.setId(0);
        impl2.setOrganizationName("DIL DIL DIL DIL DIL DIL DIL DIL");
        orgSummaries.add(impl2);
        
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
        return orgSummaries;
    }
    
    private List<OrganizationInfo> getOrganizationInfoFromService() {
        DataService service = null;
        return service.getData();
    }

}
