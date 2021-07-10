package com.organizationmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organizationmanagement.model.Employee;
import com.organizationmanagement.model.Organization;
import com.organizationmanagement.repository.AssertRepo;
import com.organizationmanagement.repository.EmployeeRepo;
import com.organizationmanagement.repository.OrganizationRepo;
import com.organizationmanagement.service.OrganizationService;

@RestController
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	OrganizationRepo organizationRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	AssertRepo assertRepo;
	
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE,path="organizations")
	public List<Organization> getAllOrganizations(@RequestParam(required = false) String orgId) {

		return organizationRepo.findAll();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_XML_VALUE,path="addOrganization")
	public Organization addOrganization (@RequestBody Organization org) {
		return organizationRepo.save(org);
	}

	@PutMapping(produces = MediaType.APPLICATION_XML_VALUE,path="updateOrganization/{id}")
	public Organization updateOrganization (@RequestBody Organization org,@PathVariable String id) {
		return organizationRepo.findById(id).map(i-> {
			    	  i.setOrgName(org.getOrgName());
			    	  i.setOrgType(org.getOrgType());
			          return organizationRepo.save(i);
			        })
			        .orElseGet(() -> {
			        	org.setOrgId(id);
			          return organizationRepo.save(org);
			        });
	}
	
	@DeleteMapping(path="deleteOrganization")
	public String deleteOrganization (@RequestParam String id) {
		 organizationRepo.deleteById(id);
		 return "Deleted Successfully";
	}
}
