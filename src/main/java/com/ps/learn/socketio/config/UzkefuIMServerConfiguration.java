package com.ps.learn.socketio.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import com.corundumstudio.socketio.store.HazelcastStoreFactory;
import com.corundumstudio.socketio.store.StoreFactory;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.annotation.PreDestroy;

@org.springframework.context.annotation.Configuration  
public class UzkefuIMServerConfiguration {

    private SocketIOServer uzkefuImServer;
    @Autowired
    HazelcastInstance hazelcastInstance;

    
    @Bean(name = "uzkefuImServer")
    public SocketIOServer socketIOServer(){
    	Configuration config = new Configuration();
		config.setPort(9098);
        StoreFactory hazelcastStoreFactory = new HazelcastStoreFactory(hazelcastInstance);
        config.setStoreFactory(hazelcastStoreFactory);
		config.setWorkerThreads(100);
		config.getSocketConfig().setReuseAddress(true);
		config.getSocketConfig().setSoLinger(0);
		config.getSocketConfig().setTcpNoDelay(true);
		config.getSocketConfig().setTcpKeepAlive(true);
		
        return uzkefuImServer = new SocketIOServer(config);
    }
    
    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {  
        return new SpringAnnotationScanner(socketServer);  
    }  
    
    @PreDestroy  
    public void destory() {
        uzkefuImServer.stop();
	}
}  