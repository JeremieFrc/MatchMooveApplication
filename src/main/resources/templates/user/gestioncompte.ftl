<#import "/spring.ftl" as spring/>
<#include "../blocsCommuns/head.ftl"/>	
<#include "../blocsCommuns/headerUser.ftl"/>	

<link rel="stylesheet" type="text/css" href="<@spring.url '/../css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/../css/bootstrap.min.css'/>"/>			
<link rel="stylesheet" type="text/css" href="<@spring.url '/../css/formCreateUser.css'/>"/>	

<title>Gestion de votre compte</title>
<h3 style="text-align: center">Bonjour ${compte.getProfil().getFirstname()} 🙂 </h3>

<#if errors ?has_content>
	<div class="error" style="text-align: center">
		<#list errors.getAllErrors()as error>
		<p>Afin de valider votre formulaire, veuillez corriger la ou les erreurs suivantes :</p>
		<p>${error.getCode()}</p>
		</#list>
	</div>
</#if>

<div class="l-container l-client">
		<div class="forms form-client">
        	<div class="title-form"><h2>Gestion de votre compte :</h2></div>
				<div class="form-creat" id="form-client">
					<form action="/user/gestioncompte" method="POST">
					<h2>Profil</h2>
						<input type="hidden" name="profil.id" value="${compte.getProfil().getId()}">
						<br>
						<div class="form-group">
                        	<label class="label label-nom" for="nom">Nom :</label>
							<div class="input-group">
								<input class="form-control" type="text" placeholder="Votre nom" name="profil.lastname" value="<#if compte?? && compte.getProfil().getLastname()??>${compte.getProfil().getLastname()}</#if>" required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="label label-nom" for="prenom">Prénom :</label>
							<div class="input-group">
								<input class="form-control" type="text" min=1 placeholder="Votre prénom" name="profil.firstname" value="<#if compte?? && compte.getProfil().getFirstname()??>${compte.getProfil().getFirstname()}</#if>" required>
							</div>
                        </div>
                        
                        <div class="form-group">
							<label class="label label-nom" for="tel">Numéro de téléphone :</label>
							<div class="input-group">
								<input class="form-control" type="number" min=1 placeholder="Votre numéro de téléphone" name="profil.phoneNumber" value="<#if compte?? && compte.getProfil().getPhoneNumber()??>${compte.getProfil().getPhoneNumber()}</#if>" required>
							</div>
                        </div>
                        
                        <div class="form-group">
							<label class="label label-nom" for="mail">Adresse mail :</label>
							<div class="input-group">
								<input class="form-control" type="text" min=1 placeholder="Adresse mail" name="email" value="<#if compte?? && compte.getEmail()??>${compte.getEmail()}</#if>" disabled>
							</div>
                        </div>
                       
        <#if compte.getProfil().getAdresses()?has_content >
			<#assign index = 0>
    		<#list compte.getProfil().getAdresses() as adresse>
    			<#if index == 0>
    			<h2>Adresse Domicile</h2>
    			<br>
    			</#if>
    			<#if index == 1>
    			<h2>Adresse Travail</h2>
    			<br>
    	</#if> 
                        
                       <div class="form-group">
							<label class="label label-nom" for="mail">Numéro :</label>
							<div class="input-group">
								<input type="text" placeholder="numero" name="profil.adresses[${index}].numero" value="<#if adresse.getNumero()??>${adresse.getNumero()}</#if>" required></p>
							</div>
                       </div>
                       
                       <div class="form-group">
							<label class="label label-nom" for="mail">Rue :</label>
							<div class="input-group">
								<input type="text" placeholder="rue" name="profil.adresses[${index}].rue" value="<#if adresse.getRue()??>${adresse.getRue()}</#if>" required></p>
							</div>
                       </div>
                       
                       <div class="form-group">
							<label class="label label-nom" for="mail">Code Postal :</label>
							<div class="input-group">
								<input type="text" placeholder="code postal" name="profil.adresses[${index}].cp" value="<#if adresse.getCp()??>${adresse.getCp()? string ["0"]}</#if>" required></p>
							</div>
                       </div> 
                       
                       <div class="form-group">
							<label class="label label-nom" for="mail">Ville :</label>
							<div class="input-group">
								<input type="text" placeholder="ville" name="profil.adresses[${index}].ville" value="<#if adresse.getVille()??>${adresse.getVille()}</#if>" required></p>
							</div>
                       </div> 
                       
                  <#if index == 0>
					<input type="hidden" name="profil.adresses[${index}].domicile" value="true">
				<#else>
					<input type="hidden" name="profil.adresses[${index}].domicile" value="false">
				</#if>
				<#if adresse.getId()?has_content >
					<input type="hidden" name="profil.adresses[${index}].id" value="${adresse.getId()}">
				</#if>
	  			<input type="hidden" name="profil.adresses[${index}].profil.id" value="${compte.getProfil().getId()}">
				<#assign index++>
    		</#list>
    		<#else>
    			<h2>Adresse Domicile</h2>
    			<br>
    			
    			 <div class="form-group">
							<label class="label label-nom">Numéro :</label>
							<div class="input-group">
								<input type="text" placeholder="numero" name="profil.adresses[0].numero" required>
							</div>
                 </div>

    			 <div class="form-group">
							<label class="label label-nom">Rue :</label>
							<div class="input-group">
								<input type="text" placeholder="rue" name="profil.adresses[0].rue" required>
							</div>
                 </div>
				
				
				<div class="form-group">
							<label class="label label-nom">Code postal :</label>
							<div class="input-group">
								<input type="text" placeholder="code postal" name="profil.adresses[0].cp" required>
							</div>
                 </div>
				
				 <div class="form-group">
							<label class="label label-nom">Ville :</label>
							<div class="input-group">
								<input type="text" placeholder="ville" name="profil.adresses[0].ville" required>
							</div>
                 </div>

				<input type="hidden" name="profil.adresses[0].domicile" value="true">
  				<input type="hidden" name="profil.adresses[0].profil.id" value="${compte.getProfil().getId()}">
  				
  				<h2>Adresse Travail</h2>
  				<br>
  				
  				<div class="form-group">
							<label class="label label-nom">Numéro :</label>
							<div class="input-group">
								<input type="text" placeholder="numero" name="profil.adresses[1].numero" required>
							</div>
                 </div>
  				
  				 <div class="form-group">
							<label class="label label-nom">Rue :</label>
							<div class="input-group">
								<input type="text" placeholder="rue" name="profil.adresses[1].rue" required>
							</div>
                 </div>

				<div class="form-group">
							<label class="label label-nom">Code postal :</label>
							<div class="input-group">
								<input type="text" placeholder="code postal" name="profil.adresses[1].cp" required>
							</div>
                 </div>

				 <div class="form-group">
							<label class="label label-nom">Ville :</label>
							<div class="input-group">
								<input type="text" placeholder="ville" name="profil.adresses[1].ville" required>
							</div>
                 </div>

				<input type="hidden" name="profil.adresses[1].domicile" value="false">
  				<input type="hidden" name="profil.adresses[1].profil.id" value="${compte.getProfil().getId()}">
    		</#if> 
    		
    			<h2>Voiture</h2>
			<div style="position: absolute; left: 300; bottom: -320">
	        	<input class="form-check-input" type="checkbox" value="" id="ignorePass">
				<label class="label label-nom" for="ignoreepass">
					Modifier votre véhicule
				</label>
			</div>
			
