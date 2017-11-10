<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/static/js/tasks.js"></script>
</head>
<body>

${task.dateto} ${task.text}
<input type="text" id="taskcoment">
<input type="button" value="Отменить" onclick="cancelTask()">
<input type="button" value="Отказатся" onclick="rejectTask()">

<br>
<div>
    <jsp:include page="/abonenteditor/${task.subscriberId}"/>
</div>
</body>
</html>
