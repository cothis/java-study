package day017.baseball.view;

import day010.baseball.Baseball;
import day017.baseball.domain.Batter;
import day017.baseball.domain.Pitcher;
import day017.baseball.domain.Player;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner sc = new Scanner(System.in);

    public String menu() {
        System.out.println("1.추가 2.삭제 3.검색 4.출력 5.저장 6.종료");
        return sc.next();
    }

    public void close() {
        sc.close();
    }

    public Player addForm() {
        System.out.println("입력");
        Player p;

        System.out.println("선수 종류 선택");
        System.out.println("1.투수 2.타자");
        String type = sc.next();
        if(type.equals("1")){
            p = new Pitcher();
        }
        else if (type.equals("2")) {
            p = new Batter();
        }
        else return null;

        inputCommonInfo(p);
        inputTypeInfo(p);

        return p;
    }

    public void inputCommonInfo(Player player) {
        System.out.print("나이 : ");
        player.setAge(sc.nextInt());

        System.out.print("이름 : ");
        player.setName(sc.next());

        System.out.print("키 : ");
        player.setHeight(sc.nextDouble());
    }

    public void inputTypeInfo(Player player) {
        if(player instanceof Pitcher) {
            Pitcher pitcher = (Pitcher) player;

            System.out.print("승리 횟수 : ");
            pitcher.setWin(sc.nextInt());

            System.out.print("패배 횟수 : ");
            pitcher.setLose(sc.nextInt());

            System.out.print("방어율 : ");
            pitcher.setDefence(sc.nextDouble());
        }
        else if (player instanceof Batter) {
            Batter batter = (Batter) player;

            System.out.print("타수 : ");
            batter.setMoundCount(sc.nextInt());

            System.out.print("안타 횟수 : ");
            batter.setHits(sc.nextInt());

            System.out.print("타율 : ");
            batter.setHitRate(sc.nextDouble());
        }
    }


    public int removeForm() {
        System.out.println("삭제");
        System.out.println("삭제할 번호를 입력해주세요");
        return sc.nextInt();
    }

    public String searchForm() {
        System.out.println("검색");
        System.out.println("검색할 이름을 입력해주세요");
        return sc.next();
    }

    public void printPlayer(Player player) {
        System.out.println(player);
    }

    public void printAll(List<Player> players) {
        System.out.println("출력");
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void clearBuffer() {
        sc.nextLine();
    }
}
