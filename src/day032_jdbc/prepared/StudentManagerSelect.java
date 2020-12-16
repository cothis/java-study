package day032_jdbc.prepared;

import day032_jdbc.vo.StudentDao;

import java.sql.*;

public class StudentManagerSelect {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            //1. JDBC 드라이버 로딩
            Class.forName("oracle.jdbc.OracleDriver");

            //2. 데이터베이스 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "mystudy", "mystudypw");

            //3. Statement 문 생성 및 실행(SQL문 - 쿼리문 실행)
            String sql = "SELECT ID, NAME, KOR, ENG, MATH\n" +
                    "FROM STUDENT\n" +
                    "WHERE ID = ?\n" +
                    "ORDER BY ID";

            pstmt = conn.prepareStatement(sql); // SQL 실행 준비 요청
            pstmt.setString(1, "2020111"); // 실행시킬 파라미터 입력
            rs = pstmt.executeQuery();

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
            System.out.println("예외 : Class Not Found");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    }
}
