package com.dao.challenge;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Challenge;


@Repository("challengeDao")
    public class ChallengeDaoImp  extends AbstractDao<Integer, Challenge>  implements ChallengeDao {

	
	
	public void save(Challenge challenge) {
		persist(challenge);
	}

	public Challenge findById(int id) {
		
		return getByKey(id);
	}

	
	
	
	
	public java.util.List<Challenge> criteriaResultat(List<SimpleExpression> listCondition) {
		Criteria criteria  = createEntityCriteria();
		Iterator<SimpleExpression> iterator = listCondition.iterator();
		while (iterator.hasNext()) {
			criteria.add(iterator.next());
		}
		
		return criteria.list();
	}
	

}
