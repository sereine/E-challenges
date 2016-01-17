package com.dao;

import com.model.Compte;

public interface UserDao {

	void save(Compte user);
	
	Compte findById(int id);
	
	Compte findBySSO(String sso);
	
}

