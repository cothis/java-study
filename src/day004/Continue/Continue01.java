package day004.Continue;

import java.util.Scanner;

public class Continue01 {
	public static void main(String[] args) {
		/*
		 * continue : skip
		 * Loop 자체는 종료하지 않고 해당 반복의 뒷 부분을 스킵한다.
		 * 
		 */
		
		for (int i = 0; i < 5; i++) {
			System.out.println("\ni = " + i);
			System.out.println("for start");
			if(i >= 3) continue;
			System.out.println("for end");
		}
		
		int datas[] = { 90, 85, -12, 70 };
		int sum = 0;
		for (int i = 0; i < datas.length; i++) {
			if (datas[i] < 0) {
				continue;
			}
			sum = sum + datas[i];
			System.out.println("sum : " + sum);
		}
		
		// 입력을 받아야 하는 경우 (음수 입력불가)
		Scanner scanner = new Scanner(System.in);
		/*
		// for문의 경우
		int numArr[] = new int[5];
		int num;
		for (int i = 0; i < numArr.length; i++) {
			System.out.printf("(%d/%d)번째 숫자 입력 > ", i+1, numArr.length);
			num = scanner.nextInt();
			if(num < 0) {
				System.out.println("음수입니다.");
				continue;
			}
			numArr[i] = num;
		}
		
		for (int i : numArr) {
			System.out.println("num : " + i);
		}
		/**/
		
		// while문의 경우
		int[] arrNum = new int[5];
		int number;
		int i = 0;
		
		while (i < 5) {
			System.out.print(( i + 1) + "번째 수 : ");
			number = scanner.nextInt();
			
			if(number < 0) {
				System.out.println("음수입니다.");
				continue;
			}
			
			arrNum[i] = number;
			i++;
		}
		for (int j : arrNum) {
			System.out.println("num :" + j);
		}
		
		scanner.close();
	}
}
