package com.dao.probleme;

import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Probleme;


@Repository("problemeDao")
public class ProblemeDaoImpl  extends AbstractDao<Integer, Probleme>  implements ProblemeDao  {

	public void save(Probleme probleme) {
		persist(probleme);
	}

	public Probleme findById(int id) {
		return getByKey(id);
	}

}