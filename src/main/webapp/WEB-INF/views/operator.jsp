<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="pickers/addresspicker.jsp"></jsp:include>



������� : <input type="text" id="abonentid" name="abonentid">
<input type="button" value="�������" onclick="showAbonent()">


<jsp:include page="create/subscriber.jsp"></jsp:include>





</br>
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
