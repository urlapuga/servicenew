<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <div id="remoteVideo"></div>

    <div id="remoteAudio"></div>

    <script src="/static/js/sip2018.js"></script>

    <script>

        var userAgent = new SIP.UA({
            uri: '302@94.131.209.250',
            wsServers: ['ws://94.131.209.250:8088/ws'],
            authorizationUser: '302',
            password: 'Urlapuga2017'
        });


        var simple = new SIP.WebRTC.Simple({
            media: {
                remote: {
                    audio: document.getElementById('remoteAudio')
                }
            },
            ua: {
                uri: '302@94.131.209.250',
                wsServers: ['ws://94.131.209.250:8088/ws'],
                authorizationUser: '302',
                password: 'Urlapuga2017'
            }
        });
        
        function sendSMS() {
           // simple.call("0638339275");

            simple.message('0638339275','123');
            console.log("123");
            userAgent.message("0638339275","123");
        }



    </script>


    <title>Sms sender</title>
</head>
<body>


Текст<input type="text" id="text" size="200">
Телефон<input type="text" id="phone">
<button onclick="sendSMS()">Отправить</button>
</body>
</html>
