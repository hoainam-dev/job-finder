package com.jobfinder.dto;

<<<<<<< HEAD

=======
>>>>>>> 69a7cef3d9ac3e01fe27affe2941c377df4dc554
public class JobDTO extends AbstractDTO<JobDTO>{
	
	private String title;
	
	private String description;
	
	private String requirements;
	
	private int salary;
	
	private String location;
	
	private String position;
	
	private Long category_id;
	
	private Long employer_id;

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Long getEmployer_id() {
		return employer_id;
	}

	public void setEmployer_id(Long employer_id) {
		this.employer_id = employer_id;
	}
	
	

}