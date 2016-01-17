package com.dao.developpeur;

import com.model.Challenger;
import com.model.Developpeur;

public interface DeveloppeurDao {
   
    void save(Developpeur developpeur);
	
    Developpeur findById(int id);
	
    Developpeur findBySSO(String sso);
	
	
}
