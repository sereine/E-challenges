package com.service.language;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.language.LanguageDao;
import com.model.Langage;


@Service("languageService")
@Transactional
public class LangageServiceImpl implements LangageService {
    
	@Autowired
	LanguageDao languageDao;
	
	@Override
	public void save(Langage langage) {
 		
		languageDao.save(langage);
		
	}

	@Override
	public Langage findById(int id) {

		return languageDao.findById(id);
	}

	@Override
	public List<Langage> allLanguages() {
		return languageDao.allLanguages();
	}
     
	
	
	
}
