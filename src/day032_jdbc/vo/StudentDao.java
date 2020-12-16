package day032_jdbc.vo;

import java.sql.*;

// DAO(Data Access Object) : 데이터에 접근하는 클래스(DB 연동)- xxxDAO, xxxDao
public class StudentDao {
    final String DRIVER = "oracle.jdbc.OracleDriver";
    final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final String USER = "mystudy";
    final String PASSWORD = "mystudypw";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public StudentDao() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("[예외] Not Found Driver");
            e.printStackTrace();
        }
    }

    //id값을 받아서 DB에서 데이터 조회 후 결과값을 StudentVO에 담아서 리턴하는 메소드
    public StudentVo selectId(String id) {
        StudentVo student = null;
        //DB 연동 작업(SELECT)
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "" +
                    "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG\n" +
                    "FROM STUDENT\n" +
                    "WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new StudentVo();
                student.setId(rs.getString("ID"));
                student.setName(rs.getString("NAME"));
                student.setKor(rs.getInt("KOR"));
                student.setEng(rs.getInt("ENG"));
                student.setMath(rs.getInt("MATH"));
                student.setTot(rs.getInt("TOT"));
                student.setAvg(rs.getDouble("AVG"));
            }

        } catch (SQLException e) {
            System.out.println("[예외] selectID 실패");
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return student;
    }

    // 전달받은 StudentVo 데이터를 DB에 입력
    public int insertData(StudentVo student) {
        int result = 0;

        //DB 연동 작업(vo 데이터 DN에 입력)
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "" +
                    "INSERT INTO STUDENT(ID, NAME, KOR, ENG, MATH, TOT, AVG)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getKor());
            pstmt.setInt(4, student.getEng());
            pstmt.setInt(5, student.getMath());
            pstmt.setInt(6, student.getTot());
            pstmt.setDouble(7, student.getAvg());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("[예외] selectID 실패");
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }

        return result;
    }

    //VO를 전달받아서 DB 데이터 수정(리턴 : 처리건수)
    public int updateData(StudentVo student) {
        int result = 0;

        //DB 연동 작업
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "" +
                    "UPDATE STUDENT\n" +
                    "SET KOR = ?" +
                    ", ENG = ?" +
                    ", MATH = ?" +
                    ", TOT = ?" +
                    ", AVG = ?\n" +
                    "WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student.getKor());
            pstmt.setInt(2, student.getEng());
            pstmt.setInt(3, student.getMath());
            pstmt.setInt(4, student.getTot());
            pstmt.setDouble(5, student.getAvg());
            pstmt.setString(6, student.getId());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }

        return result;
    }

    //ID를 전달받아서 DB 데이터 삭제(리턴 : 처리건수)
    public int deleteData(String id) {
        int result = 0;

        //DB 연동 작업
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "DELETE FROM STUDENT\n" +
                    "WHERE ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt);
        }

        return result;
    }

    private void close(Connection conn, Statement pstmt, ResultSet rs) {
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

    private void close(Connection conn, Statement pstmt) {
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
