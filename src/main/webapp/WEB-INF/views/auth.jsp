<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<center>


<form action="/authorize" method="post">
    <input type="text" id="login" name="login">
    <input type="text" id="pass" name="pass">
    <input type="submit" value="Логин">
</form>

    <div>${message}</div>
</center>
</body>
</html>
