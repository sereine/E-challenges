package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.challengeTest.ChallengeTestDao;
import com.dao.developpeur.DeveloppeurDao;
import com.model.ChallengeTest;
import com.model.Developpeur;

@Service("challengeTestService")
@Transactional
public class ChallengeTestServiceImpl implements ChallengeTestService { 
	
	@Autowired
	private ChallengeTestDao challengeTestDao;
		
	public void save(ChallengeTest challengeTest){
		challengeTestDao.save(challengeTest);
	}
	
	
	public ChallengeTest findById(int id) {
		return challengeTestDao.findById(id);
	}

	
}