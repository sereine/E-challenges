package com.service;

import com.model.Compte;

public interface CompteService {

	void save(Compte user);
	
	Compte findById(int id);
	
	Compte findBySso(String sso);
	
	public boolean compteExist(String sso);
	
}