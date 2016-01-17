package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="CHALLENGETEST")
public class ChallengeTest extends Challenge  {
    
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="POSTE")
	String poste;

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="TYPE")
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
