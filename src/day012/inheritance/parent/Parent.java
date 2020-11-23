package day012.inheritance.parent;

public class Parent {
	private 	int prv;
	protected 	int pro;
	public 		int pub;
	
	public int getPrv() {
		return prv;
	}

	public void setPrv(int prv) {
		this.prv = prv;
	}

	public Parent() {
		System.out.println("ParentClass Constructor()");
	}
	
	public void parentMethod() {
		System.out.println("ParentClass ParentMethod()");
	}
	
	protected void protMethod() {
		System.out.println("Parent protected method()");
	}
}
