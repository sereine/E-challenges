package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.challengeTest.ChallengeTestDao;
import com.dao.developpeur.DeveloppeurDao;
import com.dao.probleme.ProblemeDao;
import com.model.ChallengeTest;
import com.model.Developpeur;
import com.model.Probleme;

@Service("problemeService")
@Transactional
public class ProblemeServiceImpl implements ProblemeService { 
	
	@Autowired
	private ProblemeDao problemeDao;
		
	public void save(Probleme probleme){
		problemeDao.save(probleme);
	}
	
	
	public Probleme findById(int id) {
		return problemeDao.findById(id);
	}

	
}