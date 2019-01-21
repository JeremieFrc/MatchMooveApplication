<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].nbrePlace" value="<#if i?? && i.getNbrePlace()??>${i.getNbrePlace()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].volumeMax" value="<#if i?? && i.getVolumeMax()??>${i.getVolumeMax()}<#else>null</#if>">

<input type="text" readonly name="items[${index}].trajet" value="<#if i?? && i.getTrajet()??>${i.getTrajet().getNom()}<#else>null</#if>">
<input type="hidden" readonly name="items[${index}].profil" value="<#if i?? && i.getprofil()??>${i.getprofil().getFirstname()}<#else>null</#if>">

