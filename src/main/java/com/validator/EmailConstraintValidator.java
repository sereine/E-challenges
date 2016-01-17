package com.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.ChallengeService;
import com.service.ChallengerServiceImpl;
import com.service.CompteServiceImpl;
import com.service.entreprise.EntrepriseService;

public class EmailConstraintValidator implements ConstraintValidator<EmailUnique, String> {
   
	@Autowired
	private ChallengeService challengerService;
	
	@Autowired
	private EntrepriseService entrepriseService;
	 
    @Override
    public void initialize(EmailUnique email) { }
 
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
         
    	
    	if(email == null) {
            return false;
        }
        
        
        if(challengerService != null)
	    	if(challengerService.emailExist(email) == true  ||  entrepriseService.emailExist(email) == true)
	    		return false;
	    	
	        return true;
        
        
    }
 
}