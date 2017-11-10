<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script>

        var active = 0;

        function play(file){
            var audio = new Audio('/static/audio/'+file+'.mp3');
            audio.play();
        }

        function begin() {
            if (active == 0) {
                active = 1;
                start();
            }
        }

        function stop() {
            active = 0;
        }

        function func(message) {
            play(message);
            console.logg(message);
            alert(message);
        }

        function start() {
            var work = document.getElementById("work").getAttribute("value") * 1000 * 60;
            var rest = document.getElementById("rest").getAttribute("value") * 1000 * 60;
            var bigrest = document.getElementById("bigrest").getAttribute("value") * 1000 * 60;
            func("start");
            setTimeout("func('pause')", work);
            setTimeout("func('start')", work + rest);
            setTimeout("func('pause')", work + rest + work);
            setTimeout("func('start')", work + rest + work + rest);
            setTimeout("func('bigpause')", work + rest + work + rest + work);
        }

    </script>
</head>
<body onload="begin()">
<input type="text" value="25" id="work">
<input type="text" value="5" id="rest">
<input type="text" value="15" id="bigrest">
<input type="button" value="start" onclick="begin()">
<input type="button" value="stop" onclick="stop()">


<div id="timer"></div>
</body>

</html>
