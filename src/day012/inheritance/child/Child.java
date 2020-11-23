package day012.inheritance.child;

import day012.inheritance.parent.Parent;

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
