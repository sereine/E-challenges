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
import com.dao.challenges.ChallengerDao;
import com.model.Challenger;
import com.model.Compte;
import com.model.UserProfile;


@Service("challengerService")
@Transactional
public class ChallengerServiceImpl implements ChallengerService { 
	
	@Autowired
	private ChallengerDao dao;
		
	public void save(Challenger challenger){
		
		
		dao.save(challenger);
	}
	
	
	public Challenger findById(int id) {
		return dao.findById(id);
	}

	public Challenger findByCompte(Compte compte) {
			
		
		SimpleExpression simpleExpression = Restrictions.eq("compte", compte);
		List<SimpleExpression> listCondition  = new ArrayList<SimpleExpression>();
		listCondition.add(simpleExpression);
		
		List<Challenger> chalengers =  dao.criteriaResultat(listCondition);
	
		if(chalengers.size() > 0)
			return chalengers.get(0);
		
		
		return null;
		
		
		
		
	}

	public boolean emailExist(String email)
	{
		SimpleExpression simpleExpression = Restrictions.eq("email", email);
		List<SimpleExpression> listCondition  = new ArrayList<SimpleExpression>();
		listCondition.add(simpleExpression);
		
		List<Challenger> chalengers =  dao.criteriaResultat(listCondition);
	
		if(chalengers.size() > 0)
			return true;
		else 
			return false;
	}
}
