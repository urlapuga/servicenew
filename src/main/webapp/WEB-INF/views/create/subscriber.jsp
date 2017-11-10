<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

Офис: <input type="text" id="subscriberRoom">
Имя : <input type="text" id="subscriberName">
Телефон : <input type="text" id="subscriberFone">


<input type="button" onclick="createSubscriber()" value="�������">

<script>
    function createSubscriber() {

        if (document.getElementById("building") == null) {
            alert("Введите адрес");
            return;
        }
        var addr = document.getElementById("building").value;
        var room = document.getElementById("subscriberRoom").value;
        var name = document.getElementById("subscriberName").value;
        var fone = document.getElementById("subscriberFone").value;

        var id = sendGet("/newsubscriber/" + addr + "/" + room + "/" + name + "/" + fone + "/");
        id = id.trim();
        window.open("/abonenteditor/"+id,'_blank');
    };

</script>

