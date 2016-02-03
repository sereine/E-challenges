package com.compilers;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import javax.xml.rpc.ServiceException;



public class IDE {

	public static HashMap<String,Object> runProgramme(String sourceCode,String input, Integer language, boolean execute) {
	  
		try {
			Ideone_Service_v1ServiceLocator service = new Ideone_Service_v1ServiceLocator();

			Ideone_Service_v1Port p = service.getIdeone_Service_v1Port();
			try {
			
				String user = "9aea5b26f7b4ad5bf38d3c32b2206893";
				
				String pass = "ab660f11d880c37f56b8ca789c68d7df";
				
				HashMap<String,Object> dataResponse;
				HashMap<String,Object> detailsProgramme =  new HashMap<String,Object>();

				try
				{
				 dataResponse = (HashMap<String,Object>)p.createSubmission(user, pass, sourceCode, language, input, execute, true)[0];
				}
				catch(Exception e)
				{
					return null;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//e.printStackTrace();
					System.out.println("error connexion");
					return null;
				} 
				
				String link = (String)dataResponse.get("link");
				
				HashMap<String,String> statut = (HashMap<String,String>)p.getSubmissionStatus(user, pass, link)[0];
								
				
				detailsProgramme = (HashMap<String,Object>) p.getSubmissionDetails(user, pass, link, true, true, true, true, true)[0];
				detailsProgramme.put("connexion", "succes");
			    
			    return detailsProgramme;
				
			} catch (RemoteException e) {
				//e.printStackTrace();
				System.out.println("error connexion");
			}
		} catch (ServiceException e) {
			//e.printStackTrace();
			System.out.println("error connexion");
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
