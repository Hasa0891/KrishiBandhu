package com.mahmudul.krishibandhuapi.organization;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mahmudul.krishibandhuapi.dtos.OrganizationDTO;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/organizations")
@Validated
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @PostMapping("/")
    public ResponseEntity<Organization> createOrganization(@Valid @RequestBody OrganizationDTO organizationDTO){
        
        Organization org = organizationService.createOrganization(organizationDTO.toOrganizationEntity());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(org.getId())
                        .toUri();

        return ResponseEntity.created(location).body(org);
    }

    @GetMapping("/")
    public ResponseEntity<List<Organization>> getOrganizations(){
        return ResponseEntity.ok(organizationService.getOrganizations());
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable Long orgId){
        Organization org = organizationService.getOrganization(orgId);
        return ResponseEntity.ok(org);
    }

    @PutMapping("/{orgId}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable Long orgId, @RequestBody OrganizationDTO organizationDTO) {
        Organization org = organizationService.updateOrganization(orgId, organizationDTO.toOrganizationEntity());
        return ResponseEntity.ok(org);
    }

    @DeleteMapping("/{orgId}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long orgId){
        organizationService.deleteOrganization(orgId);
        return ResponseEntity.noContent().build();
    }
}
