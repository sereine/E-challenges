package com.validator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import com.model.Professeur;
import com.service.ProfesseurService;
import com.util.ReadDataRefXML;

public class RefUniqueContrainstValidator  implements ConstraintValidator<RefUnique, String>  {
     
	@Autowired
	private ProfesseurService professeurService;
	
	 public void setProfesseurService(ProfesseurService professeurService) {
		this.professeurService = professeurService;
	}

	@Override
	    public boolean isValid(String ref, ConstraintValidatorContext context) {
	     
		 if(ref == null) {			   
	            return false;
	        }
	    	
	        if(professeurService != null)
	        {
	        	Professeur prof = professeurService.findRef(ref);
	        	if(prof != null)
	        		return false;
	        	else
	        	    return true; 
	        }

			 return true;
	        
	 }
	
	@Override
	public void initialize(RefUnique refUnique) {
		
	}
}
