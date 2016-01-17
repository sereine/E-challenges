package com.dao.classe;

import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.dao.challenges.ChallengerDao;
import com.model.Challenger;
import com.model.Classe;


@Repository("classeDao")
public class ClasseDaoImpl   extends AbstractDao<Integer, Classe>  implements ClasseDao   {

	@Override
	public void save(Classe classe) {
		persist(classe);
	}

	@Override
	public Classe findById(int id) {
		return getByKey(id);
	}

}
