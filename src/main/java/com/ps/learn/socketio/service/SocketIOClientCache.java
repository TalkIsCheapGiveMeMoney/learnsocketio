package com.ps.learn.socketio.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.ps.learn.socketio.entity.MsgBean;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/7/21 0021.
 * 定义Cache用于保存所有和Web端的连接：
 */
@Service("clientCache")
public class SocketIOClientCache {
    //String：EventType类型
    private Map<String,SocketIOClient> clients=new ConcurrentHashMap<String,SocketIOClient>();

    //用户发送消息添加
    public void addClient(SocketIOClient client,MsgBean msgBean){
        clients.put(msgBean.getFrom(),client);
    }

    //用户连接进来添加用户
    public void addClient(SocketIOClient client,String userId){
        clients.put(userId,client);
    }

    //用户退出时移除
    public void remove(MsgBean msgBean) {
        clients.remove(msgBean.getFrom());
    }

    //获取所有
    public  SocketIOClient getClient(String to) {
        return clients.get(to);
    }
}
