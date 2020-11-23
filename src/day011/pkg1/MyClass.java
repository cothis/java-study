package day011.pkg1;

public class MyClass{
	private int number; // 클래스 내부에서만 접근 가능
	public String name; // 어디서든 접근 가능
	protected char c;
	
	// getter/setter generate Alt + S + R
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
		// this : 자기 참조 -> 자기 자신의 주소(Heap)
				// 0번째 매개변수로 자기 자신을 가리키는 주소이다.
	}
	
	public MyClass getThis() {
		return this;
	}
	
	public void method() {
		this.number = 12;
	}

	
	// variable 90% private
}
