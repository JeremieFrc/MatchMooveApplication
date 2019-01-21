<form  class="text-center border border-light" action="${detailPath}/edit" method="POST">
<#if item??>
    <div>Id</div>
    <#if item.getId()??>
    <div>${item.getId()}</div>
    <input type="hidden" name="id" value="${item.getId()}">
    <#else>
    <div>NA</div>
    </#if>
</#if>
    <div>Choisir le profile</div>
    <#if profils??>
    <select name="profil" required>
        <#list profils as p>
        <#if p.getId()??>
            <option value= ${p.getId()}>${p.getFirstname()+" "+ p.getLastname() }</option>
        </#if>
        </#list>
    </select>
    </#if>
   
    
    <div>Choisir le trajet</div>
    <#if trajets??>
    <select name="trajet" required>
    
        <#list trajets as p>
          <#if p.getId()??>
            <option value=${p.getId()}>${p.getNom() }</option>
          </#if>
        </#list>

    </select>
    </#if>
   
    
    <div>nbrePlace</div>
    <input type="number" min=0  style="width: 5em" name="nbrePlace" value="<#if item?? && item.getNbrePlace()??>${item.getNbrePlace()}</#if>" required>
    
    
    <div>volumeMax</div>

    <input type="number" min=0 step="0.01" style="width: 5em" name="volumeMax" value="<#if item?? && item.getVolumeMax()??>${item.getVolumeMax()}</#if>" required>

    <div><input type="submit" value="Save"></div>
     <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
</form> 