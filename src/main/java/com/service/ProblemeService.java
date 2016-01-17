package com.service;

import com.model.Probleme;

public interface ProblemeService {
     
	    public void save(Probleme probleme);
		
		public Probleme findById(int id);
	
}
