package com.service;

import java.util.Set;

import com.model.Challenger;
import com.model.Etablissement;
import com.model.Etudiant;
import com.model.Professeur;

public interface EtudiantService {

    public void save(Etudiant etudiant);
	
    public void update(Etudiant etudiant);
    
	public Etudiant findById(int id);

	public Etudiant findBySso(String sso); 
	
	public void inscriptionEtudiants(Set<String> emails, String nomClasse,  Professeur prof, Etablissement etab);
	
	
}
