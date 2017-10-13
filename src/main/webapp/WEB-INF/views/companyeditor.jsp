<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Редактирование компании</title>
</head>
<body>

<form:form method="POST" action="/save-company" modelAttribute="company">
    <td><form:input path="id" value="${company.id}" hidden="true"></form:input></td>

    <td><form:input path="name" value="${company.name}"/></td>

    <td><form:input path="phone" value="${company.phone}"/></td>

    <td><form:input path="code" value="${company.code}"/></td>

    <td><form:input path="email" value="${company.email}"/></td>

    <td>
        <select path="director" id="director" name="director">
            <c:forEach items="${employee}" var="e">
                <option value="${e.id}" ${(e.id==company.director)?"selected":""}>${e.name}</option>
            </c:forEach>
        </select>
    </td>

    <td><input type="submit" value="Изменить"/></td>

</form:form>

<center>
    <h2>Сотрудники</h2>
    <table border="1">
        <tr bgcolor="#a9a9a9">
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Телефон</th>
            <th>Email</th>
            <th>Должность</th>
            <th>Управление</th>
        </tr>
        <c:forEach items="${employee}" var="employees">
            <tr>
                <td>${employees.name}</td>
                <td>${employees.lastname}</td>
                <td>${employees.phonenumber}</td>
                <td>${employees.email}</td>
                <td>${employees.positionId}</td>
                <td><a href="<c:url value='/edit-employee-${employees.id}' />" class="btn btn-default">Изменить</a></td>
            </tr>
        </c:forEach>
        <tr bgcolor="#a9a9a9">
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Телефон</th>
            <th>Email</th>
            <th>Должность</th>
            <th>Управление</th>
        </tr>


        <tr bgcolor="#f0ffff">
            <form:form method="POST" action="/newemployee" modelAttribute="employees">

                <td><form:input path="name"/></td>

                <td><form:input path="lastname"/></td>

                <td><form:input path="phonenumber"/></td>

                <td><form:input path="email"/></td>

                <td>
                    <select path="positionId">
                        <c:forEach items="${positions}" var="p">
                            <option value="${p.id}">${p.name}</option>
                        </c:forEach>
                    </select>
                </td>


                <td><input type="submit" value="Создать"/></td>
            </form:form>
        </tr>
    </table>

</center>


<center>
    <h2>Задачи</h2>
    <table border="1">
        <thead>
        <tr>
            <th>text</th>
            <th>status</th>
            <th>type</th>
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
                    <select name="tasktype">
                        <c:forEach items="${tasktypes}" var="tasktypes">
                            <option value="${tasktypes.id}" ${tasktypes.id eq task.type ? 'selected' : ''}>${tasktypes.name}</option>
                        </c:forEach>
                    </select>
                </td>

                <td>${task.employee}</td>
            </tr>
        </c:forEach>

        <tr>


            <td>
                <form:form method="POST" action="/tasks" modelAttribute="task">
                    <form:input path="text"/>
            </td>
            <td> <form:select path="type">
                <c:forEach items="${tasktypes}" var="tasktypes">
                    <option value="${tasktypes.id}">${tasktypes.name}</option>
                </c:forEach>
            </form:select></td>
            <td><form:input path="dateto" id="datepicker"/></td>
            <td><input type="submit" value="Добавить"/>
                </form:form></td>

        </tr>
        </tbody>
    </table>


</center>


</body>
</html>
