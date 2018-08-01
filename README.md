# learnsocketio
及时通讯
结合springboot
服务端使用netty-socketio，客户端使用socket.io.js
和java版的客户端socket.io-client
java版客户端登录和发送消息
com.ps.learn.socketio.client.ClientUser1 模拟用户1登录

com.ps.learn.socketio.client.ClientUser2 模拟用户2登录
先运行服务端com.ps.learn.socketio.LearnApplication
然后在运行com.ps.learn.socketio.client.ClientUser2实现用户2登录
在运行com.ps.learn.socketio.client.ClientUser1 实现用户1登录然后发消息给用户2