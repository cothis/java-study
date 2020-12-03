package day022.protocol.client;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

/*
    1. 접속을 해야할 서버 주소를 설정
    2. 소켓 생성
    3. 접속
    4. 데이터 송수신
*/
public class Client {

    public static void main(String[] args) throws IOException {

        InetSocketAddress socketAddress = new InetSocketAddress("192.168.0.136", 9000);
        Socket socket;


        socket = new Socket();
        PrintWriter pw = null;
        BufferedReader br = null;

//            InetAddress inetAddress;
//            if ((inetAddress = socket.getInetAddress()) != null) {
//                System.out.println("Server 접속 성공 : " + inetAddress + ":" + socket.getLocalPort());
//            } else {
//                System.out.println("Server 연결 실패");
//            }

        try {
            socket.connect(socketAddress, 5000);
            //접속
            new ClientReceiveThread(socket).start();

            Scanner sc = new Scanner(System.in);
            while (true) {
                String msg = sc.nextLine();

                //send
                pw = new PrintWriter(socket.getOutputStream());
                pw.println(msg); //실질적으로 전송
                pw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();

            assert br != null;
            br.close();
            pw.close();
            socket.close();
        }


    }
}
