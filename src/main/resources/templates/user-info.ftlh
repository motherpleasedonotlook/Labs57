<!DOCTYPE html>
<html>
<head>
    <title>Three flies</title>
</head>
<body>
<h1>Three flies</h1><hr>

<h4>Posts of ${user.name}</h4>
<#list banners as banner>
    <div>
        <p><b>${banner.title}</b> ${banner.user.name} | <a href="/banner/${banner.id}">Read more...</a> </p>
    </div>
    <#else>
    <h3>No posts... :(</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: darkred">${errorMessage}</h2>
</#if>
</body>
</html>