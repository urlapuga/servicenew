<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Редактирование сотрудника</title>
</head>
<body>

<form:form method="POST" action="/updateemployee" modelAttribute="employee">
    <td><form:input path="id" value="${employee.id}" hidden="true"></form:input></td>

    <td><form:input path="name" value="${employee.name}"/></td>

    <td><form:input path="lastname" value="${employee.lastname}"/></td>

    <td><form:input path="phonenumber" value="${employee.phonenumber}"/></td>

    <td><form:input path="email" value="${employee.email}"/></td>

    <td><form:input path="companyId" value="${employee.companyId}"/></td>

    <td><input type="submit" value="Изменить"/></td>

</form:form>


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
            <th>${task.text}</th>
            <th>3</th>
            <th>${task.type}</th>
        </tr>
    </c:forEach>
<tr>
    <td>
        <form action="createTask(${employee.id})">
            <input type="text"  id="tasktext">
            <select id="taskType">
                <c:forEach items="${taskTypes}" var="taskType">
                    <option value="${taskType.id}">${taskType.name}</option>
                </c:forEach>
            </select>
            Договор<input type="text" id="subscriberId">

            <input type="submit" value="Создать">

        </form>

    </td>
</tr>
    </tbody>
</table>
</body>
</html>
