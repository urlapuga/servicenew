<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/sitesite/${site.style}.css">
    <link rel="stylesheet" type="text/css" href="/static/css/sitesite/${site.menustyle}.css">

    <title>${site.name}</title>
    <script>

        function send() {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "heat/${site.id}/"+coords, false);
            xhttp.send(coords);
        };

        var coords = [];
    </script>
</head>
<body onunload="send()">
<div onmousemove="coords.push(event.clientX+':'+event.clientY)" onclick="console.logg(coords)">
    <div id="menudiv">
        <jsp:include page="sitemodules/menu.jsp"></jsp:include>
    </div>

    <c:forEach items="${pages}" var="page">
        <div class="page" style="background-color:${page.background}" id="${page.anchor}">${page.text}</div>
    </c:forEach>
</div>
</body>
</html>
