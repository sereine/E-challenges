package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;
import com.validator.EmailUnique;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="CHALLENGER")
public class Challenger{
	
	@Id 
	@GeneratedValue
	@Column(name = "challenger_id")
	private int id;
	
	
	@Valid
	@NotNull
	@OneToOne
	@JoinColumn(name = "compte_id")
	Compte compte;

	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@EmailUnique
	@Email(message="cette format n est pas correcte.")
	@Column(name="EMAIL", nullable=false) 
	private String email;

	@NotEmpty(message="ce champ ne doit pas etre vide.")
	@Pattern(message="format de tel est incorecte" , regexp="^((06)|(05))([0-9]){8}$")
	@Column(name="TEL", nullable=false)
	private String tel;
	
	
	@OneToMany
	@JoinColumn(name = "challenger_id")
	private Set<Solution> solutions = new HashSet<Solution>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public Set<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(Set<Solution> solutions) {
		this.solutions = solutions;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Challenger))
			return false;
		Challenger other = (Challenger) obj;
		if (id != other.id)
			return false;
	
		return true;
	}
	
	
	
}
