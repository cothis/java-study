package day032_jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManagerDelete {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "mystudy", "mystudypw");

            String sql = "DELETE FROM STUDENT\n" +
                    "WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);

            String id = "2020111";
            pstmt.setString(1, id);

            int cnt = pstmt.executeUpdate();

            System.out.println(">>>처리 건수 : " + cnt);

        } catch (ClassNotFoundException e) {
            System.out.println("[예외] Driver Not Founded");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("[예외] SQL Exception");
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
        System.out.println(">>> Main 끝!");
    }
}
