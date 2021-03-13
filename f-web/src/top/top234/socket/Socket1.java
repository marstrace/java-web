package top.top234.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/11 4:44.
 *
 * ********************************
 *
 * @author top234
 *
 *         网络编程,基于TCP协议的网络编程,创建服务器,创建连接,客户端发送消息到服务器
 */
public class Socket1 {

}

class Server {
    public static void main(String[] args) throws Exception {
        //ServerSocket,创建服务端对象,并监听8000端口
        ServerSocket serverSocket = new ServerSocket(8000);

        //等待客户到访(等待客户端连接)
        //阻塞等待,有客户访问时才会继续向下执行
        Socket accept = serverSocket.accept();

        //获取输入流,读取客户端发送的数据
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int count;
        if ((count = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, count));
        }
        inputStream.close();
    }
}

class Client {
    public static void main(String[] args) throws IOException {
        //Socket,创建客户端对象,并与ip:localhost 端口:8000 的服务端进行通信(建立连接)
        Socket socket = new Socket("localhost", 8000);

        //从客户端向服务端发送消息
        //获取网络输出流,输出到网络通信管道上
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("awesome!".getBytes());
        outputStream.flush();
        outputStream.close();
    }
}