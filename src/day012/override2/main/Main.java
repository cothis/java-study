package day012.override2.main;

import day012.override2.child.Child;
import day012.override2.child.Child2;
import day012.override2.parent.Parent;

public class Main {
	public static void main(String[] args) {
	/*
		instanceof
		: instance를 구별하기 위한 키워드
	*/
		
		Parent[] array = new Parent[3];
		array[0] = new Child();
		array[1] = new Child2();
		array[2] = new Child2();
		
		for(int i = 0 ; i < array.length; i++) {
			array[i].method(); // override
			
			// 자식 고유 메소드
			if (array[i] instanceof Child) {
				((Child)array[i]).child1_Method();
			} 
			else if (array[i] instanceof Child2) {
				((Child2)array[i]).child2_Method();
			}
			System.out.println();
		}
		
//		Child c1 = (Child)array[0];
//		c1.child1_Method();
			
		
		
	}
	
}
