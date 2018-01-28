var socket = new JsSIP.WebSocketInterface('ws://94.131.209.250:8088/ws');
var configuration = {
    sockets  : [ socket ],
    uri: "302@94.131.209.250",
    authorization_user: "302",
    password : 'Urlapuga2017'
};

var ua = new JsSIP.UA(configuration);



var eventHandlers = {
    'progress': function(e) {
        console.log('call is in progress');
    },
    'failed': function(e) {
        console.log('call failed');
    },
    'ended': function(e) {
        console.log('call ended');
    },
    'confirmed': function(e) {
        console.log('call confirmed');
    }
};

var options = {
    'eventHandlers'    : eventHandlers,
    'mediaConstraints' : { 'audio': true, 'video': false
    }
};

// var session  = ua.sendMessage('380638339275', "1234");

function call(number){
    ua.start();
    //ua.call(number, options);
    ua.send(number,"123");
}

function send(number){
    ua.start();
    //ua.call(number, options);
    ua.send(number,"123");
}
//var session = ua.call('380638339275', options);

