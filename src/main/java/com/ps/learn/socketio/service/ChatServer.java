package com.ps.learn.socketio.service;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/21 0021.
 * /继承InitializingBean，使Spring加载完配置文件，自动运行如下方法
 */
@Service("chatServer")
public class ChatServer  implements InitializingBean {
    @Resource
    private EventListenner eventListenner;
    public void afterPropertiesSet() throws Exception {
        Configuration config = new Configuration();
        config.setPort(9098);

        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);
        socketConfig.setTcpNoDelay(true);
        socketConfig.setSoLinger(0);
        config.setSocketConfig(socketConfig);
        config.setHostname("localhost");

        SocketIOServer server = new SocketIOServer(config);
        server.addListeners(eventListenner);
        server.start();
        System.out.println("启动正常");
    }
}