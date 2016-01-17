package com.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.model.Compte;

@Repository("userDao")
public class CompteDaoImpl extends AbstractDao<Integer, Compte> implements UserDao {

	public void save(Compte user) {
		persist(user);
	}
	
	public Compte findById(int id) {
		return getByKey(id);
	}

	public Compte findBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (Compte) crit.uniqueResult();
	}

}
