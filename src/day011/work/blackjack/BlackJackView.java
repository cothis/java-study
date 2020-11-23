package day011.work.blackjack;

import java.util.Arrays;
import java.util.Scanner;

public class BlackJackView {
	static BlackJackController bjc;
	static Scanner sc;
	public static void main(String[] args) {
		System.out.println("haha");
		sc = new Scanner(System.in);
		bjc = new BlackJackController();
		
		init();
		
		selectLoop();	
		
		printResult();
		
		sc.close();
	}

	private static void printResult() {
		printCards();
		printTotals();
		
		switch (bjc.result()) {
			// 0 : blackjack(21) 1.5배
			// 1 : bust 실패
			// 2 : push 비긴다
			// 3 : player > dealer : 이겼다
			// 4 : player < dealer : 졌다
			case 0: {
				System.out.println("BlackJack!! 축하드립니다.");
				break;
			}
			case 1: {
				System.out.println("bust...패배하셨습니다.");
				break;
			}
			case 2: {
				System.out.println("push. 비겼습니다.");
				break;
			}
			case 3: {
				System.out.println("딜러보다 높습니다. 승리하셨습니다.");
				break;
			}
			case 4: {
				System.out.println("딜러보다 낮습니다. 패배하셨습니다.");
				break;
			}
			default: {
				System.out.println("잘못된 결과입니다.");
				break;
			}
		}
	}

	private static void printTotals() {
		System.out.println("Dealer Total :" + bjc.dealer.getSum());
		System.out.println("Player Total :" + bjc.player.getSum());
	}

	private static void printCards() {
		int[] dealerCards = bjc.dealer.getCards();
		System.out.println("Dealer : " + Arrays.toString(dealerCards));
		int[] playerCards = bjc.player.getCards();
		System.out.println("Player : " + Arrays.toString(playerCards));
	}

	private static void selectLoop() {
		while(true) {
			System.out.println("계속 하시겠습니까?");
			System.out.println("1. hit   2. stay");
			System.out.print("> ");
			int userSelect = sc.nextInt();
			if(userSelect == 1) {
				bjc.draw();
				int[] tmpCards = bjc.player.getCards();
				System.out.println(Arrays.toString(tmpCards));
			} else {
				bjc.player.setStay();
				break;
			}
			
			if(!bjc.player.canChoice()) {
				System.out.println("더이상 hit하실 수 없습니다.");
				break;
			}
		}
		while(bjc.dealer.canChoice()) {
			bjc.draw();
		}
	}

	private static void init() {
		System.out.println("게임 시작하겠습니다.");
		bjc.firstDraw();
		
		System.out.println("당신의 카드");
		int[] cards = bjc.player.getCards();
		System.out.println(Arrays.toString(cards));
	}
}
