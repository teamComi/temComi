<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>party_view</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="/comi/resources/css/lib/jquery-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/comi/resources/css/view_chat.css"/>
    <script type="text/javascript" src="/comi/resources/js/lib/jquery.min.js"></script>
    <script type="text/javascript" src="/comi/resources/js/util.js"></script>
    
</head>
<body>
    <!-- 채팅 리뷰-->
    <section id="chating">
        <!--채팅 헤드-->
        <div class="chating-head">
            <span class="chating-head-title">엔브레드톡</span>
        </div>
        <!--채팅 헤드 end-->
        
        <!--채팅 바디-->
        
        <div class="chating-body" id="chat">
            <div class="chating-body-box" id="chating_box">
            </div>
        </div>
        <input type="text" id="messageInput" size="110" placeholder="메시지 입력">
        <!--채팅 바디end-->

        <!--채팅 입력-->
        <!-- <div id="chat">
            <div id="messages"></div>
            <input type="text" id="messageInput" placeholder="메시지 입력">
            <button id="sendButton">보내기</button>
        </div> -->
        
        <!-- <div class="chating-input" id="chating-input-talk">
            
            <div class="chating-input-area">
                <textarea placeholder="엔브레드톡에 참여해보세요" class="chating-input-area-write"></textarea> 
                <button type="button" class="chating-post-stickerbtn">
                    <img class="chating-post-sendbtn-image" src="/comi/resources/images/stickerbtn.png">
                </button>
            </div>
            <div class="chating-post-area">
                <button type="button" class="chating-post-sendbtn">
                    <img class="chating-post-sendbtn-image" src="/comi/resources/images/sendbtn.png">
                </button>
            </div>
        </div> -->
        <!--채팅 입력 end-->
    </section>
    <!--참여 버튼 버튼을 클릭해야 채팅을 할 수 있음 - 참여하지 않으면 채팅기록만 볼수 있음-->
    <section class="chating-allow">
        <button class="chating-allow-btn" id="sendButton">보내기</button>
    </section>
    <script>
        const socket = new WebSocket("ws://localhost:8080/comi/comisoket"); // 웹 소켓 서버 주소와 포트로 연결
        var username = '<%= member.getMeName()%>';
        // var name = member.getMename();
        //     console.log(name);
        socket.onopen = () => {
            console.log("웹 소켓 연결 성공");
        };

        socket.onmessage = (event) => {
            let messageStr = JSON.stringify(event.data);
            const message = JSON.parse(event.data);
            const messagesDiv = document.getElementById("chating_box");
            messagesDiv.innerHTML += `<p>` + message.username +` : ` + message.text + `</p>`;
        };

        document.getElementById("sendButton").addEventListener("click", () => {
            const messageInput = document.getElementById("messageInput");
            //console.log(messageInput.value);
            
            const message = messageInput.value;
            if (message.trim() !== "") {
                socket.send(JSON.stringify({ username: username, text: message }));
                messageInput.value = "";
            }
        });
    </script>
    <!--참여 버튼 end-->
</body>
</html>