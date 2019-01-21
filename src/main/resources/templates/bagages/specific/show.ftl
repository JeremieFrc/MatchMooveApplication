<div>
         <div>volume</div>
        <#if i.getVolume()??>
        <div>${i.getVolume()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <div>trajet</div>
        <#if i.getTrajet()??>
        <div>${i.getTrajet().getNom()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <div>profile</div>
        <#if i.getProfil()??>
        <div>${i.getProfil().getFirstname()+ " " + i.getProfil().getLastname()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        
        <div>
            <a href="${detailPath}/edit/${i.getId()}">Show</a>
            <a href="${detailPath}/delete/${i.getId()}">Delete</a>
        </div>
    </div>
  