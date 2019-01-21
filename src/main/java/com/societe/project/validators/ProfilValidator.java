package com.societe.project.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.societe.project.models.Profil;

@Component
public class ProfilValidator  implements Validator{

	 public boolean supports(Class<?> aClass) {
	        return Profil.class.equals(aClass);
	    }
	
	public void validate(Object o, Errors errors) {
	        Profil profil = (Profil) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
	        if (profil.getFirstname().length() < 3 || profil.getFirstname().length() > 32) {
	            errors.rejectValue("nom", "Size.profilForm.nom");
	        }
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty");
	        if (profil.getFirstname().length() < 3 || profil.getFirstname().length() > 32) {
	            errors.rejectValue("prenom", "Size.profilForm.prenom");
	        } 
	   }
}
