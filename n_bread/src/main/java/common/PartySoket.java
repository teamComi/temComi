package common;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/comisoket")
public class PartySoket {

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("웹 소켓 연결 개수: " + sessions.size());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("서버에서 받은 message : "+ message);
        for (Session s : sessions) {
            s.getBasicRemote().sendText(message); // 모든 연결된 클라이언트에게 메시지 전송
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("웹 소켓 연결 종료");
    }
}