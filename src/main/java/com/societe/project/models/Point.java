package com.societe.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.societe.project.database.DBItem;
@Entity
@Table(name="Point")
public class Point extends DBItem {
	@Column
	 private Double longitude ;
	@Column
	private Double altitude ;
	
	@ManyToOne
	private Trajet trajet ;
	
	/***********************************************
	 * GETTEUR ET SETTEUR
	 ***********************************************/
	
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	public Trajet getTrajet()
	{
		return trajet;}
	
	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	
	/***********************************************
	 * CONSTRUCTEURS
	 ***********************************************/
	
	public Point(Double longitude, Double altitude,Trajet trajet) {
		super();
		this.longitude = longitude;
		this.altitude = altitude;
		this.trajet = trajet;
	}
	 
	public Point() {
	 super();
	}
	/***********************************************
	 * method
	 ***********************************************/
	
	public void affPoint() {
		System.out.println(longitude);
		System.out.println(altitude);
		
	}
	
	
}
