package com.societe.project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.societe.project.database.DBItem;

@Entity
@Table(name="article")
public class Article extends DBItem {
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	@Type(type="text")
	private String description;
	
	@Column(name="date_post")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ManyToOne()
	private Compte compte;

	/***********************************************
	 * GETTEUR ET SETTEUR
	 ***********************************************/
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/***********************************************
	 * CONSTRUCTEURS
	 ***********************************************/
	public Article() {
		super();
	}

	public Article(String title, String description, Date date, Compte compte) {
		this();
		this.title = title;
		this.description = description;
		this.date = date;
		this.compte = compte;
	}

}
