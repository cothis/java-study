package test;

import java.util.Arrays;

public class test2 {
	public static void main(String[] args) {
		Tester[] abc = new Tester[5];
		for(int i=0; i < abc.length; i++) {
			abc[i] = new Tester();
			abc[i].a = i;
			abc[i].s = "" + i;
		}
		
		// 객체 깊은 복사
		Tester[] alias;
		alias = new Tester[abc.length];
		
		for(int i=0; i < alias.length; i++) {
			alias[i] = (Tester) abc[i].clone();
		}
		/**/
		
		//alias = Arrays.copyOf(abc, 5); // 안됨
		//System.arraycopy(abc, 0, alias, 0, 5); // 안됨
		alias[3].a = 10;
		alias[3].s = "haha";
		
		System.out.println(Arrays.toString(abc));
		System.out.println(Arrays.toString(alias));
		
		// 기본자료형 깊은 복사
		int[] src = new int[5];
		int[] dest = new int[5];
//		System.arraycopy(src, 0, dest, 0, 5);
//		dest = Arrays.copyOf(src, src.length);
		dest = src.clone();
		dest[3] = 5;
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
		
	}
}

class Tester implements Cloneable{
	int a;
	String s;
	public String toString() {
		return "a: " + a + ", s: " + s;
	}
	public Tester clone() {
		Tester cloned = null;;
		try {
			cloned = (Tester) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
}