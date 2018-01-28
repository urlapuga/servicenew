<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script>

    function del(id){

    }

    function edit(id,cost){

    }

    function editPlace(){
        var addr = document.getElementById("placeAddr").value;
        var pincode = document.getElementById("placePincode").value;

        alert(addr  + pincode);
    }

</script>
<head>
    <title>Редактирование точки</title>
</head>

<input id="placeAddr" value="${place.address}">
<input id="placePincode" value="${place.pincode}">
<input type="button" value="Изменить" onclick="editPlace()">

<table>
    <tr>
        <th>
            Товар
        </th>
        <th>
            Цена
        </th>
        <th>
            Изменить
        </th>
        <th>
            Удалить
        </th>
    </tr>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>
                ${item.name}
            </td>
            <td>
                ${item.cost}
            </td>
            <td>
                <input type="button" value="Изменить">
            </td>
            <td>
                <input type="button" value="Удалить">
            </td>
        </tr>

    </c:forEach>
</table>


</body>
</html>
