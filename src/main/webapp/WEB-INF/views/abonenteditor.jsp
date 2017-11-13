<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
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

        function sendGet(addrString) {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", addrString, false);
            xhttp.send();
            return xhttp.responseText;
        };

        function generatePass(id) {
            var email = document.getElementById("email").value;
            if (email.length < 1) {
                alert("Пароль отправляется на почту");
                return;
            }
            alert(sendGet("/generatePass/" + id));
        };

        function updateTarif(id) {
            var device = document.getElementById("device" + id).value;
            var port = document.getElementById("port" + id).value;
            alert(sendGet("/edittarif/" + id + "/" + device + "/" + port));
        };

        function deleteTarif(id) {
            var device = document.getElementById("device" + id).value;
            var port = document.getElementById("port" + id).value;
            alert(sendGet("/deletetarif/" + id));
        };
    </script>


    <title>Учетная запись абонента</title>
</head>
<body>


<center>
    Договор ${subscriber.id} Дата регистрации ${subscriber.dateRegistered.toString().split(" ")[0]} Оплачено
    до ${subscriber.datepayedto.toString().split(" ")[0]}
    <input type="button" value="Создать пароль" onclick="generatePass(${subscriber.id})">
    <div>
        <a href="/showdoc/dogovor/${subscriber.id}" target="_blank">
            <button>Договор</button>
        </a>
        <a href="/showdoc/dodatoc/${subscriber.id}" target="_blank">
            <button>Додаток</button>
        </a>
        <a href="/showdoc/conectakt/${subscriber.id}" target="_blank">
            <button>Акт подключения</button>
        </a>
        <a href="/showdoc/schet/${subscriber.id}" target="_blank">
            <button>Счет</button>
        </a>
        <a href="/showdoc/akt/${subscriber.id}" target="_blank">
            <button>Акт</button>
        </a>
    </div>
    <div>Тарифы</div>
    <div>
        <table border="1">
            <c:forEach items="${alltarifs}" var="alltarify">
                <tr>
                    <td>
                            ${alltarify.name}
                    </td>
                    <td>
                            ${alltarify.speed}
                    </td>
                    <td>
                            ${alltarify.cost}
                    </td>
                    <td>
                        <select id="device${alltarify.subscribertarifid}">
                            <c:forEach items="${devices}" var="dev">
                                <option value="${dev.id}" ${(alltarify.device==dev.id)?"selected":""}>${dev.ipaddress}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input size="5" type="text" value="${alltarify.port}" id="port${alltarify.subscribertarifid}">
                    </td>
                    <td>
                            ${alltarify.active}
                    </td>
                    <td>
                        <input value="Изменить" type="button" onclick="updateTarif(${alltarify.subscribertarifid})">
                    </td>
                    <td>
                        <input value="Удалить" type="button" onclick="deleteTarif(${alltarify.subscribertarifid})">
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


    <div>
        <form:form method="POST" action="/addtarif" modelAttribute="subscribertarifs">
            <form:hidden path="subscriberId" value="${subscriber.id}"></form:hidden>
            <form:hidden path="active" value="1"></form:hidden>
            <form:select path="tarifId">
                <c:forEach var="tarif" items="${tarifs}">
                    <option value="${tarif.id}">
                            ${tarif.name}
                    </option>
                </c:forEach>
            </form:select>

            <form:select path="device">
                <c:forEach var="device" items="${devices}">
                    <option value="${device.id}">
                            ${device.ipaddress}
                    </option>
                </c:forEach>
            </form:select>

            <form:input path="port"></form:input>

            <input type="submit" value="Добавить"/>
        </form:form>

    </div>


    </div>
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


    <table>
        <tr>
            <th>
                Название
            </th>
            <th>
                Адрес
            </th>
            <th>
                Р/Р
            </th>
            <th>
                Банк
            </th>
            <th>
                МФО
            </th>
            <th>
                ЕДРПОУ
            </th>
            <th>
                ЕДР
            </th>
            <th>
                Форма налогообложения
            </th>
            <th>
                Директор
            </th>
            <th>
                Телефон
            </th>
            <th>
                Управление
            </th>

        </tr>

        <tr>

            <form:form method="POST" action="/saverekvizity" modelAttribute="rekvizity">
                <form:input path="id" value="${rekvizity.id}" hidden="true"></form:input>
                <form:input path="subscriber" hidden="true" value="${rekvizity.subscriber}"></form:input></td>
                <form:input path="data" hidden="true" value="${rekvizity.data}"></form:input></td>
                <td><form:input path="fopname" value="${rekvizity.fopname}"/></td>
                <td><form:input path="address" value="${rekvizity.address}"/></td>
                <td><form:input path="rr" value="${rekvizity.rr}"/></td>
                <td><form:input path="bank" value="${rekvizity.bank}"/></td>
                <td><form:input path="mfo" value="${rekvizity.mfo}"/></td>

                <td><form:input path="edrpou" value="${rekvizity.edrpou}"/></td>
                <td><form:input path="edr" value="${rekvizity.edr}"/></td>
                <td><form:input path="nalogform" value="${rekvizity.nalogform}"/></td>
                <td><form:input path="director" value="${rekvizity.director}"/></td>
                <td><form:input path="phone" value="${rekvizity.phone}"/></td>
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
