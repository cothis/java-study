package _final;

public class FinalValue {
	// final : 제약
	// 변수, 메소드, 클래스
	public static void main(String[] args) {

		final int MAX = 10; // 변수 -> 상수
		// MAX = 12;
		int num;

		num = MAX;
		
		System.out.println(num);
	}
}

class SuperClass {
	public final void method() {	// override 금지
		
	}
}

class ChildClass extends SuperClass {
	
}
