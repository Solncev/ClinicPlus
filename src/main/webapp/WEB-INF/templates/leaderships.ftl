<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Руководители</title>
<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>
    <#if doctors?has_content>
        <#list doctors as d>
            <#if d.staff??>
                <h4>${d.staff.position}: </h4>
            </#if>
            <h3><a href="/specialist/${d.id}">${d.surname}   ${d.name}</a></h3>
        </#list>
    <#else>

    </#if>
</div>
</#macro>
</html>

