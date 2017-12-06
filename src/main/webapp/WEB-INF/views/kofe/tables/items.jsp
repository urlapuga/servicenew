<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    function deleteItem(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "edit/items/del/" + id + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function addItem() {
        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("itemname").value;
        var type = document.getElementById("itemtype").value;
        xhttp.open("GET", "edit/items/add/" + name + "/"+type+"/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function editItem(id) {
        window.open("editor/item/"+id+"/",'_blank'); return false;
    };

</script>
Товары
<table border="1">
    <tr>
        <th>
            Название
        </th>

        <th>
            Тип
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
                   <select id="type${item.id}">
                       <c:forEach items="${types}" var="type">
                           <option value="${type.id}" ${(type.id==item.type)?"selected":""}>${type.name}</option>
                       </c:forEach>
                   </select>
            </td>
            <td>
                <button onclick="editItem(${item.id})">Изменить</button>
            </td>
            <td>
                <button onclick="deleteItem(${item.id})">Удалить</button>
            </td>
        </tr>

    </c:forEach>
    <tr></tr>
    <tr>
        <td>
            <input type="text" id="itemname">
        </td>
        <td>
            <select id="itemtype">
                <c:forEach items="${types}" var="type">
                    <option value="${type.id}">${type.name}</option>
                </c:forEach>
            </select>
        </td>
        <td>
            <button onclick="addItem()">Создать</button>
        </td>
    </tr>

</table>