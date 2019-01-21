package com.societe.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.societe.project.database.DBItem;

@Entity
@Table(name="car")
public class Car extends DBItem {
	
	@Column(name="marque")
	private String marque;
	
	@Column(name="modele")
	private String modele;
	
	@Column(name="nombreDePlace")
	private Integer nombreDePlace;
	
	@Column(name="immatriculation")
	private String immatriculation;
	
	@ManyToOne()
	private Profil profil;
	
	/***********************************************
	 * GETTEUR ET SETTEUR
	 ***********************************************/
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Integer getNombreDePlace() {
		return nombreDePlace;
	}

	public void setNombreDePlace(Integer nombreDePlace) {
		this.nombreDePlace = nombreDePlace;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	/***********************************************
	 * CONSTRUCTEURS
	 ***********************************************/
	public Car() {
		super();
	}

	public Car(String marque, String modele, Integer nombreDePlace, String immatriculation, Profil profil) {
		this();
		this.marque = marque;
		this.modele = modele;
		this.nombreDePlace = nombreDePlace;
		this.immatriculation = immatriculation;
		this.profil = profil;
	}
	
	
}
