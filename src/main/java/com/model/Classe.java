package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;


@Entity
@Table(name="classe")
public class Classe {
    
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer id;
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="NOM")	
    String nom;
	
	@Column(name="NBRetudiants")	
	Integer nbrEtudiants;
    
	@ManyToOne(optional = false)
    @JoinColumn(name="ETABLISSEMENT_ID")
    Etablissement etablissement;	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "CLASSE_PROF", 
             joinColumns = { @JoinColumn(name = "CLASSE_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "Prof_ID") })
	private Set<Professeur> classeProfs = new HashSet<Professeur>();
	
	
	@OneToMany(mappedBy="classe")
    private Set<Etudiant> etudiants = new HashSet<Etudiant>();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNbrEtudiants(Integer nbrEtudiants) {
		this.nbrEtudiants = nbrEtudiants;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public int getNbrEtudiants() {
		return nbrEtudiants;
	}

	public void setNbrEtudiants(int nbrEtudiants) {
		this.nbrEtudiants = nbrEtudiants;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public Set<Professeur> getClasseProfs() {
		return classeProfs;
	}

	public void setClasseProfs(Set<Professeur> classeProfs) {
		this.classeProfs = classeProfs;
	}

	
	
	
}
