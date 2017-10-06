<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <script>
        function showDiv() {
            var xhttp = new XMLHttpRequest();
            console.log(document.getElementById("searchString").value);
            xhttp.open("GET", "/googlecompanies?searchString="+document.getElementById("searchString").value, false);
            xhttp.send();
            document.getElementById("companies").innerHTML = xhttp.responseText;
            document.getElementById("companies").style = "block";
        }
    </script>
    <title>Manager interface</title>
</head>
<body>


    <input type="text" id="searchString" name="searchString">
    <input type="submit" onclick="showDiv()" title="пустой запрос не разрешается">

<div id="companies"></div>

Потенциальные клиенты
<div id="todos">${clients}</div>
Мои задачи
<div id="tasks"></div>

</body>
</html>
