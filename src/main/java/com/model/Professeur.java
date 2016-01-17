package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.validator.EmailUnique;
import com.validator.RefExiste;
import com.validator.RefUnique;

@Entity
@Table(name="PROFESSEUR")
public class Professeur extends Challenger {
	
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@RefExiste
	@RefUnique(message="SVP changer  cette reference.")
	@Column(name="REFERENCE", unique=true, nullable=false)	
    String reference;

    
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "CLASSE_PROF", 
             joinColumns = { @JoinColumn(name = "Prof_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "CLASSE_ID") })
	private Set<Classe> classeProfs = new HashSet<Classe>();
	
	
	
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	
	
	
	
}
