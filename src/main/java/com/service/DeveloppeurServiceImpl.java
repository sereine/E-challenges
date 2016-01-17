package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.developpeur.DeveloppeurDao;
import com.model.Developpeur;

@Service("developpeurService")
@Transactional
public class DeveloppeurServiceImpl implements DeveloppeurService { 
	
	@Autowired
	private DeveloppeurDao developpeurDao;
	
	@Autowired
	private CompteService compteService;
		
	public void save(Developpeur developpeur){
		
		compteService.save(developpeur.getCompte());
		developpeurDao.save(developpeur);
	}
	
	
	public Developpeur findById(int id) {
		return developpeurDao.findById(id);
	}

	public Developpeur findBySso(String sso) {
		return null;
	}
	
}