package day031.jdbc.jdbc2.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManagerDelete {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "mystudy", "mystudypw");

            stmt = conn.createStatement();

            String id = "2020111";

            String sql = String.format("DELETE FROM STUDENT\n" +
                    "WHERE id = '%s'", id);

            int cnt = stmt.executeUpdate(sql);

            System.out.println("처리 건수 = " + cnt);

        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Error");
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
