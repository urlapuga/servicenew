<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

������� �������� ��������</br>

������� : <input type="text" id="abonentid" name="abonentid">
<input type="button" value="�������" onclick="showAbonent()">




<form:form method="POST" action="/newsubscriber/" modelAttribute="subscriber">
    <form:label path="name">���</form:label>
    <form:input path="name"></form:input>

    <form:label path="phone">�������</form:label>
    <form:input path="phone"></form:input>

    <input type="submit" value="������� ��������"/>
</form:form>








��������� ����������� �����������
<form>
    <input type="text">
    <input type="submit">
</form>

������ ������ �� �����������
<form>
    <input type="text">
    <input type="submit">
</form>


</body>
</html>
