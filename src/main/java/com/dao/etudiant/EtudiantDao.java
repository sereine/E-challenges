package com.dao.etudiant;

import com.model.Challenger;
import com.model.Etudiant;

public interface EtudiantDao {
   
	
void save(Etudiant etudiant);

void update(Etudiant etudiant);

	Challenger findById(int id);
	
	Challenger findBySSO(String sso);
	
}
