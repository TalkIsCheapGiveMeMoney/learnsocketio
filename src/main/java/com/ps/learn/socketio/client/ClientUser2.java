package com.ps.learn.socketio.client;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

import java.net.URISyntaxException;

/**
 * Created by Administrator on 2018/8/1 0001.
 */
public class ClientUser2 {
    public static void main(String args[]) {
        String use2 = "user2";
        Socket socket = null;
        try {
            socket = IO.socket("http://localhost:9098?no=" + use2);

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

            try {
                Thread.sleep(200*1000);
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
