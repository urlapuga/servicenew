var chatHidden = false;
var tasksHidden = false;
function showChat() {

    if (!chatHidden) {
        document.getElementById("chatcontent").setAttribute("hidden", "");
        document.getElementById("nav").setAttribute("hidden", "");
        chatHidden = true;
    }
    else {
        document.getElementById("chatcontent").removeAttribute("hidden")
        document.getElementById("nav").removeAttribute("hidden");
        chatHidden = false;
    }

}

function showTasks() {

    if (!tasksHidden) {
        document.getElementById("owntaskscontainer").setAttribute("hidden", "");
        tasksHidden = true;
    }
    else {
        document.getElementById("owntaskscontainer").removeAttribute("hidden");
        tasksHidden = false;
    }

}


function setgetter(getter) {
    document.getElementById("getter").setAttribute('value', getter);
};

function send() {
    var xhttp = new XMLHttpRequest();
    var room = document.getElementById("room").value;
    ;
    var message = document.getElementById("mess").value;
    var getter = document.getElementById("getter").value;
    xhttp.open("GET", "newmessage-" + room + "-" + message + "-" + getter, false);
    xhttp.send();
    document.getElementById("content").innerHTML = xhttp.responseText;
};


function showRoom(room) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "chat/room-" + room + "/", false);
    xhttp.send();
    document.getElementById("chatcontent").innerHTML = xhttp.responseText;
    document.getElementById("chatcontent").style = "block";
};


function showUser(user) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "user-messages-" + user + "/", false);
    xhttp.send();
    document.getElementById("content").innerHTML = xhttp.responseText;
    document.getElementById("content").style = "block";
}