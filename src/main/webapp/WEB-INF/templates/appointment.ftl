<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">

<#include "base.ftl">
<title>Запись на прием</title>

<#macro content>
<form method="post" action="/appointment/add">
    <div class="row block">
        <#if doctors?has_content>
            <h4>Выберите врача:</h4>
            <select class="active" name="doctor">
                <#list doctors as d>
                    <option value=${d.id}>${d.name} ${d.surname}</option>
                </#list>
            </select>
        </#if>
    </div>
    <div class="row block">
        <div class="form-group col-md-3">
            <label>Дата записи: </label>
            <input type="date" class="form-control" name="date" placeholder="Дата">
        </div>
        <div class="form-group col-md-3">
            <label>Время приема: </label>
            <input type="time" class="form-control" name="time" placeholder="Время приёма">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Записаться</button>
</form>

</#macro>
</html>