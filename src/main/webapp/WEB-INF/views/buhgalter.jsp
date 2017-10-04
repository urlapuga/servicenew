<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script>
        function showDiv() {
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "data/payments", false);
            xhttp.send();
            document.getElementById("welcomeDiv").innerHTML = xhttp.responseText;
            document.getElementById("welcomeDiv").style = "block";
        }
    </script>
    <title>Интерфейс бухгалтера</title>
</head>
<body>

<input type="button" name="answer" value="Show Div" onclick="showDiv()" />
<div id="welcomeDiv"  style="display:none;" class="answer_list" ></div>
</body>
</html>
