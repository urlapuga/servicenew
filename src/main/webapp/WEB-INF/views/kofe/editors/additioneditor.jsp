<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script>
        function deleteAdditionItem(id) {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "/kofe/edit/additionitem/del/" + id + "/", false);
            xhttp.send();
            alert(xhttp.responseText);
        };

        function addAdditionItem() {
            var xhttp = new XMLHttpRequest();
            var itemId = document.getElementById("items").value;
            xhttp.open("GET", "/kofe/edit/additionitem/add/" + itemId + "/${addition.id}/", false );
            xhttp.send();
            alert(xhttp.responseText);
        };
    </script>
    <title>Редактирование дополнения ${addition.name}</title>
</head>
<body>
<table border="1">
    <tr>
        <th>
            Название
        </th>
        <th>
            Управление
        </th>
    </tr>
    <c:forEach items="${additionItems}" var="additems">
        <tr>
            <td>
                    ${additems.name}
            </td>
            <td>
                <button onclick="deleteAdditionItem(${additems.id})">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>
<div></div>


<select id="items">
    <c:forEach items="${items}" var="item">
        <option value="${item.id}">${item.name}</option>
    </c:forEach>
</select>
<button onclick="addAdditionItem()">Добавить</button>
</body>
</html>
