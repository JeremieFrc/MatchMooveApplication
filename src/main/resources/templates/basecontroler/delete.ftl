<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/../css/header.css'/>"/>

<header id="headerAdmin">
	<a href="/home"><div id="logo"><img src="../../images/matchmooveBLANCS.png"></div></a>
	<h1>${pageName}</h1>
</header>

<form class="form" action="${detailPath}/delete" method="POST">
<#include "..${detailPath}/specific/emptyshowform.ftl"/>
<input type="submit" value="Search">
 <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
</form> 

<div>
<#if items??>
<#assign index = 0>
<form action="${detailPath}/deletecriteria" method="POST">
    <#list items as i>
    <#include "..${detailPath}/specific/noteditableform.ftl"/>
    <#assign index++>
    </#list>
    <input type="submit" value="Delete">
     <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
</form>
</#if>
<#if notFound??>
    ${notFound}
</#if>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<#include "../blocsCommuns/footer.ftl"/>