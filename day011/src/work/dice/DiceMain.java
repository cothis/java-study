package work.dice;

import java.util.Scanner;

public class DiceMain {
	public static void main(String[] args) {
		DiceController dc = new DiceController();
		dc.rollDices();
		System.out.println("정답: " + dc.getAnswer());
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배팅할 코인 수는?");
		int coin = sc.nextInt();
		dc.setCoin(coin);
		
		while(true) {
			System.out.print("두 주사위의 합은?");
			int userPredict = sc.nextInt();
			if(dc.setUserPredict(userPredict)) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		
		System.out.print("두 주사위의 합은?");
		System.out.println(dc.getAnswer());
		
		if (dc.checkAnswer() > 0) {
			System.out.println("당첨!");
			System.out.println("배당은 " + dc.getBaedang() + "배입니다");
			System.out.println("배당금은 " + dc.getRefund() + "입니다!");
		} else {
			System.out.println("결과 예측에 실패하셨습니다!");
		}
		
		sc.close();
	}
}
