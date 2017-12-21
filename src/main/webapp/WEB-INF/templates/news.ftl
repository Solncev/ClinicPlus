<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Новости</title>
<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>
    <#if newsList?has_content>
        <#list newsList as n>
            <h4><a href="/news/${n.id}">${n.date}:      ${n.topic}</a><br></h4>
        </#list>
    <#else>
    </#if>
</div>
</#macro>
</html>