<link rel="stylesheet" type="text/css" href="<@spring.url '/css/trajetsActu.css'/>"/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/css/default.css'/>"/>
<section id="Actu"> 
	<div class="actubloc">
			<h3><a style="color: black; text-align:center" href="displayArticle/${i.getId()}"><#if i.getTitle()??> ${i.getTitle()} </#if> </a></h3>
		        <#if i.getTitle()??>
		        	<div>${i.getTitle()}</div>
		        <#else>
		        	<div>NULL</div>
		        </#if>
	        </h3>
	        <p>
		        <#if i.getDescription()??>
		        	<div>${i.getDescription()}</div>
		        <#else>
		        	<div>NULL</div>
		        </#if>
	        </p>
	        <p>
		        <#if i.getDate()??>
		        	<div>${i.getDate()?string["yyyy-MM-dd"]}</div>
		        <#else>
		        	<div>NULL</div>
		        </#if>
		     </p>    
		      
	        <div id="btn">
	            <a href="displayArticle/${i.getId()}" title="btnArticle">Lire l'article</a>
	            <a href="${detailPath}/delete/${i.getId()}" title="btnArticle">Supprimer l'article</a>
	        </div>
	</section>