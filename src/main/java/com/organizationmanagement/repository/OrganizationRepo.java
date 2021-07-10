package com.organizationmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organizationmanagement.model.Organization;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, String> { 
	
	
}
