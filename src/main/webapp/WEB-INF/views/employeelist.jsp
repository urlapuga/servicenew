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
        <td>name</td>
        <td>lastname</td>
        <td>phone</td>
        <td>email</td>
        <td>company</td>
        <td>position</td>
    </tr>
    <c:forEach items="${result}" var="employees">
        <tr>
            <td>${employees.name}</td>
            <td>${employees.lastname}</td>
            <td>${employees.phonenumber}</td>
            <td>${employees.email}</td>
            <td>${employees.companyId}</td>
            <td>${employees.positionId}</td>
        </tr>
    </c:forEach>

</table>


</body>
</html>