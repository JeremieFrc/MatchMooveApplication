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
    <div>Numero</div>
    <input type="number" name="numero" value="<#if item?? && item.getNumero()??>${item.getNumero()}</#if>" required>
    <div>Adresse</div>
    <input type="text" name="rue" value="<#if item?? && item.getRue()??>${item.getRue()}</#if>" required>
    <div>Code postal</div>
    <input type="number" name="cp" value="<#if item?? && item.getCp()??>${item.getCp()}</#if>" required>
    <div>Ville</div>
    <input type="text" name="ville" value="<#if item?? && item.getVille()??>${item.getVille()}</#if>" required>
    <div>Type d'adresse : 
    <input type="radio" id="domicile" name="domicile" value="true" checked/>
  	<label for="domicile">Domicile</label>
  	<input type="radio" id="travail" name="domicile" value="false"/>
  	<label for="travail">Travail</label>
  	</div>
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