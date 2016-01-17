package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="PROBLEME")
public class Probleme extends Challenge  {
    
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="PRIX")
	float prix;

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
		
	
}
