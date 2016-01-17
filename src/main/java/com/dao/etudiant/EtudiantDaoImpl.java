package com.dao.etudiant;

import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.model.Etudiant;

@Repository("etudiantDao")
public class EtudiantDaoImpl  extends AbstractDao<Integer, Etudiant>  implements EtudiantDao {

	public void save(Etudiant etudiant) {
		persist(etudiant);
	}

	public Etudiant findById(int id) {
		return getByKey(id);
	}

	public Etudiant findBySSO(String sso) {
		return null;
	}

}
