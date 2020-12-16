package day032_jdbc.vo;

public class StudentDaoTest {

    public static void main(String[] args) {

        StudentDao dao = new StudentDao();
        System.out.println("===데이터 조회 테스트===");
        StudentVo svo = dao.selectId("2020112");
        System.out.println("dao.selectId(\"2020112\") : " + svo);

        //데이터 입력 테스트
        System.out.println("===데이터 입력 테스트===");
        StudentVo student = new StudentVo("2020112", "홍길동112", 90, 80, 70);
        int result = dao.insertData(student);
        System.out.println("처리건수 : " + result);

        //데이터 수정 테스트
        System.out.println("===데이터 수정 테스트===");

        StudentVo studentUpd = dao.selectId("2020112");
        System.out.println(">>>변경전 : " + studentUpd);

        studentUpd.setKor(59);
        result = dao.updateData(studentUpd);
        System.out.println("업데이트 건수 : " + result);

        studentUpd = dao.selectId("2020112");
        System.out.println(">>>변경후 : " + studentUpd);

        //데이터 삭제 테스트
        System.out.println("===데이터 삭제 테스트===");
        
        StudentVo studentDel = dao.selectId("2020112");
        System.out.println(">>>삭제전 : " + studentDel);

        result = dao.deleteData("2020112");
        System.out.println("삭제 건수 : " + result);

        studentDel = dao.selectId("2020112");
        System.out.println(">>>삭제후 : " + studentDel);

    }
}
