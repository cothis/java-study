package day022.protocol;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Bug {
    public static PrintWriter pw;
    public static void main(String[] args) throws InterruptedException {

        int[] ipList = {118};
        String[] messages = {"버그 발생", "NullPointerException", "Critical Exception Occurred"};

        String targetIp;
        InetSocketAddress address;
        Socket socket = null;

        while (true) {
            for (int lastIp : ipList) {
                try {
                    targetIp = "192.168.0." + lastIp;
                    for(int port = 1024; port < 5000; port++) {
                        address = new InetSocketAddress(targetIp, 9000);
                        socket = new Socket();
                        socket.connect(address, 1);
                        if(socket.isConnected()) break;
                    }
                    System.out.println("접속" + socket.getPort());
/*
                    pw = new PrintWriter(socket.getOutputStream());

                    pw.println(messages[(int) (Math.random() * messages.length)]);
                    pw.flush();
 */
                    socket.close();
                    break;


                } catch (IOException e) {
                    System.out.println("접속 시도중..");
                }
                Thread.sleep(1000);
            }

        }
    }
}
