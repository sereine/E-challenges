package com.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="langage")
public class Langage {
   
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer id;
	
	@NotEmpty
	@Column(name="NOMLANGAGE")	
	String nomLangage;
	
	@NotNull
	@Column(name="CLEELANGAGE")	
	Integer  cleeLangage;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomLangage() {
		return nomLangage;
	}

	public void setNomLangage(String nomLangage) {
		this.nomLangage = nomLangage;
	}

	public Integer getCleeLangage() {
		return cleeLangage;
	}

	public void setCleeLangage(Integer cleeLangage) {
		this.cleeLangage = cleeLangage;
	}
	
	public String getIdAsString() {
		return new Integer(id).toString();
	}
	
}
