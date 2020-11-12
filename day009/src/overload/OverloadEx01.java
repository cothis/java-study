package overload;

public class OverloadEx01 {
	public static void main(String[] args) {
		/*
			Over Load : 함수(메소드)명은 같고
						매개 변수의 자료형이나 갯수가 다른 것으로 분류하는 것을 의미한다.
			
			ex)	image draw 메소드
			RGB 메소드 : 배경화면
			RGBA 메소드 : 캐릭터
			
			imageDraw(int x, int y, int a)
			imageDraw(int x, int y)		
		 */
		
		funcName();
		funcName(0);
		funcName('o');
		funcName('o', 0);
		funcName(0, 'o');
	
	}
	
	static void funcName() {
		System.out.println("funcName() 호출");
	}
	
	static void funcName(int i) {
		System.out.println("funcName(int i) 호출");
	}
	
	static void funcName(char c) {
		System.out.println("funcName(char c) 호출");
	}
	
	static void funcName(char c, int i) {
		System.out.println("funcName(char c, int i) 호출");
	}
	
	static void funcName(int i, char c) {
		System.out.println("funcName(int i, char c) 호출");
	}
	
	/* 안되는 경우
	// (매개변수명이 다른 것은 의미가 없다.)
	static void funcName(char c1) {
		
	}
	
	// (return값은 오버로드와 상관이 없다.)
	static int funcName() {
		return 0;
	}
	*/
}
