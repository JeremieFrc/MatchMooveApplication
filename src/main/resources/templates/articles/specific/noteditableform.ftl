<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].title" value="<#if i?? && i.getTitle()??>${i.getTitle()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].description" value="<#if i?? && i.getDescription()??>${i.getDescription()}<#else>null</#if>">
<input type="date" readonly name="items[${index}].date" value="<#if i?? && i.getDate()??>${i.getDate()?string["yyyy-MM-dd"]}<#else>null</#if>"> 
