package override.child;

import override.parent.Parent;

public class Child2 extends Parent{
	
	@Override
	public void parentMethod() {
		System.out.println("child2 override");
	}
}
