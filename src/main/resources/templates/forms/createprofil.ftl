<#import "/spring.ftl" as spring/>



<h1> vue create user</h1>


    <form class="text-center border border-light" action="${detailPath}" method="POST">

   <!--////////////////////////////////////////////////////-->
   <!--             Gestion id hiden                        -->
   <!--////////////////////////////////////////////////////-->

    <#if item??>
            <div>Id</div>
            <#if item.getId()??>
            <div>${item.getId()}</div>
            <input type="hidden" name="id" value="${item.getId()}">
            <#else>
            <div>NA</div>
        </#if>
    </#if>

 
    <!--////////////////////////////////////////////////////-->
    <!--              group user                               -->
   <!--////////////////////////////////////////////////////-->
   
    <div class="form-group user">
            
            <div>Nom</div>
            <input type="nom" name="firstname" value="<#if item?? && item.getFirstname()??>${item.getNom()}</#if>" required>
       
            <div>Prenom</div>
            <input type="prenom" name="lastname" value="<#if item?? && item.getLastname()??>${item.getPrenom()}</#if>" required>

    </div>
    
     <!--////////////////////////////////////////////////////-->
   <!--              group select role                          -->
   <!--////////////////////////////////////////////////////-->


   <div class="group-form form-role">
        <div>Choisir le role</div>
            <#if roles??>
            <select name="role" required>
                <#list roles as r>
                    <option value=${r.getId()}>${r.getName()}</option>
                </#list>
            </select>
            </#if>
        <div>
   </div>

    <!--////////////////////////////////////////////////////-->
   <!-   group validate !!importan csrf sinon function pas -->
   <!--////////////////////////////////////////////////////-->

    <div class="group-form formvalidate">
     
     <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
         <input type="submit" value="Save"></div>
    </div>
    
     <div class="error">
    	<#if form??>
	    	<#list form?keys as key> 
	   			<p>	${key}  = ${form[key]} </p>
	   				  
			</#list> 	
    	</#if>
    	
    </div>


</form> 

 