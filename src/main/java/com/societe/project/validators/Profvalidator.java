package com.societe.project.validators;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.societe.project.models.Profil;

@Component
public class Profvalidator {
	
	private Map<String,String> errors = new HashMap<String,String>();
	
	 /*
	*************************************************
	*    @Gettter Setter
	*************************************************
	*/
  
  	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	 /*
	*************************************************
	*    @method Traitement d'un Profil
	*************************************************
	*/
	
	public boolean validateProfil(Profil profil) {
		
		boolean response = false;
		
		errors.clear();
		
		if (profil.getFirstname().length() < 3 || profil.getFirstname().length() > 32) {
			errors.put("FirstName","Error length firstName");
			response = true;
        }
        if (profil.getFirstname().length() < 3 || profil.getFirstname().length() > 32) {
        	errors.put("LastName","Error length firstNamet");
        	response = true;
        }
		return response;
	}
  
}
