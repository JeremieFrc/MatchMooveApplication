<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="number" readonly name="items[${index}].numero" value="<#if i?? && i.getNumero()??>${i.getNumero()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].rue" value="<#if i?? && i.getRue()??>${i.getRue()}<#else>null</#if>">
<input type="number" readonly name="items[${index}].cp" value="<#if i?? && i.getCp()??>${i.getCp()}<#else>null</#if>"> 
<input type="text" readonly name="items[${index}].ville" value="<#if i?? && i.getVille()??>${i.getVille()}<#else>null</#if>"> 