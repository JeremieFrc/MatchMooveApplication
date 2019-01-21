<div>
     <#if i??>
        <#if i.getContent()??>
        	<div> Content : ${i.getContent()}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        <#if i.getDate()??>
        	<div>Date : ${i.getDate()?string["yyyy-MM-dd"]}</div>
        <#else>
        	<div>NULL</div>
        </#if>
        
        <div>
            <a href="${detailPath}/edit/${i.getId()}">Show</a>
            <a href="${detailPath}/delete/${i.getId()}">Delete</a>
        </div>
        </#if>
</div>