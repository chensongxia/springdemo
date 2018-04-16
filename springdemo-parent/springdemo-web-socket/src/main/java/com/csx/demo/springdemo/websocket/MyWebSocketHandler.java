package com.csx.demo.springdemo.websocket;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;

public class MyWebSocketHandler implements WebSocketHandler{

    private Logger logger = LoggerFactory.getLogger(MyWebSocketHandler.class);

    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();

    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.info("connect websocket success.......");
        users.add(webSocketSession);
    }

    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        logger.info("AAAAAAAAAAAAAAAA.......");
        JSONObject message = JSONObject.parseObject((String)webSocketMessage.getPayload());
        String id = webSocketSession.getId();
        logger.info("get message from id:"+id+" content:"+message);
        sendMsgToAllUsers(webSocketMessage);
    }

    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        logger.info("BBBBBBBBBBBBBBBB.......");
    }

    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.info("CCCCCCCCCCCCCCCC.......");
    }

    public boolean supportsPartialMessages() {
        logger.info("DDDDDDDDDDDDDDDD.......");
        return false;
    }

    // 给所有用户发送 信息
    public void sendMsgToAllUsers(WebSocketMessage<?> message) throws Exception{

        for (WebSocketSession user : users) {
            user.sendMessage(message);
        }

    }
}
