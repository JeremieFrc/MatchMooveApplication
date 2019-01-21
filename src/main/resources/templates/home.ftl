<#import "/spring.ftl" as spring/>

<#include "blocsCommuns/head.ftl"/>	
<#include "blocsCommuns/headerUser.ftl"/>	
<link rel="stylesheet" type="text/css" href="<@spring.url '/css/trajetsActu.css'/>"/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/css/default.css'/>"/>
<title>Home</title>


<h2>Découvrez les derniers trajets !</h2>

	<section id="Trajets"> 
 		<div class="trajetbloc">
			<p>Bain de B</p>
			<p>IMIE RENNES</p>
            <img src="images/PORTRAIT1.jpg" id="portait" class="img-circle">
			<p>Lucile</p>
			<p>Prix 8,50€</p>
        </div>
		<div class="trajetbloc">
			<p>Bain de B</p>
			<p>IMIE RENNES</p>
            <img src="images/PORTRAIT1.jpg" id="portait" class="img-circle">
			<p>Lucile</p>
			<p>Prix 8,50€</p>
        </div>
		<div class="trajetbloc">
			<p>Bain de B</p>
			<p>IMIE RENNES</p>
            <img src="images/PORTRAIT1.jpg" id="portait" class="img-circle">
			<p>Lucile</p>
			<p>Prix 8,50€</p>
        </div>
	</section>
	
	
<#if lastArticles??>
<h2>Nos actualités</h2>

	<section id="Actu"> 
	<#list lastArticles as i>	
    	<div class="actubloc">
			<h5><a style="color: black; text-align:center" href="displayArticle/${i.getId()}"><#if i.getTitle()??> ${i.getTitle()} </#if> </a></h5>
			<p><#if i.getDescription()??> ${i.getDescription()} </#if></p>
			<br>
       		<a href="/articles" title="blog">Lire l'article</a>
       	</div>
        
    </#list>
	</section>
 
</#if>	
<#if trajetMessage?? && userEmail??>
 <#include "popupmsg.ftl">
</#if>
<#include "blocsCommuns/footer.ftl"/>
