package com.societe.project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.societe.project.database.DBItem;
@Entity
@Table(name="PT")
public class PT extends DBItem {
	
@ManyToOne
@JoinColumn(name = "profil_id",referencedColumnName="id")
private Profil profil;

@ManyToOne
@JoinColumn(name = "trajet_id",referencedColumnName="id")
private Trajet trajet;

@Column
private Integer nbrePlace;

@Column
private Double volumeMax;





/***********************************************
 * GETTEUR ET SETTEUR
 ***********************************************/

	public Integer getNbrePlace() {
		return nbrePlace;
	}
	public void setNbrePlace(Integer nbrePlace) {
		this.nbrePlace = nbrePlace;
	}
	public Double getVolumeMax() {
		return volumeMax;
	}
	public void setVolumeMax(Double volumeMax) {
		this.volumeMax = volumeMax;
	}
	public Trajet getTrajet() {
	    return trajet;
	}
	
	public void setTrajet(Trajet trajet) {
	    this.trajet = trajet;
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

	public PT(Integer nbrePlace, Double volumeMax, Profil profile, Trajet trajet) {
		super();
		this.nbrePlace = nbrePlace;
		this.volumeMax = volumeMax;
		this.profil = profile;
		this.trajet = trajet;
	}	
	public PT() {
		super();
	}
	
	/***********************************************
	 * method
	 ***********************************************/
	
	public void affPT() {
		System.out.println("nombre de place  : "+nbrePlace);
		trajet.affTrajet();
		profil.afficheProfil();
		
		for (Adresse adr : profil.getAdresses()) {
			System.out.println(adr.getStringAdr());
			System.out.println("isdomicile "+adr.getDomicile());
		}
		
		for(Point p : trajet.getPoint()){
			p.affPoint();
		}
	}
}

