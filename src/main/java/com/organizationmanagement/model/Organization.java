package com.organizationmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORGANIZATION")
public class Organization {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="org_id")
	private String orgId;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="org_type")
	private String orgType;
	

	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Asserts> asserts;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		for(Employee emp : employees) {
			emp.setOrganization(this);
		}
		this.employees = employees;
	}

	public List<Asserts> getAsserts() {
		return asserts;
	}

	public void setAsserts(List<Asserts> asserts) {
		for(Asserts asser : asserts) {
			asser.setOrganization(this);
		}
		this.asserts = asserts;
	}
	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	
	
}
