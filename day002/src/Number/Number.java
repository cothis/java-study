package Number;

public class Number {
	public static void main(String[] args) {
		int num1;	// local(지역) variable, auto
		
		{
			int num2;	// local(지역) variable
			num1 = 23;	// memory : stack, heap, static, sys
						// 로컬 변수는 stack에 저장된다.(선언 시)
		}
		
		num1 = 24;
		// num2 = 23;	// 변수 scope 벗어남
		
		// 변수
		// 숫자형
		byte b;					// 1 byte
		short s;				// 2 byte
		int i;					// 4 byte
		long l = 12L;			// 8 byte
		
		float f = 123.456F;		// 4 byte
		double d;				// 8 byte
		
		/*
		 * app(window) == web(browser)
		 * 
		 * 관리 프로그램
		 * oracle <- java -> web(html, javascript, css)
		 *                   JSP -> Vue, React
		 * 
		 */
		
		// 문자형
		char c = '한';			// 2 byte
		String str = "Hello";	// Wrapper Class
		String str1 = new String("Hello");	// 위와 동일, 다만 객체 주소값은 다름. 리터럴은 공통 pool에 저장되나, new String은 Heap에 저장됨
		str = str + " world";	// == str.concat(" world")
		
		// 논리형
		boolean b1 = true;	// 1
		b1 = false;			// 0
	}
}
