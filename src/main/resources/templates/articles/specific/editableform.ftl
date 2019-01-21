<form class="text-center border border-light" action="${detailPath}/edit" method="POST">
<#if item??>
    
    <#if item.getId()??>
    <input type="hidden" name="id" value="${item.getId()}">
    </#if>
</#if>
    <div>Titre</div>
    <input type="text" name="title" value="<#if item?? && item.getTitle()??>${item.getTitle()}</#if>" required>
    <div>Description</div>
    <textarea 
    rows="5" 
    cols="60"  
    name="description" 
    value="<#if item?? && item.getDescription()??>${item.getDescription()}</#if>" 
    required>
    <#if item?? && item.getDescription()??>${item.getDescription()}</#if>
    </textarea>
    
    <div>Date</div>
    <input type="date" name="date" value="<#if item?? && item.getDate()??>${item.getDate()?string["yyyy-MM-dd"]}</#if>" required>

    
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div><input type="submit" value="Save"></div>
</form> 