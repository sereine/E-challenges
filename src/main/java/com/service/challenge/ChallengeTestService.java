package com.service.challenge;

import com.model.ChallengeTest;

public interface ChallengeTestService {
     
	    public void save(ChallengeTest challengeTest);
		
		public ChallengeTest findById(int id);
	
}
