<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">������ �� ��������</span></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>�����</th>
            <th>������</th>
            <th>���</th>
            <th>�����������</th>
            <th>����</th>
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

                <td>${task.employeesByEmployee.lastname} ${task.employeesByEmployee.name}</td>
                <td>${task.dateto}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    </br>
    </br>
    <div>
        <form:form method="POST" action="/tasks" modelAttribute="task">
            <form:hidden path="subscriberId" value="${subscriber.id}"/>
            <form:label path="type">���</form:label>

            <form:select path="type">
                <c:forEach items="${tasktypes}" var="tasktypes">
                    <option value="${tasktypes.id}">${tasktypes.name}</option>
                </c:forEach>
            </form:select>
            <form:label path="text">�����</form:label>
            <form:input path="text"/>
            <form:input path="dateto" id="datepicker"/>
            <input type="submit" value="��������"/>

        </form:form>
    </div>

</div>
