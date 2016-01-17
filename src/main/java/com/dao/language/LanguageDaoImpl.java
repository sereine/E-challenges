package com.dao.language;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.dao.developpeur.DeveloppeurDao;
import com.model.Developpeur;
import com.model.Langage;



@Repository("languageDao")
public class LanguageDaoImpl  extends AbstractDao<Integer, Langage>  implements LanguageDao  {

	@Override
	public void save(Langage language) {
		
		persist(language);
		
	}

	@Override
	public Langage findById(int id) {
       
		return getByKey(id);
		
	}

	@Override
	public List<Langage> allLanguages() {
		Criteria crit = createEntityCriteria();
		return crit.list();
	}
	
	
	@Override
	public Langage findByName(String name)
	{
		Query query = getSession().createQuery("from Langage l where l.nomLangage = :nom");
		query.setString("nom", name);
		return  (Langage) query.uniqueResult();
		
	}

	

	
	
	
}
