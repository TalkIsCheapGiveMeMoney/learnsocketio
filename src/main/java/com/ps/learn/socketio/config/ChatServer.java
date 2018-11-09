package com.ps.learn.socketio.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import com.corundumstudio.socketio.store.RedissonStoreFactory;
import com.corundumstudio.socketio.store.StoreFactory;
import com.ps.learn.socketio.service.EventListenner;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/7/21 0021.
 * /继承InitializingBean，使Spring加载完配置文件，自动运行如下方法
 */
@org.springframework.context.annotation.Configuration("chatServer")
public class ChatServer  implements CommandLineRunner {
    @Autowired
    SocketIOServer server;

    @Override
    public void run(String... args) throws Exception {
        server.start();
        System.out.println("启动正常");
    }
}