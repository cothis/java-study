package day035.datastructure.work;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//1. main 메소드를 아예 따로 떼서 view라는 클래스로 만들고 main 간소화하는게 좋을듯.
//2. case 3 에서 while문 벗어나서 종료되는게 더 좋음.. boolean변수를 쓰던지..if문으로 바꾸던지..
//   System.exit(0) 강제종료는 지양하자
//3. System.err 어떤 경우엔 그냥 프로그램종료되던데..확인필요..


public class Damyoungs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while(true) {
            System.out.println("== 학생 성적 관리 프로그램 ==");
            System.out.println("\t1. 성적 입력");
            System.out.println("\t2. 성적 조회");
            System.out.println("\t3. 프로그램 종료");

            System.out.print("번호 입력> ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dao.insert();
                    break;

                case 2:
                    dao.select();
                    break;

                case 3:
                    System.out.println("[프로그램을 종료합니다]");
                    sc.close();
                    System.exit(0);
                default:
                    System.err.println("[번호를 잘못 입력하였습니다]");
                    break;
            }
            System.out.println();
        }


    }
}

// 사용하지 않는 setter는 가능한 없는게 좋음
class StudentVO {

    private String name;
    private Integer score;

    public StudentVO(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    // 사용하지 않는 setter 는 가능한 없는게 좋음
    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    // 사용하지 않는 setter 는 가능한 없는게 좋음
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentVO [" + name + ":" + score + "]";
    }

}

// private 설정이 안되있음
// 가능하면 DAO 는 데이터만 처리할 수 있게..입출력은 입출력하는놈(View)가 알아서 하게 해씀 좋겠음
class StudentDAO {

    Scanner sc = new Scanner(System.in);
    StudentVO svo; // 필요가 없음.. 굳이 한다면 로컬변수로 쓰거나 map.put(new StudentVO(svo.getName(), svo))
    Map<String, StudentVO> map = new HashMap<>();
    String name; // 필요가 없음 로컬변수를 쓰자
    Integer score; // 필요가 없음 로컬변수를 쓰자
    Integer tot = 0;
    double avg;


    public void insert() {
        while (true) {
            System.out.print("이름> ");
            name = sc.next();
            if (map.containsKey(name)) {
                System.err.println("[이미 존재하는 데이터입니다]");
            }else {
                break;
            }
        }
        System.out.print("점수> ");
        score = sc.nextInt();
        svo = new StudentVO(name, score);
        map.put(name, svo);
        System.out.println(svo.toString());
    }

    public void select() {
        if (map.isEmpty()) {
            System.err.println("[조회할 데이터가 없습니다]");
            return;
        }
        System.out.println("성명\t점수 ");
        System.out.println("———————");
        for (String key : map.keySet()) {
            System.out.println(key + "\t"
                    + map.get(key).getScore());
            tot = tot + map.get(key).getScore();
        }
        System.out.println("===============");
        avg = tot * 100 / map.size() / 100.0; // 실행 순서 주의
        System.out.println("총점:\t" + tot);
        System.out.println("평균:\t" + avg);
    }
}