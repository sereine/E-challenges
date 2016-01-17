package com.dao.classe;

import com.model.Challenger;
import com.model.Classe;

public interface ClasseDao {
    
	
    void save(Classe classe);
	Classe findById(int id);
	
	
}
