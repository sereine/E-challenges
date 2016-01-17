package com.validator;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import com.service.ProfesseurService;
import com.util.ReadDataRefXML;

public class RefExisteContrainstValidator implements ConstraintValidator<RefExiste, String>  {
    
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
	           
	        	    Set<String> refs;
					try {
						refs = ReadDataRefXML.readDataRefXML("C:\\Users\\PC\\Desktop\\Projet JEE\\FilesUpload\\refs.xml");
						Iterator<String> it = refs.iterator();		        	    
		        	    while(it.hasNext())
		        	    {
		        	    	if(ref.compareTo(it.next()) == 0)
		        	    		return true;

		        	    }
		        	    return false;
					} catch (ParserConfigurationException | SAXException
							| IOException e) {
						e.printStackTrace();
						return false;
					}
	        	    
	        	
	        }

			 return true;
	        
	 }
	
	@Override
	public void initialize(RefExiste refExiste) {
		
	}
}