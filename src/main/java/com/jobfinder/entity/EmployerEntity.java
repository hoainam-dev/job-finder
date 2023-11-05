package com.jobfinder.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employer")
public class EmployerEntity extends BaseEntity {
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_address")
	private String companyAddress;
	
	@Column(name = "position")
	private String position;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
	// many to one with service 
	@ManyToOne
    @JoinColumn(name = "dich_vu_id")
	private ServiceEntity service;

	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ServiceEntity getServices() {
		return service;
	}

	public void setServices(Long id) {
		this.service = new ServiceEntity();
		this.service.setId(id);
	}


	
}
