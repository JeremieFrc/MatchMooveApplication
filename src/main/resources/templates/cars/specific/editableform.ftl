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
    <div>Marque</div>
    <input type="text" name="marque" value="<#if item?? && item.getMarque()??>${item.getMarque()}</#if>" required>
    <div>Modele</div>
    <input type="text" name="modele" value="<#if item?? && item.getModele()??>${item.getModele()}</#if>" required>
    <div>Nombre de places</div>
    <input type="number" name="nombreDePlace" value="<#if item?? && item.getNombreDePlace()??>${item.getNombreDePlace()}</#if>" required>
    <div>Numero d'immatriculation</div>
    <input type="text" name="immatriculation" value="<#if item?? && item.getImmatriculation()??>${item.getImmatriculation()}</#if>" required>
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
