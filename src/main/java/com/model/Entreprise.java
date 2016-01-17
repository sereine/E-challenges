package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;
import com.validator.EmailPro;
import com.validator.EmailUnique;



@Entity
@Table(name="entreprise")
public class Entreprise {
    
	@Id 
	@GeneratedValue
	private int id;
	
	
	@Valid
	@NotNull
	@OneToOne
	@JoinColumn(name = "compte_id")
	Compte compte;
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="nomEntreprise", nullable=false)
	String nomEntreprise;
	
	@NotNull
	@Column(name="taille", nullable=false)
	Integer taille;
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="adresse", nullable=false)
	String adresse;
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="description", nullable=false)
	String description;
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Pattern(message="format de tel est incorecte" , regexp="^((06)|(05))([0-9]){8}$")
	@Column(name="tel", nullable=false)
	String tel;
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@EmailUnique
	@EmailPro(message="Vous devrez saisire un email professionnelle.")
	@Column(name="email", nullable=false)
	String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public Integer getTaille() {
		return taille;
	}

	public void setTaille(Integer taille) {
		this.taille = taille;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
	
}
