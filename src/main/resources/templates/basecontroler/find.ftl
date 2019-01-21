<#import "/spring.ftl" as spring/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/../css/header.css'/>"/>

<header id="headerAdmin">
	<a href="/home"><div id="logo"><img src="../../images/matchmooveBLANCS.png"></div></a>
	<h1>${pageName}</h1>
</header>

<form class="form" action="${detailPath}/find" method="POST">
<#include "..${detailPath}/specific/emptyshowform.ftl"/>
<br><input type="submit" value="Search">
 <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
</form> 

<div>
<#if items??>
    <#list items as i>
        <#include "..${detailPath}/specific/show.ftl"/>
    </#list>
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