<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <script src="/static/js/index.js"></script>
    <script src="/static/js/tasks.js"></script>
    <script src="/static/js/jssip-3.0.15.min.js"></script>
    <script src="/static/js/sipphone.js"></script>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"/>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/i18n/jquery-ui-timepicker-ru.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/jquery-ui-timepicker-addon/1.6.3/jquery-ui-timepicker-addon.css"/>


    <spring:url value="/static/css/index.css" var="maincss"/>

    <title>My Work Place</title>
    <link href="${maincss}" rel="stylesheet"/>
</head>
<body>

<div id="container">
    <div id="chat">
        <jsp:include page="/chat/rooms"/>
    </div>

    <div id="content">

        <center>

            <jsp:include page="/abonentsearch"></jsp:include>
            <%-- <jsp:include page="/${page}"/>--%>
        </center>
    </div>
    <div id="tasks">
        <jsp:include page="owntasks.jsp"/>
    </div>
</div>
</body>
</html>
