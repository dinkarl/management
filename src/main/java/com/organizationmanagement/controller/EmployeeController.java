package com.organizationmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organizationmanagement.model.Asserts;
import com.organizationmanagement.model.Employee;
import com.organizationmanagement.model.Organization;
import com.organizationmanagement.repository.AssertRepo;
import com.organizationmanagement.repository.EmployeeRepo;
import com.organizationmanagement.repository.OrganizationRepo;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	AssertRepo assertRepo;
	
	@Autowired
	OrganizationRepo organizationRepo;
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE,path="employees")
	public List<Employee> getAllEmployees() {

		return employeeRepo.findAll();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_XML_VALUE,path="addEmployee")
	public Employee addOrganization (@RequestBody Employee org) {

			return employeeRepo.save(org);
	}

	@PutMapping(produces = MediaType.APPLICATION_XML_VALUE,path="updateEmployee/{id}")
	public Employee updateOrganization (@RequestBody Employee emp,@PathVariable String id) {
		return employeeRepo.findById(id).map(i-> {
			    	  i.setEmpName(emp.getEmpName());
			    	  i.setDesignation(emp.getDesignation());
			    	  i.setEmaiId(emp.getEmaiId());
			    	  i.setOrganization(emp.getOrganization());
			          return employeeRepo.save(i);
			        })
			        .orElseGet(() -> {
			        	emp.setEmployeeId(id);
			          return employeeRepo.save(emp);
			        });
	}
	
	@DeleteMapping(path="deleteEmployee")
	public String deleteEmployee (@RequestParam String id) {
		employeeRepo.deleteById(id);
		 return "Deleted Successfully";
	}

}
