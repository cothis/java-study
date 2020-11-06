package BuildAndDing;

import java.util.Scanner;

public class GameView {
	Scanner scanner;
	GameController controller;
	
	public GameView() {
		// TODO Auto-generated constructor stub
		scanner = new Scanner(System.in);
		controller = new GameController("user");
		
		System.out.println("반갑습니다. 도리짓고땡 게임입니다.");
		System.out.println("========================");
		
		while(true)
		{
			System.out.println("1. 게임하기");
			System.out.println("2. 종료");
			System.out.print("> ");
			int select = scanner.nextInt();
			if (select == 1) {
				doGame();
			} else {
				break;
			}
		}

		System.out.println("사용해주셔서 감사합니다.");
		scanner.close();
	}
	
	public void doGame() {
		// 돈이 있는지 확인
		if(!controller.useMoney()) {
			System.out.println("돈이 없습니다.");
			return;
		}
		
		// 랜덤 카드 생성 
		controller.makeCards();
		
		// 카드 배분
		controller.giveCards();
		
		// 레이스하실건지?
		System.out.println("추가 배팅 하시겠습니까?");
		System.out.print("(y/n)> ");
		String answer = scanner.next();
		
		// 레이스
		if (answer.toUpperCase().equals("Y")) {
			if (controller.useMoney()) {
				System.out.println("돈이 없습니다.");
			}
		}
		
		// computer 사망여부 확인
		
		
		// 출력
	}
}
