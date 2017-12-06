<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    function deleteAddition(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "edit/addition/del/" + id + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function addAddition() {
        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("additionname").value;
        xhttp.open("GET", "edit/addition/add/" + name + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function editAddition(id) {
        window.open("editor/addition/"+id+"/",'_blank'); return false;
    };

</script>
Дополнения
<table border="1">
    <tr>
        <th>
            Название
        </th>

        <th>
            Изменить
        </th>

        <th>
            Удалить
        </th>
    </tr>

    <c:forEach items="${additions}" var="addition">
        <tr>
            <td>
                    ${addition.name}
            </td>

            <td>
                <button onclick="editAddition(${addition.id})">Изменить</button>
            </td>
            <td>
                <button onclick="deleteAddition(${addition.id})">Удалить</button>
            </td>
        </tr>

    </c:forEach>
    <tr></tr>
    <tr>
        <td>
            <input type="text" id="additionname">
        </td>

        <td>
            <button onclick="addAddition()">Создать</button>
        </td>
    </tr>

</table>