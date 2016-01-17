package com.compilers;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import javax.xml.rpc.ServiceException;



public class IDE {

	public static HashMap<String,String> runProgramme(String sourceCode,String input, Integer language) {
	  
		Ideone_Service_v1ServiceLocator service = new Ideone_Service_v1ServiceLocator();
		try {
			Ideone_Service_v1Port p = service.getIdeone_Service_v1Port();
			
			try {
			
				String user = "9aea5b26f7b4ad5bf38d3c32b2206893";
				
				String pass = "ab660f11d880c37f56b8ca789c68d7df";
				
				
				HashMap<String,String> dataResponse = (HashMap<String,String>)p.createSubmission(user, pass, sourceCode, language, input, true, false)[0];
								
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				
				String link = dataResponse.get("link");
				
				HashMap<String,String> statut = (HashMap<String,String>)p.getSubmissionStatus(user, pass, link)[0];
								
				HashMap<String,String> detailsProgramme = (HashMap<String,String>) p.getSubmissionDetails(user, pass, link, true, true, true, true, true)[0];
				
			    
			    return detailsProgramme;
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	  	return null;

	}
	
	public static HashMap<Integer,String> getLanguages()
	{
		Ideone_Service_v1ServiceLocator service = new Ideone_Service_v1ServiceLocator();
		
		HashMap<Integer,String> languagesIDE = new HashMap<Integer,String>();
		
		try {
			Ideone_Service_v1Port p = service.getIdeone_Service_v1Port();
			
			String user = "9aea5b26f7b4ad5bf38d3c32b2206893";
			String pass = "ab660f11d880c37f56b8ca789c68d7df";
			
			 try {
			     	 
				
				 HashMap<String,HashMap<Integer,String>> res = ( HashMap<String,HashMap<Integer,String>>) p.getLanguages(user, pass)[0];
				 HashMap<Integer,String> languages = res.get("languages");
				 
				 Set<Integer> setKeys =  languages.keySet();
				 
				 java.util.Iterator<Integer> keys =  setKeys.iterator();
				 
				 while(keys.hasNext())
				 {
					 Integer key = keys.next();
					 String languge = languages.get(key);					 
					 languagesIDE.put(key, languge);
					 
				 }
				 
								
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			
			
		} catch (ServiceException e) {
             e.printStackTrace();
		}
		
		
		return languagesIDE;
	}
	
	
}
