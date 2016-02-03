package com.service.challenge;

import com.model.Challenge;
import com.model.Langage;

public interface ChallengesService {
	
    public void save(Challenge challenge);
	
	public Challenge findById(int id);

	public Challenge findByLangage(Langage langage); 
	
}
