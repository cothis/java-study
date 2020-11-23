package day012.this_super.child;

import day012.this_super.parent.Parent;

public class Child extends Parent {
	@SuppressWarnings("unused")
	private int childNum;
	
	public Child() {
		System.out.println("Child()");
	}
	
	public Child(int childNum, int parentNum) {
	//	this();		// 자기참조 : heap 주소(pointer)
	//	super();	// 부모 클래스의 참조(pointer)
		super(parentNum);
		System.out.println("Child(int childNum)");
		this.childNum = childNum;
	}

}
