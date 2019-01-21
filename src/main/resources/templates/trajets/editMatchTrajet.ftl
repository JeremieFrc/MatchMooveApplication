<#import "/spring.ftl" as spring/>

<link rel="stylesheet" type="text/css" href="<@spring.url '../css/map.css'/>"/>
<link rel="stylesheet" type="text/css" href="<@spring.url '../css/listTrajet.css'/>"/>


   <!--////////////////////////////////////////////////////-->
   <!--             Message                                -->
   <!--////////////////////////////////////////////////////-->  
   
   <#include "../trajets/messagesTrajet.ftl"/>
  
   <!--////////////////////////////////////////////////////-->
   <!--            listTrajeT                                  -->
   <!--////////////////////////////////////////////////////-->

  <#include "/trajets/listTrajet.ftl"/>

   <!--////////////////////////////////////////////////////-->
   <!--             Script api                             -->
   <!--////////////////////////////////////////////////////-->  
   
   <#include "/trajets/jsapigoogle.ftl"/>
   