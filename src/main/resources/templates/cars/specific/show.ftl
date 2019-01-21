<div>
	<div>${i.getId()}</div>
        <#if i.getMarque()??>
        	<div>Marque : ${i.getMarque()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getModele()??>
        	<div>Modele : ${i.getModele()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getNombreDePlace()??>
        	<div>Nombre de places : ${i.getNombreDePlace()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getImmatriculation()??>
        	<div>Plaque d'immatriculation : ${i.getImmatriculation()}</div>
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