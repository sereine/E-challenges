package com.dao.language;

import java.util.List;

import com.model.Langage;



public interface LanguageDao {
   
	
void save(Langage language);
	
Langage findById(int id);
Langage findByName(String name);

List<Langage> allLanguages();
	
}
