      
<#import "/spring.ftl" as spring/>

 	  <!--////////////////////////////////////////////////////-->
      <!--             menu	user		                      -->
      <!--////////////////////////////////////////////////////-->

  				<nav>
          			<ul>
           			
   						<#if roles??>
    						<#list roles as r>
            					<#if r=="ROLE_ADMIN">
            						<li><a href="#">Administrateur</a></li>
            					</#if>
        					</#list>
   						</#if>
   						<#if roles??>
    						<#list roles as r>
            					<#if r=="ROLE_USER">
            						<li><a href="#">Utilisateur</a></li>
            					</#if>
        					</#list>
   						</#if>
   						<#if notlogin?has_content>
            					<#if notlogin==true>
            						<li><a href="${login}">${anonyme}</a></li>
            					</#if>	
            			</#if>
            			<li><a href="/user/gestioncompte"><img src="images/profil.png"</a></li>
            			
                            <li><a href="/user/researchtrajet">Proposer</a></li>
			              	<li><a href="/user/proposertrajet">Rechercher</a></li>
			                
			                <li><a href="/articles">BLOG</a></li>
			                <li><a href="/messagerie">Messagerie</a></li>
			                
			
						    <li><a href="/logout"><img src="images/logout.png"></a></li>
                    </ul>          
				</nav>	
				         
	            
	              
	                
	                  
	                    
	                      
	                        
	                          
	                            
	                              
	                                
	                                  
	                                    
	                                      
	                                        
	                                          
	                                            
	                                              
	                                                
	                                                  
	                                                    
	                                                      
	                                                        
	