<div>
	<div>${i.getId()}</div>
        <#if i.getNumero()??>
        	<div>Numero : ${i.getNumero()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getRue()??>
        	<div>Adresse : ${i.getRue()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getCp()??>
        	<div>Code postal : ${i.getCp()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getVille()??>
        	<div>Ville : ${i.getVille()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getProfil()??>
        	<div>Profil : ${i.getProfil().getFirstname()} ${i.getProfil().getLastname()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <div>
            <a href="${detailPath}/edit/${i.getId()}">Show</a>
            <a href="${detailPath}/delete/${i.getId()}">Delete</a>
        </div>
</div>