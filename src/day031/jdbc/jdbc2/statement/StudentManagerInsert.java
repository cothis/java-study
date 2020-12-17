package day031.jdbc.jdbc2.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManagerInsert {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            //1. 드라이버 로딩
            Class.forName("oracle.jdbc.OracleDriver");

            //2. DB연결 Connection 객체 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "mystudy", "mystudypw");

            //3. Statement 문 생성 및 실행(SQL문 - 쿼리문 실행)
            stmt = conn.createStatement();

            String id = "2020111";
            String name = "홍길동111";
            int kor = 99;
            int eng = 80;
            int math = 70;

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)\n")
                    .append("VALUES ('")
                    .append(id).append("', '")
                    .append(name).append("', ")
                    .append(kor).append(", ")
                    .append(eng).append(", ")
                    .append(math).append(")");
            System.out.println(sql);
            int cnt = stmt.executeUpdate(sql.toString());

            //4. 결과물에 대한 처리
            System.out.println(">> 입력건수 : " + cnt);

        } catch (ClassNotFoundException e) {
            System.out.println("[예외] 드라이버 로딩 실패!!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("[예외] SQL 에러 발생");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
