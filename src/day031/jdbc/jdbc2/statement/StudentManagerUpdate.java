package day031.jdbc.jdbc2.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManagerUpdate {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "mystudy", "mystudypw");

            stmt = conn.createStatement();

            String id = "2020111";
            int kor = 30;
            int eng = 50;
            int math = 90;

            String sql = String.format("Update Student\n" +
                    "SET kor = %d, eng = %d, math = %d\n" +
                    "WHERE id = '%s'", kor, eng, math, id);
            int cnt = stmt.executeUpdate(sql);

            System.out.println("처리 건수 = " + cnt);

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found Error");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Error");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
