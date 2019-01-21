package com.societe.project.validators;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.societe.project.models.Adresse;
import com.societe.project.models.Car;
import com.societe.project.models.Compte;

@Component
public class CompteValidatorForGestionUser implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Adresse.class.equals(clazz);
	}
	
    public void validate(Object o, Errors errors) {
        Compte compte = (Compte) o;
        
        List<Adresse> adresses = compte.getProfil().getAdresses();
        List<Car> cars = compte.getProfil().getCars();
        
        for (Adresse adresse : adresses) {
        	if (adresse.getNumero() == null) {
                errors.rejectValue("profil.adresses[0].numero", "Le numéro de l'adresse est obligatoire");
            }
        	if (adresse.getRue() == null || adresse.getRue().length() > 38) {
        		errors.rejectValue("profil.adresses[0].rue", "La rue de l'adresse est obligatoire et/ou ne doit pas dépasser 38 caractères");
        	}
        	if (adresse.getCp() == null || adresse.getCp().toString().length() != 5 ) {
        		errors.rejectValue("profil.adresses[0].cp", "Le code postal est obligatoire et/ou doit comporté 5 chiffres");
			}
        	if (adresse.getVille() == null || adresse.getVille().length() > 38 ) {
                errors.rejectValue("profil.adresses[0].ville", "La ville est obligatoire et/ou ne doit pas dépasser 38 caractères");
            }
		}
        
        if (cars.get(0).getMarque() != null && cars.get(0).getModele() != null && cars.get(0).getNombreDePlace() != null && cars.get(0).getImmatriculation() != null) {
	        for (Car car : cars) {
	        	if (car.getMarque().length() < 2 || car.getMarque().length() > 38)  {
	                errors.rejectValue("profil.cars[0].marque", "La marque de la voiture ne doit pas être inférieur à 2 lettres et/ou ne doit pas être supérieur à 38 lettres");
	            }
	        	if (car.getModele().length() < 2 || car.getModele().length() > 38)  {
	                errors.rejectValue("profil.cars[0].modele", "Le modele de la voiture ne doit pas être inférieur à 2 lettres et/ou ne doit pas être supérieur à 38 lettres");
	            }
	        	if (car.getNombreDePlace() < 0 || car.getNombreDePlace() > 8)  {
	                errors.rejectValue("profil.cars[0].nombreDePlace", "Le nombre de place de la voiture ne doit être inférieur ou égale à 0 et/ou ne doit pas être supérieur à 8 places");
	            }
	        	if (car.getImmatriculation().length() != 9)  {
	                errors.rejectValue("profil.cars[0].immatriculation", "L'immatriculation de la voiture doit comporté 9 caractères");
	            }
			}
        }
    }
}
    


