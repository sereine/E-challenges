package com.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.CompteService;

public class UserNameContrainstValidator implements ConstraintValidator<UserNameUnique, String> {
	   
		@Autowired
		private CompteService compteService;
	    @Override
	    public boolean isValid(String userName, ConstraintValidatorContext context) {
	    	if(userName == null) {
	            return false;
	        }
	    	
	    	if(compteService != null)
	    	if(compteService.compteExist(userName) == true)    		
	    		return false;
	    	
	    	
	        return true;
	    }

		@Override
		public void initialize(UserNameUnique constraintAnnotation) {
			
		}
	 
	}