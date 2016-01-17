package com.dao.challengeTest;

import com.model.Challenge;
import com.model.ChallengeTest;


public interface ChallengeTestDao {
   
    void save(ChallengeTest challengeTest);
	
    ChallengeTest findById(int id);
	
	
}
