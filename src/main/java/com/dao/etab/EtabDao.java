package com.dao.etab;

import java.util.ArrayList;
import java.util.List;

import com.model.Etablissement;
import com.model.Professeur;

public interface EtabDao{
  
void save(Etablissement etab);
	
    Etablissement findById(int id);
	
	List<Etablissement> allEtab();
	
}
