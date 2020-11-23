package day012.override.child;

import day012.override.parent.Parent;

public class Child extends Parent {
		
	@Override
	public void parentMethod() {
		System.out.println("child override");
		System.out.println(super.toString());
		System.out.println(this.toString());
	}
}
