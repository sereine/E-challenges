package com.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;
import com.validator.EmailUnique;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="CHALLENGE")
public class Challenge{
	
	@Id 
	@GeneratedValue
	@Column(name = "challenge_id")
	private int challenge_id;
	

	@Valid
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id")
	Langage langage;

	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="TITRE", nullable=false)
	private String titre;

	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="DESCRIPTION", nullable=false)
	private String description;
	
	//@NotEmpty
	@Column(name="DATE_CREATION", nullable=false)
	private Date date_creation;
	
	//@NotEmpty(message="ce champ ne doit pas etre vide.")
	//@Pattern(message="format de date est incorecte")
	@Column(name="DATE_ECHEANCE", nullable=false)
	private Date date_echeance;
	

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Challenge))
			return false;
		Challenge other = (Challenge) obj;
		if (challenge_id != other.challenge_id)
			return false;
	
		return true;
	}


	public int getId() {
		return challenge_id;
	}


	public void setId(int id) {
		this.challenge_id = id;
	}



	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDate_creation() {
		return date_creation;
	}


	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}


	public Date getDate_echeance() {
		return date_echeance;
	}


	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}


	public Langage getLangage() {
		return langage;
	}


	public void setLangage(Langage langage) {
		this.langage = langage;
	}
	
	
	
}
