<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>��������� ���������</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

<center>
    <div id="companiesDiv">
        </br></br>
        <h2>��������</h2>
        <table border="1">
            <tr bgcolor="#a9a9a9">
                <th>��������</th>
                <th>�������</th>
                <th>Email</th>
                <th>���</th>
                <th>��������</th>
                <th>����������</th>
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
                               class="btn btn-default">��������</a>
                        </td>
                    </form>
                </tr>
            </c:forEach>


            <tr bgcolor="#a9a9a9">
                <th>��������</th>
                <th>�������</th>
                <th>Email</th>
                <th>���</th>
                <th>��������</th>
                <th>����������</th>
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

                    <td><input type="submit" value="�������"/></td>


                </form:form>
            </tr>
        </table>
    </div>

    <h2>����������</h2>
    <table border="1">
        <tr bgcolor="#a9a9a9">
            <th>���</th>
            <th>�������</th>
            <th>�������</th>
            <th>Email</th>
            <th>��������</th>
            <th>���������</th>
            <th>����������</th>
        </tr>
        <c:forEach items="${result}" var="employees">
            <tr>
                <td>${employees.name}</td>
                <td>${employees.lastname}</td>
                <td>${employees.phonenumber}</td>
                <td>${employees.email}</td>
                <td>${employees.companyId}</td>
                <td>${employees.positionId}</td>
                <td><a href="<c:url value='/editemployee/${employees.id}' />" target="_blank" class="btn btn-default">��������</a>
                </td>
            </tr>
        </c:forEach>
        <tr bgcolor="#a9a9a9">
            <th>���</th>
            <th>�������</th>
            <th>�������</th>
            <th>Email</th>
            <th>��������</th>
            <th>���������</th>
            <th>����������</th>
        </tr>


        <tr bgcolor="#f0ffff">
            <form:form method="POST" action="/newemployee/" modelAttribute="employee">
                <form:input type="hidden" path="id" id="id"/>


                <td><form:input path="name"/></td>

                <td><form:input path="lastname"/></td>

                <td><form:input path="phonenumber"/></td>

                <td><form:input path="email"/></td>

                <td>
                    <select path="companyId">
                        <c:forEach items="${companies}" var="c">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </td>

                <td>
                    <select path="positionId">
                        <c:forEach items="${positions}" var="p">
                            <option value="${p.id}">${p.name}</option>
                        </c:forEach>
                    </select>
                </td>


                <td><input type="submit" value="�������"/></td>


            </form:form>
        </tr>
    </table>

    <div id="positionsDiv">
        </br></br>
        <h2>���������</h2>
        <table border="1">
            <c:forEach items="${positions}" var="p">
                <tr>
                    <td>${p.name}</td>
                    <td><a href="<c:url value='/deleteposition/${p.id}' />"
                           class="btn btn-danger custom-width">�������</a>
                    </td>
                </tr>
            </c:forEach>
            <tr bgcolor="#f0ffff">
                <form:form method="POST" action="/newposition/" modelAttribute="position">

                    <td><form:hidden path="id"></form:hidden>
                        <form:input path="name"/></td>
                    <td><input type="submit" value="�������"/></td>
                </form:form>

            </tr>
        </table>

    </div>
</center>

</body>
</html>