<input type="hidden" readonly name="items[${index}].id" value="<#if i?? && i.getId()??>${i.getId()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].email" value="<#if i?? && i.getEmail()??>${i.getEmail()}<#else>null</#if>">
<input type="text" readonly name="items[${index}].password" value="<#if i?? && i.getPassword()??>${i.getPassword()}<#else>null</#if>">