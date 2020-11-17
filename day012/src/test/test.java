package test;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Parent p = new Child();
		p.printLength();
		while(true) {
			if(sc.next().equals("y")) {
				break;
			}
		}
		sc.close();
	}
}

class Parent {
	int[] i = new int[150300000];
	public void printLength() {
		System.out.println(i.length);
	}
}

class Child extends Parent {
	public void printLength() {
		System.out.println(this.i.length);
	}
}