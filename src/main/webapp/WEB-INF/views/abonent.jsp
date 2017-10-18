<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<html>
<head>
    <title>������� ������ ��������</title>
</head>
<body>





<div>������ ���� , ��������� ${subscriber.name} </div>
<div>��� ������� ${subscriber.id}</div>
<div>���� ����������� ${subscriber.dateRegistered} </div>

<div>��� ����� ${tarif.name} , �������� ${tarif.speed} , ��������� ${tarif.cost}</div>
<div>�������� �� ${subscriber.datepayedto}</div>
<div>������ <c:if test="${subscriber.status == 1}"> ������� </c:if>
    <c:if test="${subscriber.status == 0}"> �������� </c:if>
</div>
<div>��������</div>
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
