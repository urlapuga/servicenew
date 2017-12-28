var chatHidden = false;
var tasksHidden = false;


function callNew() {

    var sipStack;
    var eventsListener = function (e) {
        if (e.type == 'started') {
            makeCall();
        }
        else if (e.type == 'i_new_message') { // incoming new SIP MESSAGE (SMS-like)
            acceptMessage(e);
        }
        else if (e.type == 'i_new_call') { // incoming audio/video call
            acceptCall(e);
        }
    }
};

var makeCall = function(){
    callSession = sipStack.newSession('call-audiovideo', {
        events_listener: { events: '*', listener: eventsListener } // optional: '*' means all events
    });
    callSession.call('0638339275');
    createSipStack();
};
    function createSipStack(){
        sipStack = new SIPml.Stack({
                realm: '94.131.209.250', // mandatory: domain name
                impi: '302', // mandatory: authorization name (IMS Private Identity)
                impu: 'sip:302@94.131.209.250', // mandatory: valid SIP Uri (IMS Public Identity)
                password: 'Urlapuga2017', // optional
                display_name: '302',
            events_listener: { events: '*', listener: eventsListener }// optional
            }
        );
        sipStack.start();
        var callSession;
    };






function sendGet(addrString){
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", addrString, false);
    xhttp.send();
    return xhttp.responseText;
};

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

};

function showTasks() {

    if (!tasksHidden) {
        document.getElementById("owntaskscontainer").setAttribute("hidden", "");
        tasksHidden = true;
    }
    else {
        document.getElementById("owntaskscontainer").removeAttribute("hidden");
        tasksHidden = false;
    }

};


function setgetter(getter) {
    document.getElementById("getter").setAttribute('value', getter);
};

function send() {
    var xhttp = new XMLHttpRequest();
    var room = document.getElementById("room").value;
    var message = document.getElementById("mess").value;
    var getter = document.getElementById("getter").value;
    xhttp.open("GET", "chat/newmessage-" + room + "-" + message + "-" + getter, false);
    xhttp.send();
    document.getElementById("content").innerHTML = xhttp.responseText;
    showRoom(room);
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
    var subscriberName = document.getElementById("abonentName").value;
    var subscriberId = document.getElementById("abonentid").value;
    if(subscriberName!=null ){
            if(subscriberName.length<3) alert("Название - минимум 3 буквы");
            else{

            }
    }
    if(subscriberId.length==0 ){alert("Необходимо указать номер договора");}
    window.open("/abonenteditor/" + subscriberId);
};

function showDiv() {
    var xhttp = new XMLHttpRequest();
    console.log(document.getElementById("searchString").value);
    xhttp.open("GET", "/googlecompanies?searchString=" + document.getElementById("searchString").value, false);
    xhttp.send();
    document.getElementById("companies").innerHTML = xhttp.responseText;
    document.getElementById("companies").style = "block";
};

