package top.top234.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/11 13:22.
 *
 * ********************************
 *
 * @author top234
 *
 *         服务器端实现消息群发
 */
public class Socket4 {

}

class Server3 {
    public static void main(String[] args) throws Exception {
        HashSet<Socket> sockets = new HashSet<>();
        ServerSocket serverSocket = new ServerSocket(23482);
        while (true) {
            Socket accept = serverSocket.accept();
            synchronized (Server3.class) {
                sockets.add(accept);
            }
            new ServerThread(accept, sockets).start();
        }
    }
}

class C1 {
    public static void main(String[] args) {
        Client3.client();
    }
}

class C2 {
    public static void main(String[] args) {
        Client3.client();
    }
}

class C3 {
    public static void main(String[] args) {
        Client3.client();
    }
}

class Client3 {
    public static void client() {
        PrintWriter printWriter = null;
        BufferedReader in = null;
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 23482);
            printWriter = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(System.in));

            ClientListener clientListener = new ClientListener(socket);
            clientListener.start();

            while (true) {

                //向服务端发送信息
                String line = in.readLine();
                printWriter.println(line);
                printWriter.flush();

                if ("bye".equals(line)) {
                    //在关闭本次通信前手动关闭当前客户端用来接收服务端信息的线程
                    clientListener.setStatus(false);
                    //clientListener.stop();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.close();
        }
    }
}

/**
 * 服务端处理客户端请求的线程
 */
class ServerThread extends Thread {
    private Socket client;
    /**
     * 服务端维护一个客户端的Socket对象的set集合
     */
    private Set<Socket> socketSet;

    public ServerThread(Socket client, Set<Socket> socketSet) {
        this.client = client;
        this.socketSet = socketSet;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while (true) {
                //读取客户端信息
                String line = bufferedReader.readLine();
                System.out.println(line);
                if ("bye".equals(line)) {
                    System.out.println("本次通话结束...");
                    //删除set集合中的当前客户端socket对象
                    synchronized (Server3.class) {
                        socketSet.remove(client);
                    }
                    break;
                }

                //向set集合中的所有客户端发送消息
                //注意:不要使用printWriter.write();方法
                synchronized (Server3.class) {
                    for (Socket s : socketSet) {
                        if (s == client)
                            continue;
                        PrintWriter clientSend = new PrintWriter(s.getOutputStream());
                        clientSend.println(line);
                        clientSend.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 客户端接收服务端信息的线程
 */
class ClientListener extends Thread {
    private Socket socket;

    /**
     * 用于在外部改变当前线程的状态,true正常 false结束
     */
    private boolean status = true;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ClientListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //使用独立线程的方式接收服务端发送的消息
        BufferedReader serverIn = null;
        try {
            serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            if (!status)
                break;
            try {
                System.out.println(serverIn.readLine());
            } catch (IOException e) {
                break;
            }
        }
    }
}