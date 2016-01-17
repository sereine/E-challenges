package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="DEVELOPPEUR")
public class Developpeur extends Challenger  {
    
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="DESCRIPTION")
	String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
