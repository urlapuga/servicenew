<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
    function setEmployee(id) {
        var empId = document.getElementById("employee"+id).value;
        var res = sendGet("/settaskemployee/"+id+"/"+empId);
        alert(res);
    }
</script>
<table border="1">
    <c:forEach items="${tasks}" var="row">
        <tr>
            <td><a href="/task-edit-${row.id}" target="_blank">${row.text}</a></td>
            <td>
                <select id="employee${row.id}">
                    <c:forEach items="${employees}" var="employee">
                        <option value="${employee.id}" ${(employee.id == row.employeesByEmployeeTaskTo.id)?"selected":""}>${employee.lastname}</option>
                    </c:forEach>
                </select>
            </td>
            <td>${row.taskStatusByStatus.name}</td>
            <td><a href="/abonenteditor/${row.subscriberId}" target="_blank">${row.subscriberId}</a></td>
            <c:if test="${row.taskStatusByStatus.id<2}">
                <td>
                    <button onclick="setEmployee(${row.id})">Назначить</button>
                </td>
            </c:if>

        </tr>
    </c:forEach>
</table>