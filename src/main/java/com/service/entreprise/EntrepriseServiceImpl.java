package com.service.entreprise;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.challenges.ChallengerDao;
import com.dao.entreprise.EntrepriseDao;
import com.model.Challenger;
import com.model.Compte;
import com.model.Entreprise;
import com.service.CompteService;


@Service("entrepriseService")
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService {
	
	@Autowired
	private EntrepriseDao dao;
	
	@Autowired
	private CompteService compteService;
	
	
	@Override
	public void save(Entreprise entreprise) {
		
		compteService.save(entreprise.getCompte());
		dao.save(entreprise);
		
	}
	
	
	@Override
	public Entreprise findById(int id) {

		return dao.findById(id);
		
	}

	@Override
	public Entreprise findByCompte(Compte compte) {

		SimpleExpression simpleExpression = Restrictions.eq("compte", compte);
		List<SimpleExpression> listCondition  = new ArrayList<SimpleExpression>();
		listCondition.add(simpleExpression);
		
		List<Entreprise> entreprises =  dao.criteriaResultat(listCondition);
	
		if(entreprises.size() > 0)
			return entreprises.get(0);
		
		
		return null;
	}

	@Override
	public boolean emailExist(String email) {
         
		
		SimpleExpression simpleExpression = Restrictions.eq("email", email);
		List<SimpleExpression> listCondition  = new ArrayList<SimpleExpression>();
		listCondition.add(simpleExpression);
		
		List<Entreprise> entreprises =  dao.criteriaResultat(listCondition);
	
		if(entreprises.size() > 0)
			return true;
		else 
			return false;
		
	}

	

}
