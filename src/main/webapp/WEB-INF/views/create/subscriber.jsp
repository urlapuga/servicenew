<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="POST" action="/newsubscriber/" modelAttribute="subscriber">
    <form:label path="name">���</form:label>
    <form:input path="name"></form:input>

    <form:label path="phone">�������</form:label>
    <form:input path="phone"></form:input>

    <input type="submit" value="������� ��������"/>
</form:form>
