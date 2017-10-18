<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <c:forEach items="${employee}" var="row">
        <tr>
            <td>${row.name}</td>
            <td>${row.lastname}</td>
            <td><a href="#" onclick="call('${row.phonenumber}')">${row.phonenumber}</a></td>
            <td>${row.email}</td>
        </tr>
    </c:forEach>
</table>