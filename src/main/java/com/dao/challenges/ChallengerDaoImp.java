package com.dao.challenges;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Challenger;


@Repository("challengerDao")
    public class ChallengerDaoImp  extends AbstractDao<Integer, Challenger>  implements ChallengerDao {

	
	
	public void save(Challenger challenger) {
		persist(challenger);
	}

	public Challenger findById(int id) {
		
		return getByKey(id);
	}

	public Challenger findBySSO(int id_compte) {
		
        return null;
        
	}
	
	
	
	public java.util.List<Challenger> criteriaResultat(List<SimpleExpression> listCondition) {
		Criteria criteria  = createEntityCriteria();
		Iterator<SimpleExpression> iterator = listCondition.iterator();
		while (iterator.hasNext()) {
			criteria.add(iterator.next());
		}
		
		return criteria.list();
	}
	

}
