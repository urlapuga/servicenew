<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border = "1">
    <c:forEach items="${clients}" var="row">
        <tr>
            <td><a href="/abonenteditor/${row.id}" target="_blank">${row.name}</a></td>
            <td>${row.dateCreated}</td>
            <td><a href="#" onclick="call('${row.phone}')">${row.phone}</a></td>
        </tr>
    </c:forEach>
</table>