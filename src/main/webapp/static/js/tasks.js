function showTasksByDate() {
  var date = document.getElementById("dateTaskTo").value ;
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "/owntasksByDate/" + date + "/", false);
    xhttp.send();
    var  resp = xhttp.responseText;
    document.getElementById("tasks").innerHTML=resp;

};

function createowntask() {

    var dateto = document.getElementById("datepicker1").value;
    dateto = dateto.replace("/", "_").replace("/", "_");

    var type = document.getElementById("tasktype").value;
    var subscriber = document.getElementById("subscriberid").value;
    var text = document.getElementById("text").value;

    if ((text.length == 0 ) || (dateto.length == 0) || (type.length == 0) || subscriber.length == 0) alert('Все поля обязательны для заполнения');
    else {
        console.log(dateto + type + subscriber + text);
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "/newowntask/" + type + "/" + subscriber + "/" + dateto + "/" + text, false);
        xhttp.send();
        document.getElementById("tasks").innerHTML = xhttp.responseText;
    }
};

function closeTask(id) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "closetask/" + id + "/", false);
    xhttp.send();
    alert(xhttp.responseText);
    location.reload();
};

function startTask(id) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "startwork/" + id + "/", false);
    xhttp.send();
    var resp = xhttp.responseText;
    alert(resp);
    location.reload();
};

function cancelTask(id) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "canceltask/" + id + "/", false);
    xhttp.send();
    alert(xhttp.responseText);
    location.reload();
};

function rejectTask(id) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "rejecttask/" + id + "/", false);
    xhttp.send();
    alert(xhttp.responseText);
};



