package com.societe.project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.societe.project.database.DBItem;

@Entity
@Table(name="compte")
public class Compte extends DBItem {

	@Column(name = "email", unique = true)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;
	
	@Column(name = "active")
	private int active;
	
	@ManyToOne()
	private Role role;
	
	@OneToMany(targetEntity=Article.class,mappedBy="compte")
	private List<Article> articles;
	
	@OneToOne()
	private Profil profil;

	/***********************************************
	 * GETTEUR ET SETTEUR
	 ***********************************************/
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
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
	public Compte() {
		super();
		this.articles = new ArrayList<Article>();
	}
	
	public Compte(String email, String password, Role role) {
		this();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Compte(
			@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email,
			@Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password,
			int active) {
		this();
		this.email = email;
		this.password = password;
		this.active = active;
	}

	public Compte(String email, String password, Role role, Profil profil) {
		this();
		this.email = email;
		this.password = password;
		this.role = role;
		this.profil = profil;
	}
	
	public Compte(String email, String password, Role role, List<Article> articles, Profil profil) {
		this();
		this.email = email;
		this.password = password;
		this.role = role;
		this.articles = articles;
		this.profil = profil;
	}
	
	
	 /*
	*************************************************
	*    @Methods
	*************************************************
	*/ 
	
	public void afficheCompte() {
		System.out.println("Compte : ");
		System.out.println("email : "+email);
		System.out.println("pass : "+password);
		
	}
}

