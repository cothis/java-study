package this_super.parent;

public class Parent extends Object {
	@SuppressWarnings("unused")
	private int parentNum;
	
	public Parent() {
		System.out.println("Parent()");
	}
	
	public Parent(int parentNum) {
		System.out.println("Parent(int parentNum)");
		this.parentNum = parentNum;
	}
}
