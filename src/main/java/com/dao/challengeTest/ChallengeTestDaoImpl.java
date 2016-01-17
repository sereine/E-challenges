package com.dao.challengeTest;

import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Challenge;
import com.model.ChallengeTest;


@Repository("challengeTestDao")
public class ChallengeTestDaoImpl  extends AbstractDao<Integer, ChallengeTest>  implements ChallengeTestDao  {

	public void save(ChallengeTest challengeTest) {
		persist(challengeTest);
	}

	public ChallengeTest findById(int id) {
		return getByKey(id);
	}

}