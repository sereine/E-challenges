package com.dao.challenge;

import java.util.List;

import org.hibernate.criterion.SimpleExpression;

import com.model.Challenge;

public interface ChallengeDao {
   
	void save(Challenge challenge);
	
	Challenge findById(int id);
	
	
	java.util.List criteriaResultat(List<SimpleExpression> listCindition);
}
