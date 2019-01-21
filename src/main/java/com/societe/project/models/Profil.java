package com.societe.project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.societe.project.database.DBItem;

@Entity
@Table(name="profil")
public class Profil extends DBItem {
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@OneToMany(mappedBy="profil")
	private List<Adresse> adresses = new ArrayList<Adresse>();
	
	@ManyToMany(targetEntity=Role.class)
	private List<Role> roles;
	
	@OneToOne(mappedBy="profil")
	private Compte compte;
	
	@OneToMany(mappedBy="profil")
	private List<Car> cars;

    @OneToMany(targetEntity=PT.class,mappedBy="profil")
    private List<PT> pts;
    
    @OneToMany(targetEntity=Bagage.class,mappedBy="profil")
    private List<Bagage> bagages;
    
	/***********************************************
	 * GETTEUR ET SETTEUR
	 ***********************************************/
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Adresse adresse) {
		this.adresses.add(adresse);
	}
	
    public List<PT> getPT() {
	        return pts;
    }
    
    public void setPT(List<PT> pts) {
        this.pts = pts;
    }
	public void setBagage(List<Bagage> bagages) {
	        this.bagages = bagages;
    }
	
	public List<Bagage> getBagage() {
        return bagages;
    }

    
	/***********************************************
	 * CONSTRUCTEURS
	 ***********************************************/
	public Profil() {
		super();
//		this.adresses = new ArrayList<Adresse>();
		this.roles = new ArrayList<Role>();
		this.cars = new ArrayList<Car>();
		this.pts = new ArrayList<PT>();
		this.bagages = new ArrayList<Bagage>();
		
	}
	
	public Profil(String firstname, String lastname, String phoneNumber) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
	}

	public Profil(String firstname, String lastname, String phoneNumber, List<Adresse> adresses , List<Role> roles, Compte compte, List<Car> cars, List<PT>pts,  List<Bagage>bagages) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.adresses = adresses;
		this.roles = roles;
		this.compte = compte;
		this.cars = cars;
		this.pts = pts;
		this.bagages = bagages;
	}

	@Override
	public String toString() {
		return "Profil [firstname=" + firstname + ", lastname=" + lastname + ", phoneNumber=" + phoneNumber
				+ ", adresses=" + adresses + ", roles=" + roles + ", compte=" + compte + ", cars=" + cars + ", pts="
				+ pts + ", bagages=" + bagages + "]";
	}
	
	
	
	public void afficheProfil() {
		System.out.println("Profil : ");
		System.out.println("name :  "+firstname);
		System.out.println("prenom :  "+lastname);	
	}
	
}
