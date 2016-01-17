package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.professeur.ProfesseurDao;
import com.model.Professeur;



@Service("professeurService")
@Transactional
public class ProfesseurServiceImpl implements ProfesseurService { 
	
	@Autowired
	private ProfesseurDao dao;
	@Autowired
	private CompteService compteService;
		
	public void save(Professeur professeur){		
		compteService.save(professeur.getCompte());
		dao.save(professeur);
	}
	
	
	public Professeur findById(int id) {
		return dao.findById(id);
	}

	public Professeur findBySso(String sso) {
		return null;
	}


	@Override
	public Professeur findRef(String ref) {
		return dao.findByRef(ref);
	}

	
}
