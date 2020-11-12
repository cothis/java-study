package exception;

public class ExceptionEx01 {
	public static void main(String[] args) {
	/*
		Exception : 예외 (에러가 아니다)
		
		char c = 65;
		int[] array = new int[3] -> 유효 범위 array[0] ~ array[2]
			// array[3] <= 예외
		class Scanner 못찾는 경우
		file  없는 경우
		
		형식:
		try{
			예외1 코드
			예외2 코드
		} catch(예외1클래스 e) {
			특정 예외 메시지 등 처리
		} catch(예외2클래스 e) {
			특정 예외 메시지 등 처리
		} finally {	// 생략 가능
			예외 여부 상관없이 마지막으로 실행
			뒤처리(파일 입출력 중 에러 시, undo)
		}
		
		void func() throws 예외1클래스{
			이 메소드에서 에러 발생 시, 예외1 발생
		}
	 */
		/*
		int[] array = { 1, 2, 3 };
		System.out.println("프로그램 시작");
		
		try {
		//	int a = Integer.parseInt("a");
			for(int i = 0 ; i < 4; i++) {
				System.out.println(array[i]);
			}
			System.out.println("func 종료");
			System.out.println("프로그램 실행 중");
		} catch (ArrayIndexOutOfBoundsException e) {
		//	e.printStackTrace();
			System.out.println("----" + e.getMessage());
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally { // 무조건 실행(위에서 return했어도)
			System.out.println("Finally 종료");
		}
		*/
		
		func1();
		
		System.out.println("프로그램 종료");
	}
	
	static void func() {
		int[] array = { 1, 2, 3 };
		try {
			for(int i = 0 ; i < 4; i++) {
				System.out.println(array[i]);
			}
			System.out.println("func 종료");
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	static void func1() throws ArrayIndexOutOfBoundsException {
		int[] array = { 1, 2, 3 };
		for(int i = 0 ; i < 4; i++) {
			System.out.println(array[i]);
		}
		System.out.println("func 종료");
	}
}
