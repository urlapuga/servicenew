var socket = new JsSIP.WebSocketInterface('ws://176.104.0.22:8088/ws');
var configuration = {
    sockets  : [ socket ],
    uri: "1060@176.104.0.22",
    authorization_user: "1060",
    password : 'Urlapuga2017'
};

var ua = new JsSIP.UA(configuration);

ua.start();

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
    ua.call(number, options);
}

//var session = ua.call('380638339275', options);

