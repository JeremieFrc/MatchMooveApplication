

<div>nom</div>
<input type="text" name="nom" value="">
<div>perimetre</div>
<input type="number" min=0 step="0.01" style="width: 5em" name="perimetre" value="">
<div>dateDepart</div>

<input type="text" name="dateDepart" value="">
<div>heureDepart</div>
<select name="heureDepart" >
            <#if item?? && item.getHeureDepart()><option value="${item.getHeureDepart()}">${item.getHeureDepart()}</option></#if>
    <#list 0..23 as i>
            <option value="${i}">${i}</option>
     </#list>      
    </select> 
   
   <select name="minuteDepart" >
            <#if item?? && item.getMinuteDepart()><option value="${item.getMinuteDepart()}">${item.getMinuteDepart()}</option></#if>
    <#list 0..11 as i>
            <option value="${i*5}">${i*5}</option>
     </#list>      
    </select> 
    <div><input type="submit" value="Save"></div>

