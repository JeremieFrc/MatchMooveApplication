package com.societe.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.societe.project.database.DBItem;

@Entity
@Table(name="adresse")
public class Adresse extends DBItem {
	
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="rue")
	private String rue;
	
	@Column(name="cp")
	private Integer cp;
	
	@Column(name="ville")
	private String ville;
	
	@Column(name="domicile")
	private Boolean domicile;
	
	@ManyToOne()
	private Profil profil;
	
	/***********************************************
	 * GETTEUR ET SETTEUR
	 ***********************************************/
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville.toUpperCase();
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Boolean getDomicile() {
		return domicile;
	}

	public void setDomicile(Boolean domicile) {
		this.domicile = domicile;
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
	public Adresse() {
		super();
	}

	public Adresse(Integer numero, String rue, Integer cp, String ville, Boolean domicile, Profil profil) {
		this();
		this.numero = numero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.domicile = domicile;
		this.profil = profil;
	}

	public void affAdress() {
		System.out.println(ville);
		System.out.println(cp);
		
	}
	
	public String getStringAdr() {
		return numero+" "+rue+" "+ville+" "+cp;
	}
	
}
