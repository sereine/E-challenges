package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;



@Entity
@Table(name="SOLUTION")
@Component
public class Solution {
   
	@Id 
	@GeneratedValue
	@Column(name = "solution_id")
	private int solution_id;
	
	@Column(name="CODE", nullable=false)
	private String code;
	
	@Column(name="TAILLE_FICHIER", nullable=false)
	private Integer tailleFichier;
	
	@Column(name="DATE", nullable=false)
	private  Date date;
	
    @Column(name="TEMPSEXECUTION", nullable=false)
    Float tempsExecution;
	
    @Column(name="SOLUTIONCORRECTE", nullable=false)
   	Boolean solutionCorrecte;
    
    
	@NotNull
	@ManyToOne
	@JoinColumn(name = "challenge_id")
	Challenge challenge;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "challenger_id")
	Challenger challenger;
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Solution))
			return false;
		Solution other = (Solution) obj;
		if (solution_id != other.solution_id)
			return false;
	
		return true;
	}
	
	public int getSolution_id() {
		return solution_id;
	}

	public void setSolution_id(int solution_id) {
		this.solution_id = solution_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getTailleFichier() {
		return tailleFichier;
	}

	public void setTailleFichier(Integer tailleFichier) {
		this.tailleFichier = tailleFichier;
	}
    
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public Challenger getChallenger() {
		return challenger;
	}

	public void setChallenger(Challenger challenger) {
		this.challenger = challenger;
	}

	public Float getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(Float tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

	public Boolean getSolutionCorrecte() {
		return solutionCorrecte;
	}

	public void setSolutionCorrecte(Boolean solutionCorrecte) {
		this.solutionCorrecte = solutionCorrecte;
	}

	
	
	
	
	
	
	
}
