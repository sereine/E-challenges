package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="ETABLISSEMENT")
public class Etablissement {
    
	
	@Id 
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="NOMETA")	
    String nomEta;
    
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="ADRESSEETA")	
    String adresseEta;
    
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="etablissement")
    private Set<Classe> classes = new HashSet<Classe>();
	
	
	public int getId() {
		return id;
	}

	public void setId(int idEtab) {
		this.id = idEtab;
	}

	public String getNomEta() {
		return nomEta;
	}

	public void setNomEta(String nomEta) {
		this.nomEta = nomEta;
	}

	public String getAdresseEta() {
		return adresseEta;
	}

	public void setAdresseEta(String adresseEta) {
		this.adresseEta = adresseEta;
	}
	
	
	public String getIdAsString() {
		return new Integer(id).toString();
	}

	public Set<Classe> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}

	
	
	
	
}
