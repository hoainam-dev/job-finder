package com.jobfinder.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jobfinder.entity.JobEntity;

@Component
public class JobValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return JobEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required", "Title is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required", "Description is required.");
    }
}
