package override2.child;

import override2.parent.Parent;

public class Child2 extends Parent {

	@Override
	public void method() {
		System.out.println("Child2 override");
	}
	
	public void child2_Method() {
		System.out.println("child2 method()");
	}
	
}
