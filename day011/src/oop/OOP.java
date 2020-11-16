package oop;

import pkg1.MyClass;

public class OOP {
	/*
	Object Oriented Programming
	
	*절차지향*		|	*객체지향(분산처리)*
				|
	초기화(변수)	|
	처리 1		|	처리1, 처리2, 처리3
	처리 2		|
	처리 3		|
	결과			|
				|
				|	class
				|	변수, 메소드
				
	객체지향의 성질
	1. 은닉성(캡슐화)
	 : 외부와의 접근 차단으로 변수들을 관리할 수 있다.
	 : 클래스의 내부에서 접근을 제어하도록 접근제한자로 지정한다.
	 : 접근지정자 리스트
	   -. private (개인적인) => 클래스 자신만 접근 가능 => 대부분 멤버변수
	   -. public (대중적인) => 아무나 접근 가능 => 멤버메소드
	   -. protected (보호된) => 같은 패키지 + 상속된 클래스 접근 가능
	2. 상속
	3. 다형성	 
	
	*/
	public static void main(String[] args) {
		MyClass cls = new MyClass();
		cls.name = "홍길동";
		cls.setNumber(12);
		int n = cls.getNumber();
		System.out.println(n);
		
		System.out.println("cls heap 주소:" + cls);
		System.out.println("cls.this:" + cls.getThis());
		
		MyClass mcls = new MyClass();
		System.out.println("mcls heap 주소:" + mcls);
		
	}
}
