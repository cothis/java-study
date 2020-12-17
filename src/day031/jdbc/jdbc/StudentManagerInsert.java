package day031.jdbc.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManagerInsert {

    public static void main(String[] args) {
//        0. JDBC 라이브러리 사용 개발환경 설정(jdbc.jar 빌드패스 등록)
//        1. JDBC 드라이버 로딩
//        2. DB연결하고 Connection 객체 생성
//        3. Statement 문 생성 및 실행(SQL문 - 쿼리문 실행)
//        4. 결과물에 대한 처리
//                - SELECT : 조회 데이터 결과값 처리
//        - INSERT/UPDATE/DELETE : INT 값(처리 건수) 처리
//        5. 클로징 처리에 의한 자원 반납

        //1. JDBC 드라이버 로딩
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("[예외] 드라이버 로딩 실패!!");
            e.printStackTrace();
        }

        //2. DB연결하고 Connection 객체 생성
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "mystudy",
                    "mystudypw");
        } catch (SQLException e) {
            System.out.println("[예외] DB연결 실패(connection fail)");
            e.printStackTrace();
        }

        //3. State문 생성 및 실행(SQl - 쿼리문 실행)
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)\n");
            sql.append("VALUES ('2020001', '홍길동1', 100, 88, 77)");

            //INSERT, UPDATE, DELETE : executeUpdate() 사용
            int cnt = stmt.executeUpdate(sql.toString());

            //4. 결과물에 대한 처리
            System.out.println(">> 입력건수 : " + cnt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //5. 클로징 처리에 의한 자원 반납
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println(">>> main() 끝");
    }
}
