<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    function deleteType(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "edit/types/del/" + id + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function addType() {
        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("typename").value;
        xhttp.open("GET", "edit/types/add/" + name + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    }
</script>
Типы
<table border="1">
    <tr>
        <th>
            Название
        </th>
        <th>
            Управление
        </th>
    </tr>

    <c:forEach items="${types}" var="type">
        <tr>
            <td>
                    ${type.name}
            </td>
            <td>
                <button onclick="deleteType(${type.id})">Удалить</button>
            </td>
        </tr>

    </c:forEach>
    <tr></tr>
    <tr>
        <td>
            <input type="text" id="typename">
        </td>
        <td>
            <button onclick="addType()">Создать</button>
        </td>
    </tr>

</table>