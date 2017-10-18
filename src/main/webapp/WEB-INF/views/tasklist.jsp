<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>

<head>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/i18n/jquery-ui-timepicker-ru.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.css" />

    <script>
        $(function() {
            $("#datepicker").datetimepicker();
        });
    </script>
</head>

<body>

<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">Задачи по абоненту</span></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Текст</th>
            <th>Статус</th>
            <th>Тип</th>
            <th>Исполнитель</th>
            <th>Дата</th>
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

                <td>${task.employeesByEmployee.lastname}  ${task.employeesByEmployee.name}</td>
                <td>${task.dateto}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</br>
</br>

    <form:form method="POST" action="/tasks" modelAttribute="task">
        <form:label path="type">Тип</form:label>

        <form:select path="type">
            <c:forEach items="${tasktypes}" var="tasktypes">
                <option value="${tasktypes.id}">${tasktypes.name}</option>
            </c:forEach>
        </form:select>
        <form:label path="text">Текст</form:label>
        <form:input path="text"/>
        <form:input path="dateto" id="datepicker"/>
        <input type="submit" value="Добавить"/>

    </form:form>


</div>

</body>
</html>