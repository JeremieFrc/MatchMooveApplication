<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].firstname" value="<#if i?? && i.getFirstname()??>${i.getFirstname()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].lastname" value="<#if i?? && i.getLastname()??>${i.getLastname()}<#else>null</#if>">
<input type="date" readonly name="items[${index}].phoneNumber" value="<#if i?? && i.getPhoneNumber()??>${i.getPhoneNumber()}<#else>null</#if>"> 