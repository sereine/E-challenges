package com.service.classe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.challenges.ChallengerDao;
import com.dao.classe.ClasseDao;
import com.model.Challenger;
import com.model.Classe;
import com.model.Compte;


@Service("classeService")
@Transactional
public class ClasseServiceImpl implements ClasseService  {
    
	@Autowired
	private ClasseDao classeDao;
	
	@Override
	public void save(Classe classe) {
		classeDao.save(classe);
	}

	@Override
	public Classe findById(int id) {
		return classeDao.findById(id);
	}

	

}
