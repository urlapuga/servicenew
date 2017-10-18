<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

${task.dateto} ${task.text}


<div><jsp:include page="/abonenteditor/${task.subscriberId}"/></div>
</body>
</html>
