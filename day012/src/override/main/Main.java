package override.main;

import override.child.Child;
import override.child.Child2;
import override.child.Child3;
import override.parent.Parent;

public class Main {
	public static void main(String[] args) {
	/*
	 	Override
	 	자식 클래스에서 부모클래스의 메소드를 재정의한다.
	 	prototype(제한자, 리턴타입, 이름, 매개변수)이 같아야 한다.
	*/
		
		//Child c = new Child();
		//c.parentMethod();
		//Parent p = new Child();
		//p.parentMethod();
		
		Child[] arr = new Child[5];
		Child2[] arr2 = new Child2[3];
		
		arr[0] = new Child();
		arr[1] = new Child();
		arr[2] = new Child();
		arr[3] = new Child();
		arr[4] = new Child();
		
		arr2[0] = new Child2();
		arr2[1] = new Child2();
		arr2[2] = new Child2();
		
		Parent[] parentArr = new Parent[8];
		parentArr[0] = new Child();
		parentArr[1] = new Child();
		parentArr[2] = new Child();
		parentArr[3] = new Child();
		parentArr[4] = new Child();
		
		parentArr[5] = new Child2();
		parentArr[6] = new Child2();
		parentArr[7] = new Child3();
		
		for(int i = 0; i < parentArr.length; i++) {
			parentArr[i].parentMethod();
		}
	}
}
