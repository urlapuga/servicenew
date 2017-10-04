<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>task types</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">List of Tasks</span></div>
    <table class="table table-hover">
        <thead>
        <tr>

            <th width="100">name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${result}" var="result">
            <tr>
                <td>${result.name}</td>
                <td><a href="<c:url value='/delete-tasktype-${result.id}' />" class="btn btn-success custom-width">delete</a>
                </td>

            </tr>
            <
        </c:forEach>
        </tbody>
    </table>
</div>

<form:form method="POST" action="/newtasktype" modelAttribute="tasktype">
    <form:label path="name">Тип</form:label>
    <form:input path="name"/>
    <input type="submit" value="Добавить"/>
</form:form>

</body>
</html>