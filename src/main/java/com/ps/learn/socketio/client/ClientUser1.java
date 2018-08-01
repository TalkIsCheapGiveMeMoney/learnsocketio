package com.ps.learn.socketio.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.learn.socketio.entity.MsgBean;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

import java.net.URISyntaxException;

/**
 * Created by Administrator on 2018/8/1 0001.
 */
public class ClientUser1 {
    public static void main(String args[]) {
        String use1 = "user1";
        Socket socket = null;
        try {
            socket = IO.socket("http://localhost:9098?no=" + use1);

            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("connect");

                }

            }).on("OnMSG", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    JSONObject obj = (JSONObject)args[0];
                    System.out.println(obj.toString());
                    System.out.println("OnMSG");
                }

            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("EVENT_DISCONNECT");

                }

            });
            socket.connect();

            MsgBean msgBean = new MsgBean();
            msgBean.setFrom(use1);
            msgBean.setTo("user2");
            msgBean.setContent("nnnnn");
            msgBean.setMessageType("txt");
            JSONObject obj = new JSONObject(msgBean);

            socket.emit("broadcast event", obj);

            ObjectMapper objectMapper = new ObjectMapper();
            String mess = null;
            try {
                mess = objectMapper.writeValueAsString(msgBean);
                System.out.println(mess);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            socket.emit("OnMSG",obj);

            try {
                Thread.sleep(20*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean flag = socket.connected();
            System.out.println(flag);

            socket.disconnect();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
