package day003.Work;

import java.util.Scanner;

/*
 * 임의 숫자를 입력 받고 해당하는 수의 구구단을 출력하는 프로그램을 작성하라.
 */
public class Work16 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("임의의 숫자(1~9)를 입력해주세요.");
		System.out.print("> ");
		int userNumber = scanner.nextInt();
		
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d ", userNumber, i, userNumber * i);				
		}
		System.out.println();
		
		scanner.close();
	}
}
