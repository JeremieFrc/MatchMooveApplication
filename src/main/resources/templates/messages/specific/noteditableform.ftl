<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].content" value="<#if i?? && i.getContent()??>${i.getContent()}<#else>null</#if>">
<input type="date" readonly name="items[${index}].date" value="<#if i?? && i.getDate()??>${i.getDate()?string["yyyy-MM-dd"]}<#else>null</#if>"> 