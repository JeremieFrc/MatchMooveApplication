<#import "/spring.ftl" as spring/>     

<link rel="stylesheet" type="text/css" href="<@spring.url '../css/header.css'/>"/>

<header>
	<a href="/home"><div id="logo"><img src="/images/matchmooveBLANCS.png"></div></a>
		<nav>
 			<ul>
            	
   				<li><a href="/user/gestioncompte"><img src="/images/profil.png"></a></li>
                <#if roles??>
    				<#list roles as r>
            		<#if r=="ROLE_ADMIN">
            			<li><a href="/admin">Admin</a></li>
            		</#if>
        			</#list>
   				</#if>             
                <li><a href="/user/proposertrajet">Proposer</a></li>
              	<li><a href="/user/researchtrajet">Rechercher</a></li>   
              	<li><a href="/user/vostrajet">Vos trajets</a></li>     
              	      
                <li><a href="/articles">BLOG</a></li>
                <li><a href="/messagerie">Messagerie</a></li>
			    <li><a href="/logout"><img src="/images/logout.png"></a></li>
             </ul>
		</nav>
		
		<h1>Matchez, Partagez la route !</h1>
</header>