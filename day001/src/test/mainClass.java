package test;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("test java");

		System.out.println("test java");
		System.out.println("test java");
		System.out.println("test java");
		// 절차지향, 객체지향

		/*
		 * 범위 주석문
		 * 
		 * compile 하지 않는 코드 처리에 대한 기입
		 */

		/*
		 * 프로그램의 실행 순서
		 * 
		 * 1. source code 2. compile(기계어로 번역) -> a : 1011 - link(외부 파일읽기) 3. build(실행파일을
		 * 생성) -> *.exe 4. 실행 (console, App, web)
		 */

		System.out.println("hello Java"); // 줄바꿈
		System.out.print("hello Java");

		System.out.println();

		// 문자열 a ab
		System.out.println("문자열");
		System.out.println('한');
		System.out.println('a');
		System.out.println(1);

		System.out.println(1 + 2);
		System.out.println("1" + 2);
		System.out.println("1" + 2 + 3);
		System.out.println(2 + 3 + "1");

		// 정수(%d) <- 123 출력
		System.out.printf("%d", 123);
		System.out.printf("%c", 'A');
		System.out.printf("%s", "hello");
		System.out.printf("%f", 123.345);

		System.out.println();

		// escape sequence 개행(\n), 백스페이스(\b), 띄어쓰기(\t)
		System.out.printf("%d\n", 234);
		System.out.printf("%s\b\n", "abc");
		System.out.printf("%s\t%d\t%c\n", "hello", 246, 'A');
		System.out.printf("%s\t%d\t%c", "world", 12, 'B');
	}
}
