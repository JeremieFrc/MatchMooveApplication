package com.societe.project.dto;

import org.springframework.stereotype.Service;

import com.societe.project.models.Compte;
import com.societe.project.models.Profil;

@Service
public class CompteProfilDto {

    private Compte compte;
    private Profil profil;
    
    public CompteProfilDto() {
    	super();
    	compte = new Compte();
    	profil = new Profil();
    }
    
    public void createProfit (Profil p) {
    	profil.setFirstname(p.getFirstname());
    	profil.setLastname(p.getLastname());
    }
    
    public void createCompte (Compte c) {
    	compte.setEmail(c.getEmail());
    	compte.setPassword(c.getPassword());
    	compte.setRole(c.getRole());
    } 
    
    public Compte getCreateCompte() {
    	return compte;
    }
    
    public Profil getCreateProfil() {
    	return profil;
    }
}

