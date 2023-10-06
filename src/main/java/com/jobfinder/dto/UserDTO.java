package com.jobfinder.dto;

public class UserDTO extends AbstractDTO<UserDTO>{
	private String userName;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private Integer status;
	private	Long applicant_id;
	private	Long employer_id;
	private String applicantName;
	private String employerName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getApplicant_id() {
		return applicant_id;
	}
	public void setApplicant_id(Long applicant_id) {
		this.applicant_id = applicant_id;
	}
	public Long getEmployer_id() {
		return employer_id;
	}
	public void setEmployer_id(Long employer_id) {
		this.employer_id = employer_id;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	
}
