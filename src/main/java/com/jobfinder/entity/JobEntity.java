package com.jobfinder	.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class JobEntity extends BaseEntity{
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "requirements")
	private String requirements;
	
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "location")
	private String location;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "company_id", referencedColumnName = "id")
//	private CompanyEntity companyEntity;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "job_categories", joinColumns = @JoinColumn(name = "job_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<CategoryEntity> categories = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

//	public CompanyEntity getCompanyEntity() {
//		return companyEntity;
//	}
//
//	public void setCompanyEntity(CompanyEntity companyEntity) {
//		this.companyEntity = companyEntity;
//	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}
	
}