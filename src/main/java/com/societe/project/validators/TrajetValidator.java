/**
 * 
 */
package com.societe.project.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.societe.project.models.Trajet;

/**
 * @author Fabrice
 *
 */
@Component
public class TrajetValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {
		
		Trajet trajet = (Trajet) o;
		
		if (trajet.getNom() == null || trajet.getNom().length() < 4 ||trajet.getNom().length() > 38) {
			errors.rejectValue("nom", "Le nom du trajet est obligatoire et/ou doit �tre sup�rieur � 4 caract�res et/ou ne doit pas d�passer 38 caract�res");
		}
		
		
	}

}
