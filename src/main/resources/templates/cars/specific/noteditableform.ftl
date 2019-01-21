<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].marque" value="<#if i?? && i.getMarque()??>${i.getMarque()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].modele" value="<#if i?? && i.getModele()??>${i.getModele()}<#else>null</#if>">
<input type="number" readonly name="items[${index}].nombreDePlace" value="<#if i?? && i.getNombreDePlace()??>${i.getNombreDePlace()}<#else>null</#if>"> 
<input type="text" readonly name="items[${index}].immatriculation" value="<#if i?? && i.getImmatriculation()??>${i.getImmatriculation()}<#else>null</#if>"> 