<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<html>
<head>
    <title>Учетная запись абонента</title>
</head>
<body>


<center>
    <div>Договор ${subscriber.id}</div>
    <div>Дата регистрации ${subscriber.dateRegistered} </div>
    <div>Оплачено до ${subscriber.datepayedto}</div>
    <div>Тариф ${tarif.name} , Скорость ${tarif.speed} , Стоимость ${tarif.cost}</div>

    <form:form method="POST" action="/saveabonent" modelAttribute="subscriber">
        <form:input path="id" value="${subscriber.id}" hidden="true"></form:input>
        <form:input path="datepayedto" hidden="true" value="${subscriber.datepayedto}"></form:input></td>
        <form:input path="iptype" value="${subscriber.iptype}" hidden="true"></form:input>

        <form:input path="name" value="${subscriber.name}"/>

        <form:input path="phone" value="${subscriber.phone}"/>

        <form:input path="email" value="${subscriber.email}"/>

        <form:input path="macaddress" value="${subscriber.macaddress}"/>

        <form:input path="ipaddress" value="${subscriber.ipaddress}"/>

        <form:select path="status" >
            <option value="0"${(subscriber.status == 0)?"selected":""}>Disabled</option>
            <option value="1"${(subscriber.status == 1)?"selected":""}>Active</option>
        </form:select>

        <form:select path="tarif">
            <c:forEach items="${tarifs}" var="thetarif">
                <option value="${thetarif.id}" ${(thetarif.id == subscriber.tarif)?"selected":""}>${thetarif.name}</option>
            </c:forEach>
        </form:select>

        <form:select path="device">
            <c:forEach items="${devices}" var="device">
                <option value="${device.id}" ${(device.id == subscriber.device)?"selected":""}>${device.ipaddress}</option>
            </c:forEach>
        </form:select>

        <form:input path="port" value="${subscriber.port}" />


        <td><input type="submit" value="Изменить"/></td>

    </form:form>


    <div id="tasks">
        <jsp:include page="tasklist.jsp"/>
    </div>
</center>
</body>
</html>
