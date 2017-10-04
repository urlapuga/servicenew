<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Pinger</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<table border="1">
    <tr>
        <td>ip</td>
        <td>coment</td>
        <td></td>
    </tr>
    <c:forEach items="${result}" var="pinger">

        <c:choose>
            <c:when test="${pinger.status=='1'}">
                <tr bgcolor="green">
            </c:when>
            <c:otherwise>
                <tr bgcolor="red">
            </c:otherwise>
        </c:choose>
        <td>${pinger.ip}</td>
        <td>${pinger.coment}</td>
        <td><a href="<c:url value='/delete-pinger-${pinger.id}' />" class="btn btn-danger custom-width">delete</a></td>
        </tr>
    </c:forEach>
</table>

<form:form method="POST" action="/newpinger" modelAttribute="pinger">
    <form:input type="hidden" path="id" id="id"/>
    <table>

        <tr>
            <td><form:label path="ip" >Ip</form:label></td>
            <td><form:input path="ip" pattern="\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}" title="Пример  192.168.1.1"/></td>
        </tr>
        <tr>
            <td><form:label path="coment">Coment</form:label></td>
            <td><form:input path="coment" pattern="[A-Za-zА-Яа-яЁё]{3,}" title="Минимум 3 буквы"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>