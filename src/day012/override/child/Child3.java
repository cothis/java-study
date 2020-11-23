package day012.override.child;

import day012.override.parent.Parent;

public class Child3 extends Parent {
	@Override
	public void parentMethod() {
		System.out.println("child3 override");
	}
}
