<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <c:forEach items="${subscribers}" var="row">
        <tr>
            <th>���</th>
            <th>�������</th>
            <th>Ip</th>
            <th>�����</th>
            <th>�����</th>
            <th>���</th>
            <th>��������</th>
            <th>�����</th>
            <th>������</th>
        </tr>
        <tr>
            <td>${row.name}</td>
            <td><a href="#" onclick="call('${row.phone}')">${row.phone}</a></td>
            <td>${row.ipaddress}</td>
            <td>${row.cityname}</td>
            <td>${row.streetname}</td>
            <td>${row.number}</td>
            <td>${row.room}</td>
            <td>${row.tarif}</td>
            <td>${row.statusname}</td>
        </tr>
    </c:forEach>
</table>