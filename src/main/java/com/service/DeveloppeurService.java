package com.service;

import com.model.Developpeur;;

public interface DeveloppeurService {
     
	    public void save(Developpeur developpeur);
		
		public Developpeur findById(int id);

		public Developpeur findBySso(String sso);
	
}
