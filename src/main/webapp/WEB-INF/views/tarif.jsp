<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tarif Editing</title>
</head>
<body>
<table>
    <c:forEach items="${tarifs}" var="tarif">
        <tr>
            <td>
                    ${tarif.name}
            </td>
            <td>
                    ${tarif.cost}
            </td>
            <td>
                    ${tarif.speed}
            </td>
            <td><a href="<c:url value='/delete-tarif-${tarif.id}' />" class="btn btn-danger custom-width">delete</a>
            </td>
        </tr>
    </c:forEach>

</table>



<form:form method="POST" action="/tarif" modelAttribute="tarif" accept-charset="utf-8">
    <form:label path="name">Название</form:label>
    <form:input path="name"/>
    <form:label path="speed">Скорость</form:label>
    <form:input path="speed" pattern="[0-9]{1,4}"/>
    <form:label path="cost">Стоимость</form:label>
    <form:input path="cost" pattern="[0-9]{1,5}"/>
    <input type="submit" value="Создать">
</form:form>

</body>
</html>
