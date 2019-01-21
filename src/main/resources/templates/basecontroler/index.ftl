<#import "/spring.ftl" as spring/>

<link rel="stylesheet" type="text/css" href="<@spring.url '/../css/header.css'/>"/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/../css/default.css'/>"/>
<header id="headerAdmin">

	<a href="/home"><div id="logo"><img src="../images/matchmooveBLANCS.png"></div></a>
		<nav>
			<ul>
				<li><a href="${detailPath}/edit/">Nouveau</a></li>
                <li><a href="${detailPath}/find/">Trouver par critères</a></li>
                <li><a href="${detailPath}/delete/">Suppression par critères</a></li>  
             </ul>
		</nav>	

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
		<div id="flex">
<#if items??>
	<#list items as i>
		<#include "..${detailPath}/specific/show.ftl"/>
	</#list>
</#if>
</div>
</header>


<#include "../blocsCommuns/footer.ftl"/>	


