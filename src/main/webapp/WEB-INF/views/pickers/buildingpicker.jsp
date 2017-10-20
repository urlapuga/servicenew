<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select path="building" name="building">
    <option value="-1">--</option>
    <c:forEach items="${buildings}" var="building">
        <option value="${building.id}">${building.number}</option>
    </c:forEach>
</select>