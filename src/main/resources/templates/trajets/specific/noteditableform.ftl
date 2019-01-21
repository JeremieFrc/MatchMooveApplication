
<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].nom" value="<#if i?? && i.getNom()??>${i.getNom()}<#else>null</#if>"><br>
<input type="text" readonly name="items[${index}].perimetre" value="<#if i?? && i.getPerimetre()??>${i.getPerimetre()}<#else>null</#if>"><br>
<input type="text" readonly name="items[${index}].dateDepart" value="<#if i?? && i.getDateDepart()??>${i.getDateDepart()}<#else>null</#if>"><br>
<input type="text" readonly name="items[${index}].heureDepart" value="<#if i?? && i.getHeureDepart()??>${i.getHeureDepart()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].minuteDepart" value="<#if i?? && i.getMinuteDepart()??>${i.getMinuteDepart()}<#else>null</#if>">

