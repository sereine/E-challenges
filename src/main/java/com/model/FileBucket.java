package com.model;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;



public class FileBucket {
	 
    MultipartFile file;
    String nomClasse; 
    Etablissement etabs;
    
    
    
    
    public Etablissement getEtabs() {
		return etabs;
	}

	public void setEtabs(Etablissement etabs) {
		this.etabs = etabs;
	}

	public MultipartFile getFile() {
        return file;
    }
 
    public void setFile(MultipartFile file) {
        this.file = file;
    }

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
    
    
}