package com.validator;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.xml.sax.SAXException;

import com.model.Classe;
import com.model.Etablissement;
import com.model.FileBucket;
import com.service.ChallengerService;
import com.service.etab.EtabService;
import com.service.etab.EtabServiceImpl;
import com.util.ReadDataStudentsXML;
 
 
@Component
public class FileValidator implements Validator {
    
	private static String UPLOAD_LOCATION="C:\\Users\\PC\\Desktop\\Projet JEE\\FilesUpload\\";

	@Autowired
	ChallengerService challengerService;
	
	@Autowired
	EtabService etabService;
	
    public boolean supports(Class<?> clazz) {
        return FileBucket.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object obj, Errors errors) {
        FileBucket file = (FileBucket) obj;
         
        

        
        if(file.getFile()!=null){
            
        	
        	if (file.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file","donner le chemain de fichier");
                return;
            }
        	
        
            if(((FileBucket) obj).getNomClasse().isEmpty() )
            {            
            	errors.rejectValue("nomClasse","nomClasse.required", "donner le nom de la classe.");
            	return;
            }
            
            
            if(((FileBucket) obj).getEtabs() == null)
            {            
            	errors.rejectValue("etabs","etabs.required", "choisisez SVP une etablissement.");
            	return;
            }
            
            
            
            
            
           Etablissement etab =  file.getEtabs();       
            
            Set<Classe> classes = etab.getClasses();
            
            Iterator<Classe> it = classes.iterator(); 
            
            
            while(it.hasNext())
            {
            	if(file.getNomClasse().equalsIgnoreCase(it.next().getNom()))
            		errors.rejectValue("nomClasse","etabs.required", "choisisez SVP un autre nom de la classe.");
            }
            
            
            
            
        	try {
        		File fichier = new File(UPLOAD_LOCATION + file.getFile().getOriginalFilename());
				FileCopyUtils.copy(file.getFile().getBytes(), fichier);
				try {
					
					Set<String> emails =  ReadDataStudentsXML.readDataStudentsXML(UPLOAD_LOCATION + file.getFile().getOriginalFilename());
				    
					Iterator<String> iterator = emails.iterator();
					
					while(iterator.hasNext())
					{
						String email = iterator.next();
						
						if(challengerService.emailExist(email))
						{
							errors.rejectValue("file", "missing.file","L'email est deja existant : "+ email);
						}
						
					}
				
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				}
				
				fichier.delete();

        	} catch (IOException e) {
				e.printStackTrace();
			}

            
            
            
        }
    }
}