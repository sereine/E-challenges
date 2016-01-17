package com.dao.entreprise;

import java.util.List;

import org.hibernate.criterion.SimpleExpression;

import com.model.Entreprise;


public interface EntrepriseDao {
    
	 void save(Entreprise entreprise);
	 Entreprise findById(int id);
	 java.util.List criteriaResultat(List<SimpleExpression> listCindition);

	
}
