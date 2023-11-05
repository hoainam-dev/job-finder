package com.jobfinder.dto;


public class JobDTO extends AbstractDTO<JobDTO>{
	
	private String title;
	
	private String description;
	
	private String requirements;
	
	private int salary;
	
	private String location;
	
//	private Long company_id;

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

//	public Long getCompany_id() {
//		return company_id;
//	}
//
//	public void setCompany_id(Long company_id) {
//		this.company_id = company_id;
//	}

}