<#if compte.getProfil().getCars()?has_content >
			<#assign index = 0>
	    	<#list compte.getProfil().getCars() as voiture>
	    	
				 <div class="form-group">
							<label class="label label-nom">Marque :</label>
							<div class="input-group">
								<input type="text" placeholder="marque" id="marque" name="profil.cars[${index}].marque" value="<#if voiture.getMarque()??>${voiture.getMarque()}</#if>" disabled required>
							</div>
                 </div>	    	
	    	
				 <div class="form-group">
							<label class="label label-nom">Modèle :</label>
							<div class="input-group">
								<input type="text" placeholder="modele" id="modele" name="profil.cars[${index}].modele" value="<#if voiture.getModele()??>${voiture.getModele()}</#if>" disabled required></p> 
							</div>
                 </div>

				 <div class="form-group">
							<label class="label label-nom">Nombre de place :</label>
							<div class="input-group">
								<input type="number" placeholder="nombre de place" id="nbrePlace" name="profil.cars[${index}].nombreDePlace" value="<#if voiture.getNombreDePlace()??>${voiture.getNombreDePlace()}</#if>" disabled required></p>
							</div>
                 </div>				

				 <div class="form-group">
							<label class="label label-nom">Plaque d'immatriculation :</label>
							<div class="input-group">
								<input type="text" placeholder="plaque d'immmatriculation" id="immatriculation" name="profil.cars[${index}].immatriculation" value="<#if voiture.getImmatriculation()??>${voiture.getImmatriculation()}</#if>" disabled required></p>
							</div>
                 </div>					

				
        		<#if voiture.getId() ?has_content >
        			<input type="hidden" name="profil.cars[${index}].id" value="${voiture.getId()}">
        		</#if>
  				<input type="hidden" name="profil.cars[${index}].profil.id" value="${compte.getProfil().getId()}">
  			<#assign index++>
			</#list>
		    <#else>
		    
				 <div class="form-group">
							<label class="label label-nom">Marque :</label>
							<div class="input-group">
								<input type="text" placeholder="marque" id="marque" name="profil.cars[0].marque" disabled required />
							</div>
                 </div>	  		    
		    
				 <div class="form-group">
							<label class="label label-nom">Modèle :</label>
							<div class="input-group">
								<input type="text" placeholder="modele" id="modele" name="profil.cars[0].modele" disabled required/>
							</div>
                 </div>			    
				
				 <div class="form-group">
							<label class="label label-nom">Nombre de place :</label>
							<div class="input-group">
								<input type="number" placeholder="nombre de place" id="nbrePlace" name="profil.cars[0].nombreDePlace" disabled required/>
							</div>
                 </div>	
				
				 <div class="form-group">
							<label class="label label-nom">Plaque d'immatriculation :</label>
							<div class="input-group">
								<input type="text" placeholder="plaque d'immmatriculation" id="immatriculation" name="profil.cars[0].immatriculation" disabled required/>
							</div>
                 </div>					
					
				<input type="hidden" name="profil.cars[0].profil.id" value="${compte.getProfil().getId()}">
		    </#if>     
			</div>
			
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <div><input type="submit" value="Mettre à jour"></div>			
	</form>
	</section>		
            
<script type="text/javascript" src="<@spring.url '/javascript/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript" src="<@spring.url '/javascript/gestionCompte.js'/>"></script>