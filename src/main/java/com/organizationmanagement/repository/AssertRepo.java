package com.organizationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.organizationmanagement.model.Asserts;

@Repository
public interface AssertRepo extends JpaRepository<Asserts, String>{

}
