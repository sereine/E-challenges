package com.service;

import com.model.Challenger;
import com.model.Professeur;

public interface ProfesseurService {
	
	 public void save(Professeur professeur);
		
		public Professeur findById(int id);

		public Professeur findBySso(String sso);
		
		public Professeur findRef(String ref);
}
