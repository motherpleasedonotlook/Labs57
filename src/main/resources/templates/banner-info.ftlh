<!DOCTYPE html>
<html>
<head>
    <title>Three flies</title>
</head>
<body>
<h1>THREE FLIES</h1>
<h4>Details</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>

<b>Title</b>${banner.title}<br>
<b>Description</b>${banner.description}<br>
<b>Author</b>${banner.author}<br>
<hr>
<form action="/banner/delete/${banner.id}" method="post">
    <input type = "submit" value="Delete this post"/>
</form>
</body>
</html>