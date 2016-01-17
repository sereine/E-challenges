package com.dao.probleme;

import com.model.Challenge;
import com.model.ChallengeTest;
import com.model.Probleme;


public interface ProblemeDao {
   
    void save(Probleme probleme);
	
    Probleme findById(int id);
	
	
}
