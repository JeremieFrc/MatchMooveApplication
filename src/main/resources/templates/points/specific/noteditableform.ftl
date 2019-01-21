<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].longitude" value="<#if i?? && i.getLongitude()??>${i.getLongitude()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].altitude" value="<#if i?? && i.getAltitude()??>${i.getAltitude()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].trajet" value="<#if i?? && i.getTrajet()??>${i.getTrajet()}<#else>null</#if>">