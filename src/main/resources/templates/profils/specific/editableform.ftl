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
    <div>Nom</div>
    <input type="text" name="firstname" value="<#if item?? && item.getFirstname()??>${item.getFirstname()}</#if>" required>
    <div>Prenom</div>
    <input type="text" name="lastname" value="<#if item?? && item.getLastname()??>${item.getLastname()}</#if>" required>
    <div>Telephone</div>
    <input type="tel" name="phoneNumber" value="<#if item?? && item.getPhoneNumber()??>${item.getPhoneNumber()}</#if>" required>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div><input type="submit" value="Save"></div>
</form> 