<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="pickers/addresspicker.jsp"></jsp:include>



Договор : <input type="text" id="abonentid" name="abonentid">
<input type="button" value="Открыть" onclick="showAbonent()">


<jsp:include page="create/subscriber.jsp"></jsp:include>





</br>
Проверить возможность подключения
<form>
    <input type="text">
    <input type="submit">
</form>

Внести заявку на подключение
<form>
    <input type="text">
    <input type="submit">
</form>


</body>
</html>
