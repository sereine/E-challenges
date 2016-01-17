package com.dao.challenges;

import java.util.List;

import org.hibernate.criterion.SimpleExpression;

import com.model.Challenger;

public interface ChallengerDao {
   
	void save(Challenger challenger);
	
	Challenger findById(int id);
	
	Challenger findBySSO(int idCompte);
	
	java.util.List criteriaResultat(List<SimpleExpression> listCindition);
}
