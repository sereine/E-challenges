package com.dao.etab;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Etablissement;
import com.model.Professeur;


@Repository("etabDao")
public class EtabDaoImpl  extends AbstractDao<Integer, Etablissement>    implements EtabDao {

	public void save(Etablissement etab) {
		persist(etab);
	}

	public Etablissement findById(int id) {

		return getByKey(id);
	}

	public List<Etablissement> allEtab() {
		Criteria crit = createEntityCriteria();
		return crit.list();
	}
    
	
	
}
