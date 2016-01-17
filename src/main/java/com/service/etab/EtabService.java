package com.service.etab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Challenger;
import com.model.Compte;
import com.model.Etablissement;

public interface EtabService {
   

	
public void save(Etablissement etab);
	
	public Etablissement findById(int id);

	public List<Etablissement> allEtab();
	
}
