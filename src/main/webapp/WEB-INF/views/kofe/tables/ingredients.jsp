<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    function deleteIngredient(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "edit/ingredients/del/" + id + "/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function addIngredient() {
        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("ingredientname").value;
        xhttp.open("GET", "edit/ingredients/add/" + name +"/", false);
        xhttp.send();
        alert(xhttp.responseText);
    };

    function editIngredient(id) {
        window.open("editor/ingredient/"+id+"/",'_blank'); return false;
    };

</script>
Ингредиенты
<table border="1">
    <tr>
        <th>
            Название
        </th>
        <th>
            Управление
        </th>
    </tr>

    <c:forEach items="${ingredients}" var="ingredient">
        <tr>
            <td>
                    ${ingredient.name}
            </td>
            <td>
                <button onclick="deleteIngredient(${ingredient.id})">Удалить</button>
            </td>
        </tr>

    </c:forEach>
    <tr></tr>
    <tr>
        <td>
            <input type="text" id="ingredientname">
        </td>
        <td>
            <button onclick="addIngredient()">Создать</button>
        </td>
    </tr>

</table>