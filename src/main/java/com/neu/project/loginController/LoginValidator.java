package com.neu.project.loginController;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.User;

public class LoginValidator implements Validator{

	 public boolean supports(Class aClass)
	    {
	        return aClass.equals(User.class);
	    }

	    public void validate(Object obj, Errors errors)
	    {
	        User user = (User) obj;
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "UserName Required");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
	    }
}
