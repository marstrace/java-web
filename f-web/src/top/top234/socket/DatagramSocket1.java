package top.top234.socket;

import java.io.IOException;
import java.net.*;

/**
 * Don't forget to be awesome!
 *
 * Created by LEARNING on 2021/3/12 5:35.
 *
 * ********************************
 *
 * @author top234
 *
 *         UDP网络编程:
 *         DatagramSocket
 *         DatagramPacket
 */
public class DatagramSocket1 {
}

class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(23490);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data).trim());
    }
}

class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] bytes = "awesome forget".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 23490);

        datagramSocket.send(datagramPacket);
    }
}
