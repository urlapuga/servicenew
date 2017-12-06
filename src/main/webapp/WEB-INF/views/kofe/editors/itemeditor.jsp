<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function deleteItemIngredient(id) {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "/kofe/edit/itemingredient/del/" + id + "/${item.id}/", false);
            xhttp.send();
            alert(xhttp.responseText);
        };

        function addItemIngredient() {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "/kofe/edit/itemingredient/add/" + id + "/${item.id}/", false);
            xhttp.send();
            alert(xhttp.responseText);
        };

        function updateItem(${item.id}) {
            var name = document.getElementById("itemname").value;
            var cost = document.getElementById("itemcost").value;
            var type = document.getElementById("itemtype").value;
            var addition = document.getElementById("itemaddition").value;

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "/kofe/edit/item/update/${item.id}/" + name + "/" + cost + "/" + type + "/" + addition + "/", false);
            xhttp.send();
            location.reload();
        };

    </script>
    <title>Редактирование товара ${item.name} </title>



</head>
<body>

<input type="text" value="${item.name}" id="itemname">
<input type="text" value="${item.cost}" id="itemcost">


<select id="itemaddition">
    <c:forEach items="${additions}" var="addition">
        <option value="${addition.id}" ${(addition.id==item.addition)?"selected":""}>${addition.name}</option>
    </c:forEach>
</select>

<select id="itemtype">
    <c:forEach items="${types}" var="type">
        <option value="${type.id}" ${(type.id==item.type)?"selected":""}>${type.name}</option>
    </c:forEach>
</select>

<button>Изменить</button>

<div>
    Ингредиенты
</div>


<table border="1">
    <tr>
        <th>
            Название
        </th>
        <th>
            Колличество
        </th>
        <th>
            Управление
        </th>
    </tr>

    <c:forEach items="${itemingredients}" var="itemingredient">
        <tr>
            <td>
                    ${itemingredient.ingredientname}
            </td>
            <td>
                    ${itemingredient.amount}
            </td>
            <td>
                <button onclick="deleteItemIngredient(${itemingredient.ingredientid})">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>


<select id="itemingredient">
    <c:forEach items="${ingredients}" var="ingredient">
        <option value="${ingredient.id}">${ingredient.name}</option>
    </c:forEach>
</select>
<input type="text" id="amount">
<button onclick="addItemIngredient()">Добавить</button>

<div>

</div>
</body>
</html>
