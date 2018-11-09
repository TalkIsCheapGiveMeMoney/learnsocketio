package com.ps.learn.socketio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author:ZhuShangJin
 * Date:2018/6/20
 */
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {

    private int timeout = 5000;

    private String address;

    private String password;
//    连接池大小 默认值：64 连接池最大容量。连接池的连接数量自动弹性伸缩。
    private int connectionPoolSize = 100;
//    最小空闲连接数 默认值：32  最小保持连接数（长连接）。
// 长期保持一定数量的连接有利于提高瞬时写入反应速度。
    private int connectionMinimumIdleSize = 50;

// 连接空闲超时，单位：毫秒）默认值：10000
// 如果当前连接池里的连接数量超过了最小空闲连接数，而同时有连接空闲时间超过了该数值，
// 那么这些连接将会自动被关闭，并从连接池里去掉。时间单位是毫秒。
    private int idleConnectionTimeout = 600000;


    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getConnectionPoolSize() {
        return connectionPoolSize;
    }

    public void setConnectionPoolSize(int connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

    public int getConnectionMinimumIdleSize() {
        return connectionMinimumIdleSize;
    }

    public void setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
        this.connectionMinimumIdleSize = connectionMinimumIdleSize;
    }

    public int getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public void setIdleConnectionTimeout(int idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }
}
