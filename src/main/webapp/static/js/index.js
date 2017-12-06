var chatHidden = false;
var tasksHidden = false;


function callNew(){


    SIPml.init(
        function(e){
            var stack =  new SIPml.Stack({realm: '94.131.209.250', impi: '302', impu: 'sip:302@94.131.209.250', password: 'Urlapuga2017',
                events_listener: { events: 'started', listener: function(e){
                    var callSession = stack.newSession('call-audiovideo', {

                    });
                    callSession.call('380638339275');
                }
                }
            });
            stack.start();
        }
    );


}



function sendGet(addrString){
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", addrString, false);
    xhttp.send();
    return xhttp.responseText;
}

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
    xhttp.open("GET", "chat/user-" + user + "/", false);
    xhttp.send();
    document.getElementById("chatcontent").innerHTML = xhttp.responseText;
    document.getElementById("chatcontent").style = "block";
};

function showAbonent() {
    window.open("/abonenteditor/" + document.getElementById("abonentid").value);
};

function showDiv() {
    var xhttp = new XMLHttpRequest();
    console.log(document.getElementById("searchString").value);
    xhttp.open("GET", "/googlecompanies?searchString=" + document.getElementById("searchString").value, false);
    xhttp.send();
    document.getElementById("companies").innerHTML = xhttp.responseText;
    document.getElementById("companies").style = "block";
};

