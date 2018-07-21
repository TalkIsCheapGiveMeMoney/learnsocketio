package com.ps.learn.socketio.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.ps.learn.socketio.entity.MsgBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/21 0021.
 * 　定义Listen，用户监听Oncennect、disconnect和OnMSG事件：
 */
@Service("eventListenner")
public class EventListenner {
    @Resource(name = "clientCache")
    private SocketIOClientCache clientCache;

    @Resource(name = "socketIOResponse")
    private SocketIOResponse socketIOResponse;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        //根据用户id 或Cookie 存放 此处为模拟场景
        String no0 = client.getHandshakeData().getSingleUrlParam("no");
        System.out.println("工号为no = "+no0+"的用户建立WebSocket连接");
        clientCache.addClient(client,no0);
        System.out.println("建立连接");
    }

    @OnEvent("OnMSG")
    public void onSync(SocketIOClient client, MsgBean bean) {
        System.out.printf("收到消息-from: %s to:%s\n", bean.getFrom(), bean.getTo());
        SocketIOClient ioClients = clientCache.getClient(bean.getTo());
        System.out.println("clientCache");
        if (ioClients == null) {
            System.out.println("你发送消息的用户不在线");
            return;
        }
        socketIOResponse.sendEvent(ioClients,bean);
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        //此处可根据session或Cookie 删除客户端缓存

        System.out.println("关闭连接");
    }
}