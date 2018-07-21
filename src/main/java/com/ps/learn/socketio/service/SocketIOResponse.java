package com.ps.learn.socketio.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.ps.learn.socketio.entity.MsgBean;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/21 0021.
 * 定义消息发送类：
 */
@Service("socketIOResponse")
public class SocketIOResponse {
    public void sendEvent(SocketIOClient client, MsgBean bean) {
        System.out.println("推送消息");
        client.sendEvent("OnMSG", bean);
    }
}
