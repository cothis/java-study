package day003.Control;

public class For01 {
	public static void main(String[] args) {
		/*
		 * Loop문, 반복문
		 * 지정된 횟수만큼 반복을 처리하는 제어문이다.
		 * 
		 * 숫자는 실행 순서
		 * for (1. 선언 및 초기화; 2. 조건식; 4. 연산식) {
		 *     3. 내용
		 * }
		 */
		
		int n;
		for (n = 0; n < 10; n++) {
			System.out.println("n = " + n);
		}
		System.out.println("n = " + n);
		
		// 1 ~ 10 더하는 프로그램
		int num = 0;
		num = num + 1;
		num = num + 2;
		num = num + 3;
		num = num + 4;
		num = num + 5;
		num = num + 6;
		num = num + 7;
		num = num + 8;
		num = num + 9;
		num = num + 10;
		System.out.println("num = " + num);
		
		// 1 ~ 10 더하는 프로그램(for 문)
		int num1 = 0;
		for (n = 1; n <= 10; n++) {
			num1 = num1 + n;
		}
		System.out.println("num1 = " + num1);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
		}
		
		
		int _num = 0;
		for (; _num < 10;) {
			System.out.println("_num = " + _num);
			_num++;
		}
		
		for (int i = 0, j = 0; i < 10 && j < 10; i++, j++) {
			System.out.println("i = " + i);
			System.out.println("j = " + j);
		}
		
		int n1, n2;
		n1 = 0;
		n2 = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("n1 = " + n1 + ", n2 = " + n2);
			n1++;
			n2++;
		}
		
		// 2중 for문
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("(%d, %d)", i, j);
			}
			System.out.println();
		}
		
		
		/* 1 ~ 100까지 더하는 다른 방법
		int start, end;
		start = 1;
		end = 100;
		int sum = start + end;
		int count = (end - start + 1) / 2;
		int remain = (end - start + 1) % 2;
		int result = sum*count + sum/2*remain;
		System.out.println(result);
		/**/
	}
}
