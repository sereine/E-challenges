package com.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;


public class EmailProConstraintValidator   implements ConstraintValidator<EmailPro, String> {
    
	 
    @Override
    public void initialize(EmailPro email) { }
 
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
         
    	
    	if(email == null) {
            return false;
        }
        
    	String[]  tabStr = {"@gmail.","@yahoo.","@hotmail."};
    	
    	for(int i = 0; i < tabStr.length; i++)
    	{
    		if( email.toLowerCase().contains(tabStr[i].toLowerCase())  )
    			return false;
    	}
    	
    	
	    	
	        return true;
        
        
    }
	
	
	
}
