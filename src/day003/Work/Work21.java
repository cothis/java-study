package day003.Work;

/*
 * 유저로부터 입력 받은 수들의 합계와 평균을 구하는 프로그램을 작성하라.
 * 연산하고 싶은 숫자 개수
 * 배열 동적 할당
 * 개수에 맞게 숫자 입력
 * 합계 연산
 * 평균 연산
 * 결과 출력
 */

import java.util.Scanner;

public class Work21 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("입력하실 숫자의 갯수를 입력해주세요.");
		System.out.print("> ");
		int arrayCount = scanner.nextInt();
		
		int array[] = new int[arrayCount];
		int sum = 0;
		double average = 0;
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("(%d/%d)번째 숫자를 입력해주세요.\n", i + 1, array.length);
			System.out.print("> ");
			array[i] = scanner.nextInt();
			sum = sum + array[i];	// 합계 미리 계산
		}
		
		// 평균 계산
		average = sum / (double) array.length;
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + average);
		
		System.out.println("감사합니다.");
		scanner.close();
	}
}
