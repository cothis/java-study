package Exam;

import java.util.Scanner;

public class Exam05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x, y;

		// 변수 입력
		System.out.println("두 정수를 입력받아 서로 Swap하는 프로그램입니다.");
		System.out.print("첫 번째 정수 x: ");
		x = scanner.nextInt();
		System.out.print("두 번째 정수 y: ");
		y = scanner.nextInt();

		System.out.printf("입력하신 숫자는 x: %d, y: %d입니다.\n", x, y);

		// Swap 1
//		int temp = y;
//		y = x;
//		x = temp;

		// Swap 2
//		x = x + y;
//		y = x - y;
//		x = x - y;

		// Swap 3
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;

		// 결과 출력
		System.out.printf("Swap된 숫자는 x: %d, y: %d입니다.\n", x, y);
		
		scanner.close();
	}
}
