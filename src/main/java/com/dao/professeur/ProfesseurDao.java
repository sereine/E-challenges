package com.dao.professeur;

import com.model.Compte;
import com.model.Developpeur;
import com.model.Professeur;

public interface ProfesseurDao {


    void save(Professeur professeur);
	
    Professeur findById(int id);
	
    Professeur findBySSO(String sso);
	
    Professeur findByRef(String ref);
	
}
