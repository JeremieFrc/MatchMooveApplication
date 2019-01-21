<div>
        
        <#if i.getLongitude()??>
        <div>${i.getLongitude()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <#if i.getAltitude()??>
        <div>${i.getAltitude()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <#if i.getTrajet()??>
        <div><a href="/trajets/edit/${i.getTrajet().getId()}"> traget:${i.getTrajet().getNom()} </a></div>
        <#else>
        <div>NULL</div>
        </#if>
        <div>
            <a href="${detailPath}/edit/${i.getId()}">Show</a>
            <a href="${detailPath}/delete/${i.getId()}">Delete</a>
        </div>
    </div>