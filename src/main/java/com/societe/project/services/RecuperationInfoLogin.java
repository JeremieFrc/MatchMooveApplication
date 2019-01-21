package com.societe.project.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.societe.project.models.Compte;

@Service
public class RecuperationInfoLogin {
	
	@Autowired
	CompteService compteService;
	
	public ArrayList<String> recuperationRole() {
		
		ArrayList<String> roles = new ArrayList<>();
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		
		Collection<? extends GrantedAuthority> role = securityContext.getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : role) {
			roles.add(grantedAuthority.getAuthority());
		}
		return roles;
	}
	
	public Compte recuperationCompteForUserLogge() {
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		String email = securityContext.getAuthentication().getName();
		Compte compte = compteService.finByEmailCompte(email);
		return compte;
	}
	
	
}
