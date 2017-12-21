<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<#include "base.ftl">
<#if news?has_content>
<title>${news.topic}</title>
<#else>
<title>Новость</title>
</#if>
<#macro content>
<div class="content">
    <a href='/home'>Назад</a>
    <br>

    <#if news?has_content>
        <#if news.text??>
            <h4>${news.date}:</h4>
            <#if news.photo?? && news.photo!="">
                <img class="img-responsive" src="${news.photo}" alt="">
            </#if>
            <h3>${news.text}</h3>
        <#else>
            null
        </#if>
    <#else>

    </#if>
</div>
</#macro>
</html>