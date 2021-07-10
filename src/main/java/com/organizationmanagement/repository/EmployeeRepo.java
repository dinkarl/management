package com.organizationmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.organizationmanagement.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String>{
	
	
	List<Employee> findByOrganizationOrgId(String orgId);
}
