package day035.datastructure.work;

/*
    1. HashMap<String, Integer> 타입의 변수 map 선언
    2. map에 이름:점수 형태의 데이터를 입력(Scanner로 화면입력)
       예) 홍길동:100, 강감찬:90, 을지문덕:95, 계백:87, 김유신:92
    3. 입력된 데이터를 조회해서 점수의 총점을 tot에 저장
    4. 점수 평균을 avg에 저장(총점을 인원수로 나눈 값)
    5. 결과 출력
    성명   점수
    ------------
    홍길동 100
    강감찬 90
    ....
    ============
    총점:  ???
    평균:  ???
***************************************/

import java.util.*;

public class GradeControlEx {

    public static void main(String[] args) {
        GradeDao gradeDao = new GradeDaoImpl();
        GradeView gradeView = new GradeView(gradeDao);
        gradeView.menu();
    }

}

class MemberVO {
    private final String name;
    private final int score;

    public MemberVO(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

interface GradeDao {

    boolean containsKey(String name);

    void add(String name, int score);

    List<MemberVO> findAll();

    boolean isEmpty();

    int getTot();

    double getAvg();
}

class GradeDaoImpl implements GradeDao {
    private final Map<String, MemberVO> map = new HashMap<>();

    private int tot = 0;

    public boolean containsKey(String name) {
        return map.containsKey(name);
    }

    public void add(String name, int score) {
        MemberVO member = new MemberVO(name, score);
        map.put(member.getName(), member);
        tot += member.getScore();
    }

    public List<MemberVO> findAll() {
        return new ArrayList<>(map.values());
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public int getTot() {
        return tot;
    }

    public double getAvg() {
        return (double)tot / map.size();
    }

}

class GradeView {

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK = "\u001B[30m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_WHITE = "\u001B[37m";

    private final Scanner sc = new Scanner(System.in);
    private final GradeDao gradeDao;

    public GradeView(GradeDao gradeDao) {
        this.gradeDao = gradeDao;
    }

    public void menu() {
        while(true) {
            System.out.println();
            System.out.println(ANSI_YELLOW + "성적 관리 프로그램입니다" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "1. 성적 입력" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "2. 성적 조회" + ANSI_RESET);
            System.out.println(ANSI_RED + "3. 종료" + ANSI_RESET);
            String select = sc.next();
            System.out.println();

            if ("1".equals(select)) {
                insertStudent();
            } else if ("2".equals(select)) {
                printStudents();
            } else if ("3".equals(select)) {
                break;
            }
        }
        System.out.println("사용해주셔서 감사합니다.");
        sc.close();
    }

    private void printStudents() {
        System.out.println(ANSI_YELLOW + "성적 조회 화면입니다." + ANSI_RESET);
        if(gradeDao.isEmpty()) {
            System.out.println(ANSI_RED + "입력된 학생이 존재하지 않습니다." + ANSI_RESET);
        } else {

            System.out.println("성명 \t점수");
            System.out.println("------------------");

            for (MemberVO member : gradeDao.findAll()) {
                String name = member.getName();
                int score = member.getScore();
                System.out.println(ANSI_BLUE + name + " \t" + ANSI_CYAN + score + ANSI_RESET);
            }
            System.out.println("==================");
            System.out.println(ANSI_GREEN + "총점:\t" + gradeDao.getTot());
            System.out.printf("평균:\t%.1f", gradeDao.getAvg());
            System.out.println(ANSI_RESET);
        }
    }

    private void insertStudent() {
        System.out.println(ANSI_YELLOW + "성적 입력 화면입니다." + ANSI_RESET);
        String name = null;
        while(true) {
            System.out.print("이름 : " );
            name = sc.next();
            if(gradeDao.containsKey(name)) {
                System.out.println(ANSI_RED + "이미 존재하는 학생입니다." + ANSI_RESET);
            } else {
                break;
            }
        }

        int score = 0;

        while(true) {
            try {
                System.out.print("점수 : ");
                String scoreStr = sc.next();
                score = Integer.parseInt(scoreStr);
                break;
            } catch (Exception exception) {
                System.out.println(ANSI_RED + "잘못 입력하셨습니다." + ANSI_RESET);
            }
        }
        gradeDao.add(name, score);
    }

}
