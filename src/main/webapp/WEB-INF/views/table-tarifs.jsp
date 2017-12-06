<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div>
    Тарифы
</div>
<p></p>

<table border="1">
    <tr>
        <th>
            Название
        </th>
        <th>
            Стоимость
        </th>
        <th>
            Скорость
        </th>
        <th>
            Управление
        </th>
    </tr>

    <c:forEach items="${tarifs}" var="tarif">
        <tr>
            <td>
                    ${tarif.name}
            </td>
            <td>
                    ${tarif.cost}
            </td>
            <td>
                    ${tarif.speed}
            </td>
            <td><a href="<c:url value='/delete-tarif-${tarif.id}' />" class="btn btn-danger custom-width">delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>

        <form:form method="POST" action="/tarif" modelAttribute="tarif" accept-charset="utf-8">

            <form:input path="companyId" value="${company.id}" hidden="true"></form:input>

            <td>
                <form:input path="name"/>
            </td>
            <td>
                <form:input path="speed" pattern="[0-9]{1,4}"/>
            </td>
            <td>
                <form:input path="cost" pattern="[0-9]{1,5}"/>
            </td>
            <td>
                <input type="submit" value="Создать">
            </td>


        </form:form>

    </tr>
</table>


