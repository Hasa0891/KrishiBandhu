package com.mahmudul.krishibandhuapi.organization;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mahmudul.krishibandhuapi.exceptions.organization.OrganizationNotFoundException;

@Service
public class OrganizationService {
 
    private OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    public Organization createOrganization(Organization nwOrganization){
        return organizationRepository.save(nwOrganization);
    }

    public Organization getOrganization(Long orgId){
        return organizationRepository.findById(orgId)
                .orElseThrow(() -> new OrganizationNotFoundException("Organization Not Found with Id : " + orgId));
    }

    public List<Organization> getOrganizations(){
        return organizationRepository.findAll();
    }

    public Organization updateOrganization(Long orgId, Organization nwOrg){
        return organizationRepository.findById(orgId)
                .map(org -> {
                    org.setName(nwOrg.getName());
                    org.setDescription(nwOrg.getDescription());
                    org.setAddress(nwOrg.getAddress());
                    org.setContacts(nwOrg.getContacts());
                    return organizationRepository.save(org);
                })
                .orElseThrow(() -> new OrganizationNotFoundException("Organization Not Found with Id : " + orgId));
    }

    public void deleteOrganization(Long orgId){
        if(!organizationRepository.existsById(orgId)){
            throw new OrganizationNotFoundException("Organization Not Found with Id : " + orgId);
        }
        organizationRepository.deleteById(orgId);
    }
}
