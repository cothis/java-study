package day012.override2.child;

import day012.override2.parent.Parent;

public class Child extends Parent {

	@Override
	public void method() {
		super.method(); // 부모 클래스 메소드
		System.out.println("Child1 override");
	}
	
	public void child1_Method() {
		System.out.println("Child1 고유 method()");
	}
	
}
