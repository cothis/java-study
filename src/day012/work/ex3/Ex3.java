package day012.work.ex3;

public class Ex3 {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("x="+c.getX());
	}
}

// 실행 완료 순서(호출순서 반대)
// Parent(200)	부모 x 는 200
// Parent()
// Child(1000)	자식 x 는 1000
// Child()
// 결과 : x=200(왜냐하면 부모의 x가 리턴됨)

class Parent {
	int x = 100;
	Parent() {
		this(200);
		System.out.println("Parent()");
	}
	Parent(int x){
		System.out.println("Parent(int x)");
		this.x = x;
	}
	int getX() {
		return x;
	}
}

class Child extends Parent {
	int x = 3000;
	Child() {
		this(1000);
		System.out.println("Child()");
	}
	Child(int x) {
		System.out.println("Child(int x)");
		this.x = x;
	}
}
