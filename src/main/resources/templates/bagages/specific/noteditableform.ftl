<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">

<input type="number" readonly name="items[${index}].volume" value="<#if i?? && i.getVolume()??>${i.getVolume()}<#else>null</#if>"><br>
<input type="text" readonly name="items[${index}].trajet" value="<#if i?? && i.getTrajet()??>${i.getTrajet().getNom()}<#else>null</#if>"><br>
<input type="text" readonly name="items[${index}].profile" value="<#if i?? && i.getProfil()??>${i.getProfil().getFirstname()}+" "+${i.getProfil().getLastname()}<#else>null</#if>">

