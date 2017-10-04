<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Subscribers</title>
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
            <th>name</th>
            <th>email</th>
            <th>phone</th>
            <th>device</th>
            <th>port</th>
            <th>ipaddress</th>
            <th>macaddress</th>
            <th>date_registered</th>
            <th>date_payedto</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.text}</td>
                <c:choose>
                    <c:when test="${task.status=='0'}">
                        <td>NEW</td>
                    </c:when>
                    <c:when test="${task.status=='1'}">
                        <td>IN PROGRESS</td>
                    </c:when>
                    <c:when test="${task.status=='2'}">
                        <td>DONE</td>
                    </c:when>
                </c:choose>

                <td>
                    <select name="taskadmin">
                        <c:forEach items="${tasktypes}" var="tasktypes">
                            <option value="${tasktypes.id}" ${tasktypes.id eq task.type ? 'selected' : ''}>${tasktypes.name}</option>
                        </c:forEach>
                    </select>
                </td>

                <td>${task.employee}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <form:form method="POST" action="/newtask" modelAttribute="task">
        <form:label path="text">Текст</form:label>
        <form:input path="text"/>
        <input type="submit" value="Добавить"/>
    </form:form>


</div>

</body>
</html>