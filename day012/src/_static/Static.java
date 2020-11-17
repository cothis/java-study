package _static;

public class Static {
	public static void main(String[] args) {
	/*
		static : 정적
		stack	heap	static	system
		지역변수	동적할당	정적영역
	*/
	//	MyClass m = new MyClass(); // 멤버 변수 생성
	//	m.method(); // 지역 변수 생성 및 메소드 동작 후 삭제
		
		MyClass c = new MyClass();
		c.method();
		c.method();
		c.method();
		
		System.out.println();
		MyClass c2 = new MyClass();
		c2.method();
		
		MyClass.staticMethod();
		
		MyClass c3 = MyClass.getInstance();
		c3.memberVar = 10;
		System.out.println(c3.memberVar);
		
		MyClass c4 = MyClass.getInstance();
		System.out.println(c4.memberVar);
		
	}
}


class MyClass {
	int memberVar;			// 멤버 변수
	static int staticVar;	// 정적 변수 == global(전역)
	
	public MyClass() {
		
	}
	
	public void method() {
		int localVar = 0;	// 지역 변수
		localVar++;
		memberVar++;
		staticVar++;
		System.out.println("lv: " + localVar + ", iv: " + memberVar + ", cv: " + staticVar);
	}
	
	public static void staticMethod() {
		System.out.println("staticMethod() 호출");
		// this super 사용 못함
	}
	
	public static MyClass getInstance() {
		MyClass m = new MyClass();
		return m;
	}
	
}