package Exam;

import java.util.Scanner;

public class Work01 {
	public static void main(String[] args) {
		/*
		 * 편의점
		 * 
		 * 지불해야 금액 : 3,230원 자신의 금액 : 10,000원
		 * 
		 * 거스름돈 : ? 5000원권 몇장 1000원권 몇장 500원 몇개 100원 몇개 50원 몇개 10원 몇개
		 */

		Scanner scanner = new Scanner(System.in);

		System.out.print("지불해야 하는 금액은 얼마입니까 : ");
		int cost = scanner.nextInt();
		System.out.print("가지고 있는 금액은 얼마입니까 : ");
		int money = scanner.nextInt();
		System.out.println("가격 : " + cost + "원, 가진 돈: " + money + "원");
		
		/*
		int cost = 3230;
		int money = 10000;
		*/

		int changeMoney = money - cost;

		int money5000;
		int money1000;
		int money500;
		int money100;
		int money50;
		int money10;

		int nextMoney;

		money5000 = changeMoney / 5000;
		nextMoney = changeMoney % 5000;

		money1000 = nextMoney / 1000;
		nextMoney = nextMoney % 1000;
		// money1000 = (changeMoney % 5000) / 1000 이런식으로도 가능

		money500 = nextMoney / 500;
		nextMoney = nextMoney % 500;

		money100 = nextMoney / 100;
		nextMoney = nextMoney % 100;

		money50 = nextMoney / 50;
		nextMoney = nextMoney % 50;

		money10 = nextMoney / 10;

		System.out.println("잔금은 " + changeMoney + "원 입니다.");
		System.out.println("5000원권 " + money5000 + "장, 1000원권 " + money1000 + "장, " + 
		"500원 " + money500 + "개, 100원 " + money100 + "개, 50원 " + money50 + "개, 10원 " + money10 + "개");

		scanner.close();
	}
}
