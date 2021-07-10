package com.organizationmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Asserts")
public class Asserts {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assert_id")
	private String assertId;
	
	@Column(name="assert_name")
	private String assertName;
	
	@Column(name="assert_type")
	private String assertType;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "org_Id", nullable = true)
	private Organization organization;

	public String getAssertId() {
		return assertId;
	}

	public void setAssertId(String assertId) {
		this.assertId = assertId;
	}

	public String getAssertName() {
		return assertName;
	}

	public void setAssertName(String assertName) {
		this.assertName = assertName;
	}

	public String getAssertType() {
		return assertType;
	}

	public void setAssertType(String assertType) {
		this.assertType = assertType;
	}



	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	
	
	
	

}
