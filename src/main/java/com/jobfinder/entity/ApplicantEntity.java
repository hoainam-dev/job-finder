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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicant")
public class ApplicantEntity extends BaseEntity{
	
	@Column(name = "experience", columnDefinition = "TEXT")
	private String experience;
	
	@Column(name = "education", columnDefinition = "TEXT")
	private String education;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "applicant_skill", joinColumns = @JoinColumn(name = "applicant_id"), 
								  inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<SkillEntity> applicantSkills = new ArrayList<>();
	

	public List<SkillEntity> getSkills() {
		return applicantSkills;
	}

	public void setSkills(List<SkillEntity> applicantSkills) {
		this.applicantSkills = applicantSkills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
