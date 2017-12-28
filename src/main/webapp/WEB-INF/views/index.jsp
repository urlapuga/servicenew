<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <script src="/static/js/sipml.js"></script>
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

    <div id="chat" style="background-color: aliceblue">
        <jsp:include page="/chat/rooms"/>
    </div>
    <center>
        <div id="content">



            <div id="mainDiv">
                <table>
                    <tr>
                        <td><a href="/exit"><input type="button" class="btn" value="Выход" style="float: right"> </a></td>
                    </tr>
                    <tr>
                        <td>
                            <jsp:include page="/abonentsearch"></jsp:include>

                        </td>
                    </tr>
                    <tr style="height: 20px">
                        <td></td>
                    </tr>
                    <tr>
                        <td>
                            <jsp:include page="create/subscriber.jsp"></jsp:include>
                        </td>
                    </tr>
                </table>



            </div>
            <div id="subscribers"></div>
            <jsp:include page="/${page}"/>

        </div>
    </center>
    <div id="tasks">
        <jsp:include page="owntasks.jsp"/>
    </div>

</body>
</html>
