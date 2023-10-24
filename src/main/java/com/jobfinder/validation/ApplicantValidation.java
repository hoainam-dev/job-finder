package com.jobfinder.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jobfinder.dto.ApplicantDTO;
import com.jobfinder.service.IUserService;

@Component
public class ApplicantValidation implements Validator{
	
	@Autowired
	private IUserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ApplicantDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ApplicantDTO applicant = (ApplicantDTO)target;
		
		//applicant
		String experience = applicant.getExperience();
		
		//user
		String email = applicant.getEmail();
		String userName = applicant.getUserName();
        String password = applicant.getPassword();
        String confirmPassword = applicant.getConfirmPassword();
       
        //validation empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skills", "applicant.skills.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "education", "applicant.education.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experience", "applicant.experience.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "user.firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "user.lastName.empty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "user.userName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email.empty");
        
        //Business validation
        if(!password.equals(confirmPassword)){//password không khớp
            errors.rejectValue("confirmPassword","user.confirmPassword.missMatch");
        }
        
        if(password.length()<8 || password.length()>15){//password quá ngắn dài hoặc quá dài
            errors.rejectValue("password","user.password.size");
        }
        
        if(userService.findOneByUserNameAndStatus(userName, 1)!=null&&userName.length()>1){//username đã tồn tại
            errors.rejectValue("userName","user.userName.exist");
        }
        
        if(userService.findOneByEmailAndStatus(email, 1)!=null&&email.length()>1){//email đã tồn tại
            errors.rejectValue("email","user.email.exist");
        }
        
        if(experience.length()<30 && experience.length()>1){//trường experience quá ngắn
            errors.rejectValue("experience","applicant.experience.size");
        }
	}
	
}
