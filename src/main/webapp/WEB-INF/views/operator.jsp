<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Открыть карточку абонента</br>

Договор : <input type="text" id="abonentid" name="abonentid">
<input type="button" value="Открыть" onclick="showAbonent()">




<form:form method="POST" action="/newsubscriber/" modelAttribute="subscriber">
    <form:label path="name">Имя</form:label>
    <form:input path="name"></form:input>

    <form:label path="phone">Телефон</form:label>
    <form:input path="phone"></form:input>

    <input type="submit" value="Создать абонента"/>
</form:form>








Проверить возможность подключения
<form>
    <input type="text">
    <input type="submit">
</form>

Внести заявку на подключение
<form>
    <input type="text">
    <input type="submit">
</form>


</body>
</html>
