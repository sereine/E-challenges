package com.dao.professeur;

import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Compte;
import com.model.Developpeur;
import com.model.Professeur;


@Repository("professeurDao")
public class ProfesseurDaoImpl extends AbstractDao<Integer, Professeur>  implements ProfesseurDao {

	public void save(Professeur professeur) {
		
	
		persist(professeur);
		
	}

	public Professeur findById(int id) {
		return getByKey(id);
	}

	public Professeur findBySSO(String sso) {
		return null;
	}

	@Override
	public Professeur findByRef(String ref) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("reference", ref));
		return (Professeur) crit.uniqueResult();
	}


}
