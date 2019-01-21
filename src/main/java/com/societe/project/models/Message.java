package com.societe.project.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.societe.project.database.DBItem;

@Entity
@Table(name="message")
public class Message extends DBItem {
	
	/*
	*************************************************
	*    @Private
	*************************************************
	 */
	
	
	@Column(name="content")
	private String content;
	
	
	@Column(name="date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(name="archive")
	private Boolean archive;
	
	@OneToMany(targetEntity=Message.class)
	private List<Message> messages;
	
	@ManyToOne
	@JoinColumn(name = "trajet_id",referencedColumnName="id")
	private Trajet trajet; 
	
	@ManyToOne
	@JoinColumn(name = "profil_id",referencedColumnName="id")
	private Profil profil;
	
	/*
	*************************************************
	*    @Contructeur
	*************************************************
	 */
	public Message(String content,Date date,Trajet trajet,Profil profil,List<Message> messages)
	{
		
		this.content = content;
		this.date = date;
		this.trajet = trajet;
		this.profil = profil;
		this.messages = messages;
	}
	
	public Message(String content, Date date, Trajet trajet, Profil profil) {
		super();
		this.content = content;
		this.date = date;
		this.trajet = trajet;
		this.profil = profil;
	}


	public Message(String content,Date date,Profil profil)
	{
		
		this.content = content;
	    this.date = date;
	    this.profil = profil;
	}
	
	public Message(String content)
	{
		this.content = content;
	    this.date = new Date();
	}
	
	public Message() {
		super();
	}
	
	
	/*
	*************************************************
	*    @Getter setter
	*************************************************
	 */


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> message) {
		this.messages = message;
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
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	
	/*
	*************************************************
	*    @Method
	*************************************************
	 */
	
	
}
