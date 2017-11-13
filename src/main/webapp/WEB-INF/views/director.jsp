<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<center>
    <div id="companiesDiv">
        </br></br>
        <h2>Компании</h2>
        <table border="1">
            <tr bgcolor="#a9a9a9">
                <th>Название</th>
                <th>Телефон</th>
                <th>Email</th>
                <th>Код</th>
                <th>Директор</th>
                <th>Управление</th>
            </tr>
            <c:forEach items="${companies}" var="company">
                <tr>

                    <form>
                        <td>${company.name}</td>
                        <td>${company.phone}</td>
                        <td>${company.email}</td>
                        <td>${company.code}</td>
                        <td>${company.director}</td>
                        <td><a href="<c:url value='/editcompany/${company.id}' />" target="_blank"
                               class="btn btn-default">Изменить</a>
                        </td>
                    </form>
                </tr>
            </c:forEach>


            <tr bgcolor="#a9a9a9">
                <th>Название</th>
                <th>Код</th>
                <th>Телефон</th>
                <th>Email</th>
                <th>Компания</th>
                <th>Управление</th>
            </tr>


            <tr bgcolor="#f0ffff">
                <form:form method="POST" action="/newcompany" modelAttribute="company">

                    <td><form:input path="name"/></td>

                    <td><form:input path="code"/></td>

                    <td><form:input path="phone"/></td>

                    <td><form:input path="email"/></td>

                    <td>
                        <select path="companyId">
                            <c:forEach items="${companies}" var="c">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>
                        </select>
                    </td>

                    <td><input type="submit" value="Создать"/></td>


                </form:form>
            </tr>
        </table>
    </div>


</center>

</body>
</html>