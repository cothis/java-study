package day031_jdbc.jdbc2.statement;

import java.sql.*;

public class StudentManagerSelect {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //1. 드라이버 로딩
            Class.forName("oracle.jdbc.OracleDriver");

            //2. DB연결 Connection 객체 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "mystudy", "mystudypw");

            //3. Statement 문 생성 및 실행(SQL문 - 쿼리문 실행)
            stmt = conn.createStatement();


            String sql = "SELECT ID, NAME, KOR, ENG, MATH\n" +
                    "FROM STUDENT\n" +
                    "ORDER BY ID";

            rs = stmt.executeQuery(sql);
            //4. 결과에 대한 처리
            while (rs.next()) {
                String str = "";
                str += rs.getString("ID") + "\t";
                str += rs.getString("NAME") + "\t";
                str += rs.getInt("KOR") + "\t";
                str += rs.getInt("ENG") + "\t";
                str += rs.getInt("MATH") + "\t";
                System.out.println(str);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("[예외] 드라이버 로딩 실패!!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("[예외] SQL 에러 발생");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
