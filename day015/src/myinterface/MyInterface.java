package myinterface;

public class MyInterface {
	public static void main(String[] args) {
		/*
			abstract class : 추상 메소드 + 일반 메소드
			interface : only 추상 메소드
						생성 불가
						상속 및 추상 메소드 정의 후, 생성 가능
						변수 선언이 불가능하다.
						다중 상속(implements)이 가능하다.
		 */
		Test test = new Test();
		test.method();
		test.print();
		
		System.out.println();
		
		InterfaceTest interfaceTest = new InterfaceTest() {
			
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("Inline print");
			}
			
			@Override
			public void method() {
				// TODO Auto-generated method stub
				System.out.println("Inline method");
			}
		};
		
		interfaceTest.method();
		interfaceTest.print();
		
	}
}

class Test implements InterfaceTest {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Test print");
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("Test method");
	}
	
	
}


interface InterfaceTest {
	public void print();
	public void method();
}

