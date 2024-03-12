<!DOCTYPE html>
<html>
<head>
    <title>Three flies</title>
</head>
<body>
<h1> Three Flies</h1>
<hr>
<h4>Administrator panel</h4>
<table border="1">
    <tr>
        <th>E-mail</th>
        <th>Activity</th>
        <ht>Roles</ht>
        <th>Ban</th>
        <th>Edit</th>
        <th>Information</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Ban">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Editing</a></th>
            <th><a href="/user/${user.id}">More information</a></th>
        </tr>
    <#else>
        <h3>No users...</h3>
    </#list>
</table>
</body>
</html>