<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Контакты</title>
<#include "base.ftl">

<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>
    <img class="img-responsive" src="http://2y.by/static/images/city/riga.jpg" alt="">
    <#if contacts?has_content>
        <#list contacts as c>
            <h4>Наш номер: ${c.phone_number}</a></h4>
            <h4>Наша почта: ${c.email}</a></h4>
            <h4>Наш адрес: ${c.address}</a></h4>
        </#list>
    <#else>

    </#if>
</div>
</#macro>
</html>