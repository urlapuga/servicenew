<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<style>
.floatleft{
    float:left
}
</style>
<script>
function getStreets(){
    var xhttp = new XMLHttpRequest();
    var e = document.getElementsByName("city")[0];
    var cid = e.options[e.selectedIndex].value;
    xhttp.open("GET", "/data/streets/"+cid, false);
    xhttp.send();
    document.getElementById("streets").innerHTML = xhttp.responseText;
};

function getBuildings(){
    var xhttp = new XMLHttpRequest();
    var e = document.getElementsByName("street")[0];
    var cid = e.options[e.selectedIndex].value;
    xhttp.open("GET", "/data/buildings/"+cid, false);
    xhttp.send();
    document.getElementById("buildings").innerHTML = xhttp.responseText;
};

function showSubscribers (){
    var xhttp = new XMLHttpRequest();
    var idBy ;
    var id;
    var e = document.getElementsByName("building")[0];

    if(e==null||e.options[e.selectedIndex].value==-1){
        e = document.getElementsByName("street")[0];
        if(e==null||e.options[e.selectedIndex].value==-1) {
            e =document.getElementsByName("city")[0];
            if(e==null||e.options[e.selectedIndex].value==-1){
                alert("Нужно задать минимум город");
                return;
            }
            else{
                id = e.options[e.selectedIndex].value;
                idBy = "city";
            }
        }
        else{
            id = e.options[e.selectedIndex].value;
            idBy = "street";
        }
    }
    else{
        id = e.options[e.selectedIndex].value;
        idBy = "building";
    }
    xhttp.open("GET", "/data/subscribers/"+idBy+"/"+id, false);
    xhttp.send();
    document.getElementById("subscribers").innerHTML = xhttp.responseText;


};


</script>

<div class="floatleft">
    <div id="cities" class="floatleft" >
        <select path="city" name="city" onChange="getStreets()" class="selectpicker">
            <option value="-1">--</option>
            <c:forEach items="${cities}" var="city">

                <option value="${city.id}">${city.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="floatleft" id="streets">

    </div>
    <div class="floatleft" id="buildings">

    </div>
    <input class="btn" style="float: left"  type="button" value="Показать" class="btn" onclick="showSubscribers()">

</div>

</br>