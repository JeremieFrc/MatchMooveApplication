<link rel="stylesheet" type="text/css" href="<@spring.url '../css/bootstrap.min.css'/>"/>			
<link rel="stylesheet" type="text/css" href="<@spring.url '../css/formCreateUser.css'/>"/>	
 <!-- formulaire de creation client -->
        <div class="l-container l-client">

      <!--////////////////////////////////////////////////////-->
      <!--             Gestion id hiden                        -->
      <!--////////////////////////////////////////////////////-->

                <#if item??>
                        <div>Id</div>
                    <#if item.getId()??>
                        <div>${item.getId()}</div>
                        <input type="hidden" name="id" value="${item.getId()}">
                        <#else>
                        <div>NA</div>
                    </#if>
                </#if>

            <div class="forms form-client">
                <div class="title-form"><h2>Création d'un nouveau compte :</h2></div>
                
                <div class="form-creat" id="form-client">

                    <form id="f-client" action="${detailPath}" method="POST">
                        
                        
                         <!--form group -->
                              
                                 <input type="hidden" name="id" value="">
                                
                         <!--form group -->
                         <!--form group -->
                            <div class="form-group">
                                <label class="label label-nom" for="nom">Nom :</label>
                                 <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input id="firstname" name="firstname" placeholder="Votre nom" value="" class="form-control" type="text" required>
                                 </div>
                            </div>
                        <!-- end form group -->
                        <!--form group -->
                            <div class="form-group">
                                <label class="label label-nom" for="lastname">Prénom :</label>
                                 <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input id="lastname" name="lastname" placeholder="Votre prénom" class="form-control" type="text" required>
                                 </div>
                            </div>
                        <!-- end form group -->

                        <!--form group -->
                            <div class="form-group">
                                <label class="label label-nom" for="email">Adresse email :</label>
                                 <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                    <input id="email" name="email" placeholder="Votre adresse email" class="form-control" type="text" value="<#if item?? && item.getEmail()??>${item.getEmail()}</#if>" required>
                                 </div>
                            </div>
                        <!-- end form group -->

                        <!--form group -->
                            <div class="form-group">
                                <label class="label label-nom" for="password">Mot de passe :</label>
                                 <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                                    <input id="password" name="password" placeholder="Votre mot de passe" class="form-control" type="password" value="<#if item?? && item.getPassword()??>${item.getPassword()}</#if>" required>
                                 </div>
                            </div>
                        <!-- end form group -->
                        
                         <!--form group -->
                            <div class="form-group">
                                <label class="label label-nom" for="confirm">Confirmation :</label>
                                 <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                                    <input id="confirm" name="confirm" placeholder="Votre mot de passe" class="form-control" type="password" required>
                                 </div>
                            </div>
                        <!-- end form group -->
                        
                        <!-- end form group -->
                         <div class="form-group">
                            <label class="label label-nom" for="role">Votre role :</label>
                            <#if roles??>
                            	<select name="role" required>
						             <#list roles as role>
						                  <option value="${role.getId()}">${role.getName()}</option>
						             </#list>
            					</select>
           					 </#if>
                         </div>
                        <!-- end form group -->   
                       
                         <#if update??>
	                         <!-- end form group -->
	                         <div class="form-group">
	                        	<input class="form-check-input" name="ignore" type="checkbox" value="" id="ignorePass">
	  							<label class="label label-nom" for="ignoreepass">
	    						 Ignore pass :
	  							</label>
	  						 </div>
	  						 <!-- end form group -->   
                         </#if>
                        
					 
                        <!--Button Submit and clear -->
                             <!--form group -->

                        <div class="form-group form-btn">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input class="button btn-delete" id="valider" name="valider" value="Valider" type="submit">
                                <span class="glyphicon glyphicon-send"></span>
                            </button>
                            <input class="button btn-delete" name="reset" type="reset" value="Réinitialiser">
                                    <span class="glyphicon glyphicon-trash"></span>
                            </button>
                        </div>


                             <!-- end form group -->
                        <!--End Button Submit and clear -->
                    </form>
                </div>

            </div>
        </div> 

        <div class="error">
            <#if isExistMail??>
                <#if isExistMail == true>
                    <p> l'adresse mail existe </p>
                </#if>
            </#if>
            <#if form??>
                <#list form?keys as key> 
                    <p> ${key}  = ${form[key]} </p>
                          
                </#list>    
            </#if>
        </div>