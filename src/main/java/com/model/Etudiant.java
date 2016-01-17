package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ETUDIANT")
public class Etudiant extends Challenger {
	
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="CNE")
	private String cne;
    
	
	@Column(name="ACTIVE")
	private boolean active = false;
	
	@ManyToOne
    Classe classe;
	
	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
	
}
