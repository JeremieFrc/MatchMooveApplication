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
    <div>volume</div>
    <input type="number" min=0 step="0.01" style="width: 5em" name="volume" value="<#if item?? && item.getVolume()??>${item.getVolume()}</#if>" required>
    
    <div>Choisir le trajet</div>
    <#if trajets??>
    <select name="trajet" required>
        <#list trajets as p>
            <option value=${p.getId()}>${p.getNom() }</option>
        </#list>
    </select>
    </#if>
    
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