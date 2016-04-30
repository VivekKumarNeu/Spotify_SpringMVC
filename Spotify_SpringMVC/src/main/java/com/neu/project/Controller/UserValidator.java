	package com.neu.project.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.User;

public class UserValidator implements Validator {

	private Pattern pattern;  
	private Matcher matcher;  

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  

	
	@Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

	@Override
    public void validate(Object obj, Errors errors)
    {

		String ID_PATTERN = "[0-9]+";  
		String STRING_PATTERN = "[a-zA-Z\\s']+";
		String AGE_PATTERN = "/\\s[0-1]{1}[0-9]{0,2}/";
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "error.invalid.user", "Age Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "UserName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email.emailId", "Email Required");
        
        User user = (User) obj;
        
        if ( user.getFirstName() != null && user.getLastName() != null   ) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(user.getFirstName());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("firstName", "error.invalid.user", "First Name is not string");  
			   } 
			   matcher = pattern.matcher(user.getLastName());
			   if (!matcher.matches()) {  
				    errors.rejectValue("lastName", "error.invalid.user", "Last Name is not string");  
				   }
			  }

        if(user.getAge() > 120 )  
        {
        	errors.rejectValue("age", "error.invalid.user", "Too old");
        }
        
        pattern = Pattern.compile(EMAIL_PATTERN);  
        matcher = pattern.matcher(user.getEmail());
        if (!matcher.matches()) {  
		    errors.rejectValue("email", "error.invalid.user", "Email not valid");  
		   } 
        
    }
}
