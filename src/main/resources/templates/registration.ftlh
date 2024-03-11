<!DOCTYPE html>
<html>
<head>
    <title>Three Flies</title>
</head>
<body>
<h1>Three Flies</h1><hr>
<h4>Registration</h4>
<form action="/registration" method="post">
    Username: <input type="text" name="name"><br><br>
    E-mail: <input type="email" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Sign in"/>
</form>
<#if errorMessage??>
    <h2 style="color: darkred">${errorMessage}</h2>
</#if>
</body>
</html>