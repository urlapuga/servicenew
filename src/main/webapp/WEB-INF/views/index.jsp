<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <script src="/static/js/index.js" ></script>
    <script src="/static/js/jssip-3.0.15.min.js" ></script>
    <script src="/static/js/sipphone.js" ></script>
    <spring:url value="/static/css/index.css" var="maincss" />
    <title>My Work Place</title>
    <link href="${maincss}" rel="stylesheet" />
</head>
<body>
<div id="container">
    <div id="chat"><jsp:include page="/chat/rooms"/></div>
    <div id="content"><jsp:include page="/${page}"/></div>
    <div id="tasks"><jsp:include page="owntasks.jsp"/></div>
</div>
</body>
</html>
