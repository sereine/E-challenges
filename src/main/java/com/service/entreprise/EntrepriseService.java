package com.service.entreprise;

import com.model.Compte;
import com.model.Entreprise;

public interface EntrepriseService {
    
	public void save(Entreprise entreprise);
	
	public Entreprise findById(int id);

	public Entreprise findByCompte(Compte compte); 
	
	public boolean emailExist(String email);
	
}
