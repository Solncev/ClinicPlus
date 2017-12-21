<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Личный кабинет</title>

<#include "base.ftl">
<#macro content>

<ul>
    <#if currentUser?has_content>
        <#if currentUser.login??> <h4>Ваш логин: ${currentUser.login}</h4> <#else ><h4>Ваш логин: null</h4> </#if>
        <#if currentUser.surname??> <h4>Фамилия: ${currentUser.surname}</h4> <#else > </#if>
        <#if currentUser.name??> <h4>Имя: ${currentUser.name}</h4> <#else ><h4>Имя: null</h4> </#if>
        <#if currentUser.patronymic??> <h4>Отчество: ${currentUser.patronymic}</h4></#if>
        <#if currentUser.birthDay??>  <h4>День рождения: ${currentUser.birthDay}</h4>  </#if>
        <#if currentUser.gender??>  <h4>Пол: ${currentUser.gender}</h4>  </#if>
        <#if currentUser.mobile_number??> <h4>Мобильный телефон: ${currentUser.mobile_number}</h4>  </#if>
        <#if currentUser.OMS_number??><h4>Номер ОМС: ${currentUser.OMS_number}</h4>  </#if>
    <#--<h3><a href='/appointment'>Записаться на прием</a></h3>-->
    <#--<#if appointments?has_content>-->
    <#--<#list appointments as a>-->
    <#--<h4>у вас имеется запись на: </h4>-->
    <#--<h4>${a.date}    ${a.time}<br></h4>-->
    <#--</#list>-->
    <#--<#else >-->
    <#--</#if>-->
    <#else>

    </#if>
</ul>
</#macro>
</html>


