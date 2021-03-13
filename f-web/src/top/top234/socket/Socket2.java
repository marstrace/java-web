package top.top234.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/11 5:50.
 *
 * ********************************
 *
 * @author top234
 *
 *         客户端与服务端持续发送消息
 *
 *         注意:不要使用printWriter.write();方法
 */

public class Socket2 {
}

class Server1 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(23480);
        Socket accept = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        PrintWriter printWriter = new PrintWriter(accept.getOutputStream());

        int count = 0;
        while (true) {
            //接收客户端的消息
            String line = bufferedReader.readLine();
            System.out.println(line);
            if ("bye".equals(line)) {
                break;
            }

            //向客户端发送消息
            //注意:不要使用printWriter.write();方法
            printWriter.println("第" + ++count + "次通信");
            printWriter.flush();
        }

        bufferedReader.close();
        printWriter.close();
    }
}

class Client1 {
    public static void main(String[] args) throws Exception {
//      InetAddress.getLocalHost();//获取本机主机名及IP地址
        Socket socket = new Socket(InetAddress.getLocalHost(), 23481);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String s = in.readLine();
            //向服务端发送消息
            printWriter.println(s);
            printWriter.flush();

            if ("bye".equals(s)) {
                break;
            }
            //接收服务端的消息
            System.out.println(bufferedReader.readLine());
        }

        printWriter.close();
        bufferedReader.close();
    }
}