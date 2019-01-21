<div>
        <div>${i.getId()}</div>
        <#if i.getNbrePlace()??>
        <div>nomber places : ${i.getNbrePlace()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <#if i.getVolumeMax()??>
        <div>VolumeMax : ${i.getVolumeMax()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <#if i.getTrajet()??>
        <div>trajet : ${i.getTrajet().getNom()}</div>
        <#else>
        <div>NULL</div>
        </#if>
        <#if i.getprofil()??>
        <div>${i.getprofil().getFirstname() + " " + i.getprofil().getLastname() }</div>
        <#else>
        <div>NULL</div>
        </#if>
        <div>
            <a href="${detailPath}/edit/${i.getId()}">Show</a>
            <a href="${detailPath}/delete/${i.getId()}">Delete</a>
        </div>
    </div>