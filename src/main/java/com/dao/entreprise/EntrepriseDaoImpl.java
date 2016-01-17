package com.dao.entreprise;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Challenger;
import com.model.Classe;
import com.model.Entreprise;


@Repository("entrepriseDao")
public class EntrepriseDaoImpl  extends AbstractDao<Integer, Entreprise>  implements EntrepriseDao {

	@Override
	public void save(Entreprise entreprise) {
		persist(entreprise);
	}

	@Override
	public Entreprise findById(int id) {
		return getByKey(id);
	}

	@Override
	public java.util.List<Entreprise> criteriaResultat(List<SimpleExpression> listCondition) {
		Criteria criteria  = createEntityCriteria();
		Iterator<SimpleExpression> iterator = listCondition.iterator();
		while (iterator.hasNext()) {
			criteria.add(iterator.next());
		}
		
		return criteria.list();
	}

}
