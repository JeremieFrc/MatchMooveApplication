
<form class="text-center border border-light" action="${detailPath}/edit" method="POST">

<#if item??>
    <#if item.getId()??>
    <input type="hidden" name="id" value="${item.getId()}">
    </#if>
</#if>  
    <div>nom</div>
    <input type="text" name="nom" value="<#if item?? && item.getNom()??>${item.getNom()}</#if>">
    
    <div>perimetre</div>
    <input type="number" min=0 step="0.01" style="width: 5em" name="perimetre" value="<#if item?? && item.getPerimetre()??>${item.getPerimetre()}</#if>" required>
    
    <div>dateDepart</div>
    <input type="date"  name="dateDepart" placeholder="date" value=<#if item?? && item.getDateDepart()??>"${item.getDateDepart()}"<#else>""</#if> required>
    
    

    <select name="heureDepart" required>
            <#if item?? && item.getHeureDepart()??><option value="${item.getHeureDepart()}">${item.getHeureDepart()}</option></#if>
    <#list 0..23 as i>
            <option value="${i}">${i}</option>
     </#list>      
    </select> 
   
   <select name="minuteDepart" required>
            <#if item?? && item.getMinuteDepart()??><option value="${item.getMinuteDepart()}">${item.getMinuteDepart()}</option></#if>
    <#list 0..11 as i>
            <option value="${i*5}">${i*5}</option>
     </#list>      
    </select> 

   <select name="m" required>
            <option value="01">00</option>
            <option value="01">05</option>
    </select>
    <input type="hidden" name="heureDepart" value="">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div><input type="submit" value="Save"></div>

</form> 