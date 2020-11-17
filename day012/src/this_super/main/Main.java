package this_super.main;

import this_super.child.Child;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Child cc = new Child(10, 15);
	}
}
