package com.dao.developpeur;

import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Challenger;
import com.model.Developpeur;


@Repository("developpeurDao")
public class DeveloppeurDaoImpl  extends AbstractDao<Integer, Developpeur>  implements DeveloppeurDao  {

	public void save(Developpeur developpeur) {
		persist(developpeur);
	}

	public Developpeur findById(int id) {
		return getByKey(id);
	}

	public Developpeur findBySSO(String sso) {
		return null;
	}

}
