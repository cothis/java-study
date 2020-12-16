package day032_jdbc.prepared;

import java.sql.*;

public class StudentManagerInsert {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1. 드라이버 로딩
            Class.forName("oracle.jdbc.OracleDriver");

            //2. DB연결 Connection 객체 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "mystudy", "mystudypw");

            //3. Statement 문 생성 및 실행(SQL문 - 쿼리문 실행)

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH)\n")
                    .append("VALUES (?, ?, ?, ?, ?)");
            System.out.println(sql);
            pstmt = conn.prepareStatement(sql.toString());

            String id = "2020002";
            String name = "홍길동002";
            int kor = 99;
            int eng = 80;
            int math = 70;

            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, kor);
            pstmt.setInt(4, eng);
            pstmt.setInt(5, math);

            int cnt = pstmt.executeUpdate();

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
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main 끝");
    }
}
