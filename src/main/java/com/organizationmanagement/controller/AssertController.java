package com.organizationmanagement.controller;

import java.util.List;

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
import com.organizationmanagement.repository.AssertRepo;

@RestController
public class AssertController {
	
	@Autowired
	AssertRepo assertRepo;
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE,path="asserts")
	public List<Asserts> getAllEmployees() {

		return assertRepo.findAll();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_XML_VALUE,path="addAssert")
	public Asserts addOrganization (@RequestBody Asserts asserts) {

			return assertRepo.save(asserts);
	}

	@PutMapping(produces = MediaType.APPLICATION_XML_VALUE,path="updateAssert/{id}")
	public Asserts updateOrganization (@RequestBody Asserts asserts,@PathVariable String id) {
		return assertRepo.findById(id).map(i-> {
			    	  i.setAssertName(asserts.getAssertName());
			    	  i.setAssertType(asserts.getAssertType());
			          return assertRepo.save(i);
			        })
			        .orElseGet(() -> {
			        	asserts.setAssertId(id);
			          return assertRepo.save(asserts);
			        });
	}
	
	@DeleteMapping(path="deleteAssert")
	public String deleteAsserts (@RequestParam String id) {
		assertRepo.deleteById(id);
		 return "Deleted Successfully";
	}

}
