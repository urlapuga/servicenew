<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <c:forEach items="${tasks}" var="row">
        <tr>
            <td><a href="/task-edit-${row.id}" target="_blank">${row.text}</a></td>
            <td><a href="/editemployee/${row.employeesByEmployeeTaskTo.id}" target="_blank">${row.employeesByEmployeeTaskTo.lastname} </a></td>
            <td>${row.taskStatusByStatus.name}</td>
            <td><a href="/abonenteditor/${row.subscriberId}" target="_blank">${row.subscriberId}</a></td>
        </tr>
    </c:forEach>
</table>