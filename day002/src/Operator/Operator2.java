package Operator;

public class Operator2 {
	public static void main(String[] args) {
		// 논리 연산자(true/false)
		
		/*
		 * && AND
		 * || OR
		 * !  NOT
		 * 
		 * 제어문과 같이 사용(if, while, do while)
		 */
		
		/* AND			| OR
		 * 				|
		 * 0 && 0 -> 0	| 0 || 0 -> 0
		 * 0 && 1 -> 0	| 0 || 1 -> 1
		 * 1 && 0 -> 0	| 1 || 0 -> 1
		 * 1 && 1 -> 1	| 1 || 1 -> 1
		 */
		
		int number = 0;
		System.out.println(number > 0 && number < 10); // false AND true
		System.out.println(number > 0 || number < 10); // false OR true
		
		/* NOT
		 * !0 -> 1
		 * !1 -> 0
		 */
		number = 5;
		System.out.println(number == 5);
		System.out.println(number != 5);

		System.out.println(!(number < 5)); // number >= 5
		
		System.out.println(!(number > 5 && number > 10));
						//=> number <= 5 || number <= 10
		
		/* 3항 연산자 (간단한 조건문)
		 * 
		 *  value = (조건) ? 값1 : 값2;
		 *  조건이 참이면 value = 값1;
		 *  조건 거짓이면 value = 값2;
		 */
		
		char c;
		c = (number > 0) ? 'Y' : 'N';
		System.out.println("c = " + c);
		
		int n;
		n = (number > 10) ? 20 : 10;
		System.out.println("n = " + n);
		
		String str;
		str = number > 5 ? "number is greater than 5" : "number is less than or equal to 5";
		System.out.println(str);
	}
}
