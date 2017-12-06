<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    function deletePlace(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "edit/places/del/" + id + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function addPlace() {
        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("placename").value;
        var pin = document.getElementById("pincode").value;
        xhttp.open("GET", "edit/places/add/" + name + "/" + pin + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function editPlace(id) {
        window.open("editor/place/" + id + "/", '_blank');
        return false;
    };
</script>
Точки
<table border="1">
    <tr>
        <th>
            Адрес
        </th>
        <th>
            Пин код
        </th>
        <th>
            Управление
        </th>
        <th>
            Удаление
        </th>
    </tr>

    <c:forEach items="${places}" var="place">
        <tr>
            <td>
                    ${place.address}
            </td>
            <td>
                    ${place.pincode}
            </td>
            <td>
                <button onclick="editPlace(${place.id})">Изменить</button>
            </td>
            <td>
                <button onclick="deletePlace(${place.id})">Удалить</button>
            </td>
        </tr>

    </c:forEach>
    <tr></tr>
    <tr>
        <td>
            <input type="text" id="placename">
        </td>
        <td>
            <input type="text" id="pincode">
        </td>
        <td>
            <button onclick="addPlace()">Создать</button>
        </td>
    </tr>

</table>