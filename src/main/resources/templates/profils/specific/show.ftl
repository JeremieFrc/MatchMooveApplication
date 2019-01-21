<div>${i.getId()}</div>
        <#if i.getFirstname()??>
        	<div>Nom : ${i.getFirstname()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getLastname()??>
        	<div>Prenom : ${i.getLastname()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getPhoneNumber()??>
        	<div>Telephone : ${i.getPhoneNumber()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <div>--------------------------------------------</div>
        <#if i.getAdresses()??>
        	<div>--------------------------------------------</div>
        	<#list i.getAdresses() as a>
        		<div>ADRESSE</div>
        		<div>Numero : ${a.getNumero()}</div>
        		<div>Rue : ${a.getRue()}</div>
        		<div>Code Postal : ${a.getCp()}</div>
        		<div>Ville : ${a.getVille()}</div>
				<#if a.getDomicile() == true><div>DOMICILE</div></#if>
				<div>--------------------------------------------</div>
        	</#list>
        </#if>
        <#if i.getCars()??>
        	<div>--------------------------------------------</div>
        	<#list i.getCars() as c>
        		<div>VOITURE</div>
        		<div>Marque : ${c.getMarque()}</div>
        		<div>Modele : ${c.getModele()}</div>
        		<div>Nombre de places : ${c.getNombreDePlace()}</div>
        		<div>Numero d'immatriculation : ${c.getImmatriculation()}</div>
        		<div>--------------------------------------------</div>
        	</#list>	
        </#if>
        <div>
            <a href="${detailPath}/edit/${i.getId()}">Show</a>
            <a href="${detailPath}/delete/${i.getId()}">Delete</a>
        </div>
</div>
