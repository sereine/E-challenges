package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.dao.UserProfileDaoImpl;
import com.model.Compte;
import com.model.UserProfile;

@Service("compteService")
@Transactional
public class CompteServiceImpl implements CompteService{

	@Autowired
	private UserDao dao;
	
	@Autowired
	private UserProfileDaoImpl userProfileDaoImpl;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public void save(Compte user){
		
		UserProfile userProfile = userProfileDaoImpl.findById(4);
		
		if(userProfile == null)
		{
			
			
			userProfile = new UserProfile();
			userProfile.setType("USER");
			userProfileDaoImpl.persist(userProfile);
			
			userProfile = new UserProfile();
			userProfile.setType("ADMIN");
			userProfileDaoImpl.persist(userProfile);
			
			
			Compte userAdmin = new Compte(); 
			
			userAdmin.setState("Active");
			userAdmin.setSsoId("admin");;
			userAdmin.setPassword("admin");
			userAdmin.getUserProfiles().add(userProfile);
			
					
			userAdmin.setPassword(passwordEncoder.encode(userAdmin.getPassword()));
			dao.save(userAdmin);
			
			
			userProfile = userProfileDaoImpl.findById(4);
            
			
		}
	    
		user.getUserProfiles().add(userProfile);
		user.setState("Active");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}
	
	public Compte findById(int id) {
		return dao.findById(id);
	}

	public Compte findBySso(String sso) {
		return dao.findBySSO(sso);
	}

	@Override
	public boolean compteExist(String sso) {
		if( findBySso(sso) == null ) 
			return false;
		return true;
	}
	
}
