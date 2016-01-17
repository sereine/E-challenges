package com.service.etab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.etab.EtabDaoImpl;
import com.dao.etab.EtabDaoImpl;
import com.dao.professeur.ProfesseurDao;
import com.model.Challenger;
import com.model.Compte;
import com.model.Etablissement;




@Service("etabService")
@Transactional
public class EtabServiceImpl implements EtabService {
    
	
	@Autowired
	private EtabDaoImpl dao;
	
	public void save(Etablissement etab) {
		dao.save(etab);
	}

	public Etablissement findById(int id) {

		return dao.findById(id);
	}

	@Override
	public List<Etablissement> allEtab() {
        
		return dao.allEtab();
	}


}
