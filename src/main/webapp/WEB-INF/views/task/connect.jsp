<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="POST" action="/task-edit" modelAttribute="task">
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

</body>
</html>
