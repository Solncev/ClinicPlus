<#ftl encoding='UTF-8'>
<!doctype html>
<html lang="en">
<title>Админ</title>
<#include "base.ftl">

<#macro content>
<form action="/admin" method="get">
    <p><select name="model">
        <option disabled>Выберите сущность</option>
        <option value="users" selected>пользователи</option>
        <option value="comments">комментарии</option>
        <option value="deals">предложения</option>
        <option value="doctors">доктора</option>
        <option value="news">новости</option>
        <option value="roles">роли</option>
        <option value="staffs">должности</option>
        <option value="services">услуги</option>
        <option value="clients_roles">пользователи роли</option>
    </select></p>
    <p><input type="submit" value="показать"></p>
</form>

    <#if users?has_content>
    <table border="1">
        <caption>пользователи</caption>
        <tr>
            <th>id</th>
            <th>login</th>
            <th>password</th>
            <th>surname</th>
            <th>name</th>
            <th>patronymic</th>
            <th>birthday</th>
            <th>sex</th>
            <th>mobile</th>
            <th>oms</th>
        </tr>
    <tr>
        <#list users as u>
            <tr>
                <form method="post" action="admin/removeclient">
                    <td><#if u.id??><input type="text" value="${u.id}" name="id"><#else ><input type="text" value="null"
                                                                                                name="id"></#if></td>

                    <td><#if u.login??><input type="text" value="${u.login}" name="login"><#else ><input type="text"
                                                                                                         value="null"
                                                                                                         name="login"></#if>
                    </td>
                    <td><#if u.password??><input type="text" value="${u.password}" name="password"><#else ><input
                            type="text" value="null"
                            name="password"></#if></td>

                    <td><#if u.surname??><input type="text" value="${u.surname}" name="surname"><#else ><input
                            type="text" value="null"
                            name="surname"></#if></td>

                    <td><#if u.name??><input type="text" value="${u.name}" name="name"><#else ><input type="text"
                                                                                                      value="null"
                                                                                                      name="name"></#if>
                    </td>

                    <td><#if u.patronymic??><input type="text" value="${u.patronymic}" name="patronymic"><#else ><input
                            type="text" value="null"
                            name="patronymic"></#if></td>

                    <td><#if u.birthDay??><input type="text" value="${u.birthDay}" name="bday"><#else ><input
                            type="text" value="null"
                            name="bday"></#if></td>

                    <td><#if u.gender??><input type="text" value="${u.gender}" name="sex"><#else ><input type="text"
                                                                                                         value="null"
                                                                                                         name="sex"></#if>
                    </td>

                    <td><#if u.mobile_number??><input type="text" value="${u.mobile_number}" name="mobile"><#else >
                        <input type="text" value="null"
                               name="mobile"></#if></td>

                    <td><#if u.OMS_number??><input type="text" value="${u.OMS_number}" name="oms"><#else ><input
                            type="text" value="null"
                            name="oms"></#if></td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>

    <#if comments?has_content>
    <table border="1">
        <caption>комментарии</caption>
        <tr>
            <th>id</th>
            <th>client_id</th>
            <th>text</th>
            <th>date</th>
            <th>time</th>
            <th>owner</th>
        </tr>
    <tr>
        <#list comments as c>
            <tr>
                <form method="post" action="/admin/removecomment">
                    <td><#if c.id??><input type="text" value="${c.id}" name="id"><#else ><input type="text" value="null"
                                                                                                name="id"></#if></td>

                    <td><#if c.client_id??><input type="text" value="${c.client_id}" name="client_id"><#else ><input
                            type="text"
                            value="null"
                            name="client_id"></#if>
                    </td>
                    <td><#if c.text??><input type="text" value="${c.text}" name="text"><#else ><input
                            type="text" value="null"
                            name="text"></#if></td>

                    <td><#if c.date??><input type="text" value="${c.date}" name="date"><#else ><input
                            type="text" value="null"
                            name="date"></#if></td>

                    <td><#if c.time??><input type="text" value="${c.time}" name="time"><#else ><input type="text"
                                                                                                      value="null"
                                                                                                      name="time"></#if>
                    </td>

                    <td><#if c.name??><input type="text" value="${c.name}" name="name"><#else ><input type="text"
                                                                                                      value="null"
                                                                                                      name="name"></#if>
                    </td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>

    <#if contacts?has_content>
    <table border="1">
        <caption>контакты</caption>
        <tr>
            <th>id</th>
            <th>телефон</th>
            <th>почта</th>
            <th>адрес</th>
        </tr>
    <tr>
        <#list contacts as c>
            <tr>
                <form method="post" action="/admin/removecontact">
                    <td><#if c.id??><input type="text" value="${c.id}" name="id"><#else ><input type="text" value="null"
                                                                                                name="id"></#if></td>

                    <td><#if c.phone_number??><input type="text" value="${c.phone_number}" name="phone"><#else ><input
                            type="text"
                            value="null"
                            name="phone"></#if>
                    </td>
                    <td><#if c.email??><input type="text" value="${c.email}" name="email"><#else ><input
                            type="text" value="null"
                            name="email"></#if></td>

                    <td><#if c.address??><input type="text" value="${c.address}" name="address"><#else ><input
                            type="text" value="null"
                            name="address"></#if></td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>

    <#if deals?has_content>
    <table border="1">
        <caption>предложения</caption>
        <tr>
            <th>id</th>
            <th>название</th>
            <th>описание</th>
        </tr>
    <tr>
        <#list deals as d>
            <tr>
                <form method="post" action="/admin/removedeal">
                    <td><#if d.id??><input type="text" value="${d.id}" name="id"><#else ><input type="text" value="null"
                                                                                                name="id"></#if></td>

                    <td><#if d.name??><input type="text" value="${d.name}" name="name"><#else ><input
                            type="text"
                            value="null"
                            name="name"></#if>
                    </td>
                    <td><#if d.description??><input type="text" value="${d.description}" name="description"><#else >
                        <input
                                type="text" value="null"
                                name="description"></#if>
                    </td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>

    <#if doctors?has_content>
    <table border="1">
        <caption>специалисты</caption>
        <tr>
            <th>id</th>
            <th>surname</th>
            <th>name</th>
            <th>patronymic</th>
            <th>staff</th>
            <th>speciality</th>
            <th>photo</th>
            <th>education</th>
            <th>achievements</th>
            <th>experience</th>
            <th>certificate</th>
        </tr>
    <tr>
        <#list doctors as d>
            <tr>
                <form method="post" action="admin/removedoctor">
                    <td><#if d.id??><input type="text" value="${d.id}" name="id"><#else ><input type="text" value="null"
                                                                                                name="id"></#if></td>

                    <td><#if d.surname??><input type="text" value="${d.surname}" name="surname"><#else ><input
                            type="text" value="null"
                            name="surname"></#if></td>

                    <td><#if d.name??><input type="text" value="${d.name}" name="name"><#else ><input type="text"
                                                                                                      value="null"
                                                                                                      name="name"></#if>
                    </td>

                    <td><#if d.patronymic??><input type="text" value="${d.patronymic}" name="patronymic"><#else ><input
                            type="text" value="null"
                            name="patronymic"></#if></td>

                    <td><#if d.staff??><input type="text" value="${d.staff.position}" name=" staff"><#else ><input
                            type="text" value="null"
                            name="staff"></#if></td>

                    <td><#if d.speciality??><input type="text" value="${d.speciality}" name="speciality"><#else ><input
                            type="text"
                            value="null"
                            name="speciality"></#if>
                    </td>

                    <td><#if d.photo??><input type="text" value="${d.photo}" name="photo"><#else ><input
                            type="text" value="null"
                            name="photo"></#if></td>

                    <td><#if d.education??><input type="text" value="${d.education}" name="education"><#else ><input
                            type="text" value="null"
                            name="education"></#if></td>

                    <td><#if d.achievements??><input type="text" value="${d.achievements}" name="achievements"><#else >
                        <input type="text"
                               value="null"
                               name="achievements"></#if>
                    </td>

                    <td><#if d.experience??><input type="text" value="${d.experience}" name="experience"><#else >
                        <input type="text" value="null"
                               name="experience"></#if></td>

                    <td><#if d.certificate??><input type="text" value="${d.certificate}" name="certificate"><#else >
                        <input
                                type="text" value="null"
                                name="certificate"></#if></td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>

    <#if news?has_content>
    <table border="1">
        <caption>Новости</caption>
        <tr>
            <th>id</th>
            <th>photo</th>
            <th>topic</th>
            <th>text</th>
            <th>date</th>
            <th>time</th>
        </tr>
    <tr>
        <#list news as n>
            <tr>
                <form method="post" action="/admin/removenews">
                    <td><#if n.id??><input type="text" value="${n.id}" name="id"><#else ><input type="text" value="null"
                                                                                                name="id"></#if></td>

                    <td><#if n.photo??><input type="text" value="${n.photo}" name="photo"><#else ><input
                            type="text"
                            value="null"
                            name="photo"></#if>
                    </td>
                    <td><#if n.topic??><input type="text" value="${n.topic}" name="topic"><#else ><input
                            type="text" value="null"
                            name="topic"></#if></td>

                    <td><#if n.text??><input type="text" value="${n.text}" name="text"><#else ><input
                            type="text" value="null"
                            name="text"></#if></td>

                    <td><#if n.date??><input type="text" value="${n.date}" name="date"><#else ><input type="text"
                                                                                                      value="null"
                                                                                                      name="date"></#if>
                    </td>

                    <td><#if n.time??><input type="text" value="${n.time}" name="time"><#else ><input type="text"
                                                                                                      value="null"
                                                                                                      name="time"></#if>
                    </td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>

    <#if services?has_content>
    <table border="1">
        <caption>Услуги</caption>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>text</th>
            <th>photo</th>
            <th>price</th>
        </tr>
    <tr>
        <#list services as s>
            <tr>
                <form method="post" action="/admin/removeservice">
                    <td><#if s.id??><input type="text" value="${s.id}" name="id"><#else><input type="text" value="null"
                                                                                               name="id"></#if></td>

                    <td><#if s.name??><input type="text" value="${s.name}" name="name"><#else ><input
                            type="text"
                            value="null"
                            name="name"></#if>
                    </td>
                    <td><#if s.text??><input type="text" value="${s.text}" name="text"><#else ><input
                            type="text" value="null"
                            name="text"></#if></td>

                    <td><#if s.photo??><input type="text" value="${s.photo}" name="photo"><#else ><input
                            type="text" value="null"
                            name="photo"></#if></td>

                    <td><#if s.price??><input type="text" value="${s.price}" name="price"><#else ><input type="text"
                                                                                                         value="null"
                                                                                                         name="price"></#if>
                    </td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>


    <#if roles?has_content>
    <table border="1">
        <caption>роли</caption>
        <tr>
            <th>id</th>
            <th>роль</th>
        </tr>
    <tr>
        <#list roles as r>
            <tr>
                <form method="post" action="/admin/remove">
                    <td><#if r.id??><input type="text" value="${r.id}" name="id"><#else ><input type="text" value="null"
                                                                                                name="id"></#if></td>

                    <td><#if r.name??><input type="text" value="${r.name}" name="role"><#else ><input
                            type="text"
                            value="null"
                            name="role"></#if>
                    </td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>


    <#if clients_roles?has_content>
    <table border="1">
        <caption>роли-пользователи</caption>
        <tr>
            <th>id</th>
            <th>client id</th>
            <th>role id</th>
        </tr>
    <tr>
        <#list clients_roles as c_r>
            <tr>
                <form method="post" action="/admin/removec_r">
                    <td><#if c_r.id??><input type="text" value="${c_r.id}" name="id"><#else ><input type="text"
                                                                                                    value="null"
                                                                                                    name="id"></#if>
                    </td>

                    <td><#if c_r.user??><input type="text" value="${c_r.user.id}" name="client_id"><#else ><input
                            type="text"
                            value="null"
                            name="client_id"></#if>
                    </td>

                    <td><#if c_r.role??><input type="text" value="${c_r.role.id}" name="role_id"><#else ><input
                            type="text"
                            value="null"
                            name="role_id"></#if>
                    </td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>


    <#if staffs?has_content>
    <table border="1">
        <caption>должности</caption>
        <tr>
            <th>id</th>
            <th>Должность</th>
        </tr>
    <tr>
        <#list staffs as s>
            <tr>
                <form method="post" action="/admin/removestaff">
                    <td><#if s.id??><input type="text" value="${s.id}" name="id"><#else ><input type="text" value="null"
                                                                                                name="id"></#if></td>

                    <td><#if s.position??><input type="text" value="${s.position}" name="position"><#else ><input
                            type="text"
                            value="null"
                            name="position"></#if>
                    </td>
                </form>
            </tr>
        </#list>
    </table>
    </#if>
</#macro>
</html>