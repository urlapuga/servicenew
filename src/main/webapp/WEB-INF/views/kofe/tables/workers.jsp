<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    function deleteWorker(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "edit/worker/del/" + id + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function addWorker() {
        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("workername").value;
        var phone = document.getElementById("workerphone").value;
        xhttp.open("GET", "edit/worker/add/" + name + "/" + phone + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function editWorker(id) {
        window.open("editor/worker/" + id + "/", '_blank');
        return false;
    };
</script>
Сотрудники
<table border="1">
    <tr>
        <th>
            Имя
        </th>
        <th>
            Телефон
        </th>
        <th>
            Место
        </th>
        <th>
            Заработок
        </th>
        <th>
            Статус
        </th>
        <th>
            Управление
        </th>
        <th>
            Удаление
        </th>
    </tr>

    <c:forEach items="${workers}" var="worker">
        <tr>
            <td>
                    ${worker.name}
            </td>
            <td>
                    ${worker.phone}
            </td>
            <td>
                    ${worker.place}
            </td>
            <td>
                    ${worker.zarabotal}
            </td>
            <td>
                    ${worker.status}
            </td>
            <td>
                <button onclick="editWorker(${worker.id})">Изменить</button>
            </td>

            <td>
                <button onclick="deleteWorker(${worker.id})">Удалить</button>
            </td>
        </tr>

    </c:forEach>
    <tr></tr>
    <tr>
        <td>
            <input type="text" id="workername">
        </td>
        <td>
            <input type="text" id="workerphone">
        </td>

        <td>
            <button onclick="addWorker()">Создать</button>
        </td>
    </tr>

</table>