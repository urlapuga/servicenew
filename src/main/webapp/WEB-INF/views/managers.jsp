<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<html>
<head>

    <script>
        function showDiv() {
            var xhttp = new XMLHttpRequest();
            console.log(document.getElementById("searchString").value);
            xhttp.open("GET", "/googlecompanies?searchString=" + document.getElementById("searchString").value, false);
            xhttp.send();
            document.getElementById("companies").innerHTML = xhttp.responseText;
            document.getElementById("companies").style = "block";
        }
    </script>
    <title>Manager interface</title>
</head>
<body>


<input type="text" id="searchString" name="searchString">
<input type="submit" onclick="showDiv()" title="������ ������ �� �����������">

<div id="companies"></div>
������������� �������
<div id="todos">${clients}</div>
������������ ������
<div id="managertasks">${tasks}</div>
��� ������
<div id="tasks">${owntasks}</div>

</body>
</html>
