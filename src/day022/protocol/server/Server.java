package day022.protocol.server;

/*
    Protocol - 통신 규약
    TCP
        : Trasmission Control Protocol
        : 신사적인 프로토콜
        : 전화 ---> 상대방 통신 시작
        : 데이터의 경계가 없다. (전송데이터) 크기가 한정되어 있지 않다
        : 1대1 uni cast
        : 채팅
    UDP
        : User Datagram Protocol
        : 비 연결혈
        : 편지 ---> 지상파 방송
        : 데이터의 경계가 있다
        : 1대1 -> uni cast
        : 1대다 -> board cast
        : 다대다 -> multi cast

    7 Layer(계층)
    1계층 Physical Layer      물리계층
    2계층 Data Link Layer     데이터링크계층(주소를 헤더에 첨부)
    3계층 Network Layer       네트워크계층(IP == 주소 설정)
    4계층 Transport Layer     전송계층(Port 지정)
    5계층 Session Layer       세션계층(세션을 동기화)
    6계층 Presentation Layer  표현계층(보안, 압축, 확장)
    7계층 Application Layer   응용계층(프로그램)
    
    Packet(데이터의 묶음)
        : 제어정보, 데이터 등이 결합된 형태로 전송되는 실제의 데이터
        : TCP/UDP, IP, Port, String, Object

    IP : Internet Protocol == 주소

    Ipv4 : 0 ~ 255. XXX.XXX.XXX.XXX
    Ipv6 :          XXX.XXX.XXX.XXX.XXX.XXX

    자기 자신의 접속 IP : 127.0.0.1

    Port Number
    IP 주소는 internet 에 존재하는 host(PC)를 식별할 수 있으나
    최종 주체인 process(프로그램)를 식별하지 못하기 때문에
    프로세스를 구별하기 위해서 지정된 수치다 ( 0 ~ 1023는 시스템이 사용중이라서 사용불가능 )

    Socket      유닉스(file(write, read))
    통신을 하기 위한 주체(Object)
        : IP, Port, TCP/UDP
        
    통신 순서
        서버                          클라이언트
    1.  Socket 버전 확인               Socket 버전 확인
    2.  Socket 생성                   Socket 생성
    3.  IP, Port 설정(Binding)
    4.  Listen 시작
    5.  Accept                       Connect
                    접속 성공
    6.  Packet(데이터) 송수신
        Receive                      Send
        Send                         Receive

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.*;

public class Server {

    public static Map<Socket, String> member = new HashMap<>();

    public static void main(String[] args) {

        try {
            //문지기 소켓
            ServerSocket socket = new ServerSocket(9000);
            System.out.println("Address : " + socket.getLocalSocketAddress());
            System.out.println("접속 대기중...");
            new PrintMessageThread().start();

            while (true) {
                //IP, Port, Binding, Listen
                // client : 접속된 클라이언트의 정보를 갖고 있는 소켓이다.
                // 담당자 소켓
                Socket client = socket.accept();
                new CreateUserThread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setNickname(Socket socket) throws IOException {
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        pw.println("\n이름을 입력해주세요 : ");
        pw.flush();

        String str = br.readLine();
        pw.println(str + "님 환영합니다.");
        pw.flush();

        for (Socket socket1 : member.keySet()) {
            pw = new PrintWriter(socket1.getOutputStream());
            pw.println(str + "님이 들어오셨습니다.");
            pw.flush();
        }
        member.put(socket, str);
    }

    public static boolean sendSomeone(String sender, String msg) {
        if(msg == null || msg.length() == 0) {
            return false;
        }
        if (msg.charAt(0) == '@') {
            int msgStart = msg.indexOf(' ');
            String targetName = msg.substring(1, msgStart);
            String neiyong = msg.substring(msgStart + 1);

            Optional<Socket> target = Server.member.keySet()
                    .stream().filter(key -> Server.member.get(key).equals(targetName))
                    .findAny();

            String finalMsg = msg.substring(msgStart + 1);

            target.ifPresent(t -> {
                try {
                    PrintWriter pwt = new PrintWriter(t.getOutputStream());
                    pwt.println(sender + "@당신: " + finalMsg);
                    pwt.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            return true;
        } else {
            return false;
        }
    }
}
