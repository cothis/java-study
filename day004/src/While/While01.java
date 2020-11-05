package While;

public class While01 {
	public static void main(String[] args) {
		/*
		 * while (반복문)
		 * do while
		 * 
		 * 형식 :
		 *     for문
		 *     for ( 변수선언및 초기화 ; 조건 ; 연산식) {
		 *         처리
		 *     }
		 * 
		 * 
		 * 
		 * 	   while문
		 *     변수 선언 및 초기화
		 *     while (조건) {
		 *         처리 및 연산식
		 *     }
		 *     
		 *     do while문
		 *     변수선언 및 초기화
		 *     do {
		 *         처리 및 연산식
		 *     } while (조건);
		 */
		
		int w = 0;
		while(w < 10) {
			System.out.println("w: " + w);
			w++;
		}
		
		System.out.println("do while");
		do {
			System.out.println("w: " + w);
			w--;
		} while(w > 0);
		
		/*
		 * initialize : 초기화
		 * loop
		 * release : 메모리 삭제
		 */
		
		// 구구단
		// while 문을 사용하여 출력
	}
}
