package com.ps.learn.socketio.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.ps.learn.socketio.entity.MsgBean;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/7/21 0021.
 * 定义Cache用于保存所有和Web端的连接：
 */
@Service("clientCache")
public class SocketIOClientCache {
    //String：EventType类型
    private Map<String,SocketIOClient> clients=new ConcurrentHashMap<String,SocketIOClient>();
    @Autowired
    RedissonClient redissonClient;
    @Autowired
    SocketIOServer server;

    //用户发送消息添加
    public void addClient(SocketIOClient client,MsgBean msgBean){
        RMap<String,String> rMap = redissonClient.getMap("11");
        rMap.put(msgBean.getFrom(),client.getSessionId().toString());
        clients.put(msgBean.getFrom(),client);
    }

    //用户连接进来添加用户
    public void addClient(SocketIOClient client,String userId){
        RMap<String,String> rMap = redissonClient.getMap("11");
        rMap.put(userId,client.getSessionId().toString());
        clients.put(userId,client);
    }

    //用户退出时移除
    public void remove(MsgBean msgBean) {
        clients.remove(msgBean.getFrom());
    }

    //用户退出时移除
    public void remove(String num) {
        clients.remove(num);
    }

    //获取所有
    public  SocketIOClient getClient(String to) {
        RMap<String,String> rMap = redissonClient.getMap("11");
        String uuid = rMap.get(to);
        SocketIOClient client = server.getClient(UUID.fromString(uuid));
        return  client;
//        return clients.get(to);
    }
}
