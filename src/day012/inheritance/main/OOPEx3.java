package day012.inheritance.main;

import day012.inheritance.child.Child;

public class OOPEx3 {
	public static void main(String[] args) {
	/*
	 	은닉성 : 접근 지정자를 통해서 외부로부터 접근을 차단 또는 허용
	 			private(변수), public(메소드)
	 			
	 	상속성 : 부모클래스(super)에서 기능을 상속하는 것을 의미
	 	 		추가 기입을 할 수 있다.(override)
	 	
	 	다형성 : 상속 후에 여러 형태의 자식클래스를 제작
	 			
 			부모			직사각형
	 		자식	정사각형	마름모	삼각형
	*/
		Child cc = new Child();
		cc.childMethod();
		cc.pub = 15;
		
		
	}
}
