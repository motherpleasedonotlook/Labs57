<!DOCTYPE html>
<html>
<head>
    <title>Three flies</title>
</head>
<body>
<h1>THREE FLIES</h1>
<h4>Social network for ones who love picturing flies</h4>
<form action="/" method="get">
    Search for title: <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>
<#list banners as banner>
    <div>
        <p><b>${banner.title}</b> ${banner.author} | <a href="/banner/${banner.id}">Read more...</a> </p>
    </div>
    <#else>
    <h3>No posts... :(</h3>
</#list>
<hr>
<h3>Add your news</h3>
<form action = "/banner/create" method = "post" enctype="multipart/form-data">
    Subject: <input type ="text" name = "title"/><br><br>
    Description: <input type ="text" name = "description"/><br><br>
    Name: <input type ="text" name = "author"/><br><br>
    First picture: <input type ="file" name = "file1"/><br><br>
    Second picture: <input type ="file" name = "file2"/><br><br>
    Third picture: <input type ="file" name = "file3"/><br><br>
    <input type = "submit" value ="Add news"/>
</form>
</body>
</html>