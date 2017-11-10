<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>Pinger</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>


<!--         CITIES               -->



<body>
<table border="1">
    <c:forEach items="${cities}" var="city">
        <tr>
            <td>${city.name}</td>
            <td><a href="<c:url value='/delete-city-${city.id}' />" class="btn btn-danger custom-width">Удалить</a></td>
        </tr>
    </c:forEach>
</table>

<form:form method="POST" action="/newcity" modelAttribute="city">
    <form:input path="name" pattern="[A-Za-zА-Яа-яЁё]{3,}" title="Минимум 3 символа"/>
    <input type="submit" value="Добавить"/>
</form:form>



<!--         STREETS               -->



<table border="1">
    <c:forEach items="${streets}" var="street">
        <tr>
            <td>${street.name}</td>
            <td><a href="<c:url value='/delete-street-${street.id}' />" class="btn btn-danger custom-width">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<form:form method="POST" action="/newcity" modelAttribute="street">
    <select path="city" name="taskadmin">
        <c:forEach items="${cities}" var="city">
            <option value="${city.id}">${city.name}</option>
        </c:forEach>
    </select>
    <form:input id="streetname" path="name" pattern="[A-Za-zА-Яа-яЁё]{3,}" title="Минимум 3 символа"/>
    <input type="submit" value="Добавить"/>
</form:form>



<!--         BUILDINGS               -->



<table border="1">
    <c:forEach items="${buildings}" var="building">
        <tr>
            <td>${building.number}</td>
            <td><a href="<c:url value='/delete-building-${building.id}' />"
                   class="btn btn-danger custom-width">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<form:form method="POST" action="/newbuilding" modelAttribute="building">

    <select path="city" name="city">
        <c:forEach items="${cities}" var="city">
            <option value="${city.id}">${city.name}</option>
        </c:forEach>
    </select>

    <select path="street" name="street">
        <c:forEach items="${streets}" var="street">
            <option value="${street.id}">${street.name}</option>
        </c:forEach>
    </select>

    <form:input path="number" />
    <input type="submit" value="Добавить"/>
</form:form>


</body>
</html>