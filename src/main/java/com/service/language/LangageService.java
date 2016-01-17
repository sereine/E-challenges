package com.service.language;

import java.util.List;

import com.model.Langage;

public interface LangageService {
     
	void save(Langage langage);
	
	Langage findById(int id);
	Langage findByName(String nom);
	
	List<Langage> allLanguages();
}
