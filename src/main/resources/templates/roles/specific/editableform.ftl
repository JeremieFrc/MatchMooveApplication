<form class="text-center border border-light" action="${detailPath}/edit" method="POST">
<#if item??>
    <div>Id</div>
    <#if item.getId()??>
    <div>${item.getId()}</div>
    <input type="hidden" name="id" value="${item.getId()}">
    <#else>
    <div>NA</div>
    </#if>
</#if>
    <div>Name</div>
    <input type="text" name="name" value="<#if item?? && item.getName()??>${item.getName()}</#if>" required>
    <div>Choisir le profil</div>
	<#if profils??>
	    <select name="profil" required>
	        <#list profils as p>
	            <option value=${p.getId()}>${p.getFirstname() + " " + p.getLastname()}</option>
	        </#list>
	    </select>
	</#if>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div><input type="submit" value="Save"></div>
    
</form> 