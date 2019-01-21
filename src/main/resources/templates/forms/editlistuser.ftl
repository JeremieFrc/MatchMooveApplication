	
	<div class="match-list">
	 <div id="claque" class="claque">
         <div id="btn-close" class="btn-close">
            <span></span>
         </div>
         <#include "/forms/editformcompte.ftl"/> 
     </div> 
     
      <!--////////////////////////////////////////////////////-->
      <!--           list user		                          -->
      <!--////////////////////////////////////////////////////-->
	
	<div class="listuser">
        <div class="listuser-title">
            <h1>Listes des utilisateurs</h1>
        </div>

         <div class="user-list">
                 <ul class="ul-list">
                  
                 <#if items??>
                 	<#list items as item>
                 		<li class="list-content">
                        <div class="content-cube">
                         <div class="cube"></div>
                        </div>
                        <div class="user-description">
                        
            			   <div id="id">${item.getId()}</div>
                           <div id="email" class="user user-mail">${item.getEmail()}</div>
                           <div id="nom" class="user user-nom">${item.getProfil().getFirstname()}</div>
                           <div id="prenom" class="user user-prenom">${item.getProfil().getLastname()}</div>
                           <div class="user user-phone"> Téléphone : 
                           			<#if item.getProfil().getPhoneNumber()?has_content>
                           				${item.getProfil().getPhoneNumber()}
                           			</#if>
                          </div>
                            <#if item.getProfil().getAdresses()?has_content>
                  
	                           <#list item.getProfil().getAdresses()  as adress>
	                        		<#if adress.getDomicile() == true >
	                           		<div class="user user-adress "> Adresse : ${adress.getVille()}</div>
	                           		<div class="user user-adress "> Postal :  ${adress.getCp()} </div>
	                           		<#else>
	                           			<div class="user user-adress "> Adresse : non renseigné </div>
	                           			<div class="user user-adress "> Postal :  non renseigné </div>	
	                           		</#if>
	                           </#list>	
	                          <#else>
	                           			<div class="user user-adress "> Adresse : non renseigné </div>
	                           			<div class="user user-adress "> Postal :  non renseigné </div>	 	 
                   			</#if>    		
                        </div>
                        
                        <div class="user-delete">
                            <a class="button btn-delete" href="${detailPath}/delete/${item.getId()}">supprimer</a>
                        </div>
                        <div class="user-modified">
                            <a class="button btn-modified" href="#">modifier</a>
                        </div>
                        <div class="file-detail"><span class="btn-detail"></span></div>
                        <div class="br"></div>
                    </li>	
                 	</#list>
                 </#if> 
              </ul>
         </div>
         
         <div class="user-foot">
              <div class="maxsize-user">
                    <div class="maxsize-title">
                        <strong class="infos">Total</strong>
                        <strong class="infos infos-request">12 personnes</strong>
                    </div>
                </div>   
         </div>
    </div>
 </div>	
 <div class="br"></div>
 <script type="text/javascript" src="<@spring.url '/javascript/jquery-3.2.1.min.js'/>"></script>
 <script type="text/javascript" src="<@spring.url '/javascript/listeUsers.js'/>"></script>
 
  	  <!--////////////////////////////////////////////////////-->
      <!--            end list user	                          -->
      <!--////////////////////////////////////////////////////-->