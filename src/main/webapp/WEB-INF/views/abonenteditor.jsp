<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<html>
<head>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"/>
        <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/i18n/jquery-ui-timepicker-ru.js"></script>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.css"/>

        <script>
            $(function () {
                $("#datepicker").datetimepicker();
            });
        </script>



    <title>Учетная запись абонента</title>
</head>
<body>


<center>
    <div>Договор ${subscriber.id}</div>
    <div>Дата регистрации ${subscriber.dateRegistered} </div>
    <div>Оплачено до ${subscriber.datepayedto}</div>
    <div>Тариф ${tarif.name} , Скорость ${tarif.speed} , Стоимость ${tarif.cost}</div>


    <table>

        <tr>
            <th>Обращение</th>
            <th>Телефон</th>
            <th>Почта</th>
            <th>Мак адрес</th>
            <th>Айпи Адрес</th>
            <th>Статус</th>
            <th>Тариф</th>
            <th>Свитчь</th>
            <th>Порт</th>
            <th>Управление</th>
        </tr>
        <tr>
            <form:form method="POST" action="/saveabonent" modelAttribute="subscriber">
                <form:input path="id" value="${subscriber.id}" hidden="true"></form:input>
                <form:input path="datepayedto" hidden="true" value="${subscriber.datepayedto}"></form:input></td>
                <form:input path="iptype" value="${subscriber.iptype}" hidden="true"></form:input>

                <td><form:input path="name" value="${subscriber.name}"/></td>
                <td><form:input path="phone" value="${subscriber.phone}"/></td>
                <td><form:input path="email" value="${subscriber.email}"/></td>
                <td><form:input path="macaddress" value="${subscriber.macaddress}"/></td>
                <td><form:input path="ipaddress" value="${subscriber.ipaddress}"/></td>
                <td>
                    <form:select path="status">
                        <option value="0"${(subscriber.status == 0)?"selected":""}>Disabled</option>
                        <option value="1"${(subscriber.status == 1)?"selected":""}>Active</option>
                    </form:select>
                </td>
                <td>
                    <form:select path="tarif">
                        <c:forEach items="${tarifs}" var="thetarif">
                            <option value="${thetarif.id}" ${(thetarif.id == subscriber.tarif)?"selected":""}>${thetarif.name}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <form:select path="device">
                        <c:forEach items="${devices}" var="device">
                            <option value="${device.id}" ${(device.id == subscriber.device)?"selected":""}>${device.ipaddress}</option>
                        </c:forEach>
                    </form:select>
                </td>
                <td><form:input path="port" value="${subscriber.port}"/></td>
                <td><input type="submit" value="Изменить"/></td>
            </form:form>
        </tr>
    </table>


    <table width="100%">
        <tr valign="top">
            <td width="50%">
                <jsp:include page="tasklist.jsp"/>
            </td>
            <td width="50%">
                <jsp:include page="paymentslist.jsp"/>
            </td>
        </tr>

    </table>
</center>
</body>
</html>
