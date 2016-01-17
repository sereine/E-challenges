package com.service;

import com.model.Challenger;
import com.model.Compte;

public interface ChallengeService {
	
   public void save(Challenger challenger);
	
	public Challenger findById(int id);

	public Challenger findByCompte(Compte compte); 
	
	public boolean emailExist(String email);
}
