package Number;

public class mainClass {
	public static void main(String[] args) {
		/*
		 * 숫자(상수)
		 * 	2진수		: 0, 1
		 * 	8진수		: 0 ~ 7		10(D) -> 8(O)	표기법: 010
		 * 	10진수	: 0 ~ 9
		 * 	16진수	: 0 ~ F		10(D) -> 16(X)	표기법: 0xA
		 * 
		 * 변수(variable) : 그릇(데이터) 크기는 다양하다. 종류도 다르다.
		 *		정수, 실수, 문자, 문자열, 판별
		 *		변수명을 정함.
		 *
		 * 변수 선언
		 * 		자료형 변수명;
		 * 		int number;
		 *  	
		 *  	integer == 정수
		 *  	
		 * 변수 대입
		 *		number = 14;
		 *
		 * 		int number = 15;
		 */
		
		// 변수 작명의 규칙(camelCase)
		int a;		// ASCII code : 알파벳이 숫자로 정의 (0x61)
		a = 123;
		int A;		// ASCII code : 0x41

		// 예약어를 사용할 수 없다.
			// int int;
		
		// 숫자가 앞에 오면 안된다.
			// int 2a;
		
		// 상수는 사용할 수 없다.
			// int 123;
		
		// 연산자도 사용할 수 없다.
			// int abc+;
			// int +abc;
		
		int number_position_char;
		int numberpositionchar;
		int numberPositionChar;
		int numPosChar;
		
		int 변수;
		변수 = 123;
		System.out.println(변수);
		
		int num = 0x56;
		System.out.println("num = " + num);
		
	}
}
