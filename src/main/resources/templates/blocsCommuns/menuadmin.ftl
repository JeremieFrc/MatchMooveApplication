   <#import "/spring.ftl" as spring/>                                                       
	  <!--////////////////////////////////////////////////////-->
      <!--             menu	admin		                          -->
      <!--////////////////////////////////////////////////////-->

  				<nav>
          			<ul>
           				<#if roles??>
    						<#list roles as r>
            					<#if r=="ROLE_ADMIN">
            						<li><a href="/admin/">Administrateur</a></li>
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
   						<#if notlogin??>
            					<#if notlogin==true>
            						<li><a href="${login}">${anonyme}</a></li>
            					</#if>	
            			</#if>
            			
                        <li><a href="/admin/createcompte">Ajout Client     </a></li>
                        <li><a href="/admin/listuser">Gestion User    </a></li>
                        
                        <li><a href="#">Ajout Article    </a></li>
                        <li><a href="#">Modifier Article </a></li>
                        
                        <li><a href="#">BLOG</a></li>
			     		<li>
			     			<a href="/logout"><img src="../img/logout.png"></a>
			     		</li>
                    </ul>          
				</nav>	
				
		</header>