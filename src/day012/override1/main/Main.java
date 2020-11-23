package day012.override1.main;

import day012.override1.child.Child;

public class Main {
	public static void main(String[] args) {
		/*
		//10명
		Child  c1 = new Child();
		Child2 c2 = new Child2();

		Child[] cArr = new Child[10];
		*/
		
		/*
		Parent p1 = new Child();
		Parent p2 = new Child2();
		
		Child c1 = (Child) p1;
		c1.child1Method();
		*/
		
		Object obj1 = new Child();
		Child c1 = (Child) obj1;
		c1.child1Method();
		
		/*
		Parent[] pArr = new Parent[10];
		pArr[0] = new Child();
		pArr[1] = new Child2();
		pArr[2] = new Child2();
		pArr[3] = new Child2();
		pArr[4] = new Child();
		pArr[5] = new Child();
		pArr[6] = new Child2();
		pArr[7] = new Child2();
		pArr[8] = new Child2();
		pArr[9] = new Child();
		
		for (Parent p : pArr) {
			p.method();
		}
		*/
	}
}
