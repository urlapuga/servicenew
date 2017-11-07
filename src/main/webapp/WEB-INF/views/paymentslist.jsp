<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">Платежи по абоненту</span></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Сумма</th>
            <th>Дата</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${payments}" var="payment">
            <tr>
                <td>${payment.amount}</td>
                <td>${payment.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

