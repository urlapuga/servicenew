<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Редактирование сотрудника</title>

    <script>
        function sendGet(addrString){
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", addrString, false);
            xhttp.send();
            return xhttp.responseText;
        };

        function createEmployeeTask(employeeID) {
            var taskType = document.getElementById("taskType").value;
            var taskText = document.getElementById("taskText").value;
            var taskDate = document.getElementById("taskDate").value;
            var subscriberId = document.getElementById("subscriberId").value;


            console.log("createEmployeeTask/"+employeeID+"/"+subscriberId+"/"+taskType+"/"+taskDate+"/"+taskText);
            var res = sendGet("createEmployeeTask/"+employeeID+"/"+subscriberId+"/"+taskType+"/"+taskDate+"/"+taskText);
            alert(res);
            location.reload();

        }
    </script>
</head>
<body>


<table>
    <tr>
        <th>

        </th>
        <th>
            Имя
        </th>
        <th>
            Фамилия
        </th>
        <th>
            Телефон
        </th>
        <th>
            Email
        </th>
        <th>

        </th>
    </tr>
    <tr>


        <form:form method="POST" action="/updateemployee" modelAttribute="employee">
            <td><form:input path="id" value="${employee.id}" hidden="true"></form:input></td>

            <td><form:input path="name" value="${employee.name}"/></td>

            <td><form:input path="lastname" value="${employee.lastname}"/></td>

            <td><form:input path="phonenumber" value="${employee.phonenumber}"/></td>

            <td><form:input path="email" value="${employee.email}"/></td>

            <td><form:input path="companyId" value="${employee.companyId}" hidden="true"/></td>

            <td><input type="submit" value="Изменить"/></td>

        </form:form>
    </tr>
</table>
Задачи</br>
<table border="1">
    <thead>
    <tr>
        <th>текст</th>
        <th>статус</th>
        <th>тип</th>
        <th>Дата</th>
        <th>Абонент</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <th>${task.text}</th>
            <th>${task.status}</th>
            <th>${task.type}</th>
            <th>${task.dateto}</th>
            <th><a href="/abonenteditor/${task.subscriberId}" target="_blank">${task.subscriberId}</a> </th>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <form onsubmit="createEmployeeTask(${employee.id});return false;">
                <input type="text" id="taskText">
                <select id="taskType">
                    <c:forEach items="${taskTypes}" var="taskType">
                        <option value="${taskType.id}">${taskType.name}</option>
                    </c:forEach>
                </select>
                Договор<input type="text" id="subscriberId">
                <input type="datetime-local" id="taskDate">
                <input type="submit" value="Создать">
            </form>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
