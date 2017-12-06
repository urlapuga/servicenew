<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Склад</title>
</head>
<body>
<table border="1">
    <tr>
        <th>
            Ингредиент
        </th>
        <th>
            Колличество
        </th>
    </tr>

<c:forEach items="${skladList}" var="sklad">
    <tr>
        <td>
            ${ingredientList.get(sklad.ingredient).name}
        </td>
        <td>
                ${sklad.amount}
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
