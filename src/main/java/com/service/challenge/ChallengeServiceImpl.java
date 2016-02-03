package com.service.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.challenge.ChallengeDao;
import com.dao.challengeTest.ChallengeTestDao;
import com.model.Challenge;
import com.model.Langage;



@Service("challengeService")
@Transactional
public class ChallengeServiceImpl  implements ChallengesService {
    

	@Autowired
	private ChallengeDao challengeDao;
	
	@Override
	public void save(Challenge challenge) {
		challengeDao.save(challenge);
	}

	@Override
	public Challenge findById(int id) {
        return challengeDao.findById(id) ;
	}

	@Override
	public Challenge findByLangage(Langage langage) {

		return null;
	}

}
