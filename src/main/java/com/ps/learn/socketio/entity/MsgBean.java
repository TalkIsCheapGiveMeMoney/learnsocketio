package com.ps.learn.socketio.entity;

/**
 * Created by Administrator on 2018/7/21 0021.
 */
public class MsgBean {
    private String from;
    private String to;
    private String content;
    private String messageType;//用来区分文字消息和图片消息

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MsgBean [from=" + from + ", to=" + to + ", content=" + content + "]";
    }
}
