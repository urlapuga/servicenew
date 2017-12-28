<%@ page language="java" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Редактирование компании</title>
</head>
<body>

<form:form method="POST" action="/savecompany/" modelAttribute="company">
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
                <td><a href="<c:url value='/editemployee/${employees.id}' />" class="btn btn-default">Изменить</a></td>
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


                <td><input type="submit" value="Добавить"/></td>
            </form:form>
        </tr>
    </table>

</center>


<center>
    <h2>Задачи</h2>
    <table border="1">
        <thead>
        <tr>
            <th>Текст</th>
            <th>Статус</th>
            <th>Тип</th>
            <th>Дата</th>
            <th>Исполнитель</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.text}</td>
                <c:choose>
                    <c:when test="${task.status=='0'}">
                        <td>Новая</td>
                    </c:when>
                    <c:when test="${task.status=='1'}">
                        <td>В процессе</td>
                    </c:when>
                    <c:when test="${task.status=='2'}">
                        <td>Выполнена</td>
                    </c:when>
                    <c:when test="${task.status=='3'}">
                        <td>Отменена</td>
                    </c:when>
                </c:choose>

                <td>
                    <c:forEach items="${tasktypes}" var="tasktypes">
                        ${tasktypes.id eq task.type ? tasktypes.name : ''}
                    </c:forEach>
                </td>
                <td>${task.dateto}</td>
                <td>${task.employeesByEmployeeTaskTo.name}</td>

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


    <div id="positionsDiv">
        </br></br>
        <h2>Должности</h2>
        <table border="1">
            <c:forEach items="${positions}" var="p">
                <tr>
                    <td>${p.name}</td>
                    <td><a href="<c:url value='/deleteposition/${p.id}' />"
                           class="btn btn-danger custom-width">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
            <tr bgcolor="#f0ffff">
                <form:form method="POST" action="/newposition/" modelAttribute="position">

                    <td><form:hidden path="id"></form:hidden>
                        <form:input path="name"/></td>
                    <td><input type="submit" value="Создать"/></td>
                </form:form>

            </tr>
        </table>

    </div>

<jsp:include page="table-tarifs.jsp"></jsp:include>
</center>


</body>
</html>
