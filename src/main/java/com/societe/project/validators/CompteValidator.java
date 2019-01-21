package com.societe.project.validators;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.societe.project.models.Compte;
import com.societe.project.services.CompteService;

@Component
public class CompteValidator  {

	  @Autowired
	  private CompteService compteService;
	  
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
		*    @method Traitement d'un Compte
		*************************************************
		*/
		
		public boolean validateCompteAndPassWord(Compte compte) {
			
			boolean response = false;
			
			errors.clear();
			
			Compte c = compteService.finByEmailCompte(compte.getEmail());
			
			if(c != null) {
				response = true;
				errors.put("Email","Email exist");
				System.out.println("error validator email");
				
				
			}
			
			if(!compte.getEmail().matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)") ){
				response = true;
				errors.put("Email","Error de format");
			}
		
			if(this.isValidatePassword(compte)) {
				System.out.println("error validator pass");
			    errors.put("password","Size.compteForm.password");
			    response = true;
			}
			
			return response;
		}
		
		public boolean isValidatePassword(Compte compte) {
			boolean response = false;
			if (compte.getPassword().length() < 8 || compte.getPassword().length() > 32) {
	            response = true;
	        }
			return response;
		}
		
		public boolean isValidateEmail(Compte compte) {
			return(!isExistCompte(compte.getEmail())) ? true : false;
		}
		
		public boolean isExistCompte(String mail) {
			
			Compte compte = compteService.finByEmailCompte(mail);
			boolean response = false;

			if(compte != null) {
				response = true;
				errors.put("Email","Email exist");
			}
			return response ;
		}
		
		public boolean isComparePass(String pass,String confirm) {		
			return (pass.equals(confirm)) ? true : false;
		}

}
