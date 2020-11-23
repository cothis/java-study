package day011.constructor;

public class ConstructorMain {
	/*
	Constructor : 	생성자
					메소드
					return 값이 없다.
					Overload(같은 이름의 함수, 매개변수로 구분)가 가능
					클래스명과 이름이 같다.
					객체 생성 시점에 자동호출된다.
					생략이 가능하며, 생략 시 컴파일러가 자동으로 생성한다.
	
	Destructor	: 	소멸자(C++)
					자바에도 있었으나, 사라졌다.
					반드시 1개(오버로딩 불가)
	*/
	public static void main(String[] args) {
		Test t = new Test();
		t.setNumber(5);
		t.setName("Hello");
		System.out.println(t.getNumber() + ", "+ t.getName());
		
		Test t2 = new Test(10, "Hi");
		System.out.println(t2.getNumber() + ", "+ t2.getName());
		
		final int num = 12; // 변수 -> 상수
		System.out.println(num);
	}
}

class Test {
	private int number;
	private String name;
	
	public Test() {
	}
	
	public Test(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}