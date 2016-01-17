package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.dao.UserProfileDaoImpl;
import com.dao.challenge.ChallengeDao;
import com.dao.challenges.ChallengerDao;
import com.model.Challenge;
import com.model.Challenger;
import com.model.Compte;
import com.model.Langage;
import com.model.UserProfile;


@Service("challengesService")
@Transactional
public class ChallengeServiceImpl implements ChallengesService { 
	
	@Autowired
	private ChallengeDao dao;
		
	public void save(Challenge challenge){
		
		
		dao.save(challenge);
	}

	public Challenge findByLangage(Langage langage) {
			
		
		SimpleExpression simpleExpression = Restrictions.eq("langage", langage);
		List<SimpleExpression> listCondition  = new ArrayList<SimpleExpression>();
		listCondition.add(simpleExpression);
		
		List<Challenge> chalenges =  dao.criteriaResultat(listCondition);
	
		if(chalenges.size() > 0)
			return chalenges.get(0);
		
		
		return null;
		
		
		
		
	}

	@Override
	public Challenge findById(int id) {
		return dao.findById(id);
	}	
}
