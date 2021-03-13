package top.top234.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/11 11:11.
 *
 * ********************************
 *
 * @author top234
 *
 *         使用多线程方式实现多客户端访问服务端
 *
 *         注意:不要使用printWriter.write();方法
 */
public class Socket3 {
}

class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(23481);
        while (true) {
            Socket accept = serverSocket.accept();
            new ResponseThread(accept).start();
        }
    }
}

class Client2 {
    public static void main(String[] args) {
        PrintWriter printWriter = null;
        BufferedReader in = null;
        BufferedReader serverIn = null;
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 23481);
            printWriter = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(System.in));
            serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {

                //向服务端发送信息
                String line = in.readLine();
                printWriter.println(line);
                printWriter.flush();

                if ("bye".equals(line)) {
                    break;
                }
                //接收服务端的信息
                System.out.println("----server say:----" + serverIn.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            printWriter.close();
            try {
                serverIn.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 服务端响应客户端请求的线程类
 */
class ResponseThread extends Thread {
    private Socket client;

    public ResponseThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            printWriter = new PrintWriter(client.getOutputStream());

            while (true) {
                //读取客户端信息
                String line = bufferedReader.readLine();
                System.out.println(line);
                if ("bye".equals(line)) {
                    System.out.println("本次通话结束...");
                    break;
                }
                //向客户端发送信息
                //注意:不要使用printWriter.write();方法
                printWriter.println("本次请求的信息:" + line);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (printWriter != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
