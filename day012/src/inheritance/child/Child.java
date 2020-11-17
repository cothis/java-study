package inheritance.child;

import inheritance.parent.Parent;

public class Child extends Parent {
	public Child() {
		System.out.println("ChildClass Constructor()");
	}
	
	public void childMethod() {
		setPrv(12);
		pro = 13;
		pub = 14;
		System.out.println("prv: " + getPrv());
		
		protMethod();
	}
}
