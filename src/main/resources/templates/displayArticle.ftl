<#import "/spring.ftl" as spring/>
<#include "blocsCommuns/head.ftl"/>	
<#include "blocsCommuns/headerUser.ftl"/>	

<link rel="stylesheet" type="text/css" href="<@spring.url '/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<@spring.url '/css/header.css'/>"/>

<input type="hidden" readonly name="${article.getId()}" value="<#if article?? && article.getId()??>${article.getId()}<#else>null</#if>">

<div id="displayArticle">
	<h5><label><#if article?? && article.getTitle()?? > ${article.getTitle()}<#else>null</#if> </label></h5>
	<p><label><#if article?? && article.getDescription()?? > ${article.getDescription()}<#else>null</#if> </label></p>
	<h4><label><#if article?? && article.getDate()?? > ${article.getDate()?string["yyyy-MM-dd"]}<#else>null</#if> </label></h4>
</div>