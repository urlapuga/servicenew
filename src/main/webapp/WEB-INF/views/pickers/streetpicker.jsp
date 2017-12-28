<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select path="street" name="street" onChange="getBuildings()" class="selectpicker">
    <option value="-1">--</option>
    <c:forEach items="${streets}" var="street">
        <option value="${street.id}">${street.name}</option>
    </c:forEach>
</select>