<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Учетная запись абонента</title>
</head>
<body>





<div>Добрый день , уважаемый ${subscriber.name} </div>
<div>Ваш договор ${subscriber.id}</div>
<div>Дата регистрации ${subscriber.dateRegistered} </div>

<div>Ваш тариф ${tarif.name} , Скорость ${tarif.speed} , Стоимость ${tarif.cost}</div>
<div>Оплачено до ${subscriber.datepayedto}</div>
<div>Статус <c:if test="${subscriber.status == 1}"> Активен </c:if>
    <c:if test="${subscriber.status == 0}"> Неактивен </c:if>
</div>


<table>
    <tr>
        <td>
            email
        </td>
        <td>
            ${subscriber.email}
        </td>
    </tr>

    <tr>
        <td>
            phone
        </td>
        <td>
            ${subscriber.phone}
        </td>
    </tr>

    <tr>
        <td>
            macadress
        </td>
        <td>
            ${subscriber.macaddress}
        </td>
    </tr>

    <tr>
        <td>
            ipadress
        </td>
        <td>
            ${subscriber.ipaddress}
        </td>
    </tr>
</table>


${subscriber.device}
${subscriber.port}

${subscriber.tarif}
${subscriber.iptype}

</body>
</html>
