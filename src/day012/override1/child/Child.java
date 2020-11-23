package day012.override1.child;

import day012.override1.parent.Parent;

public class Child extends Parent {

	@Override
	public void method() {
		System.out.println("Child override");
	}
	
	public void child1Method() {
		System.out.println("child1 method()");
	}
	
}
