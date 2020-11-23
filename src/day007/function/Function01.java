package day007.function;

import java.util.Arrays;

public class Function01 {
	public static void main(String[] args) {
		/*
		function : 함수, 독립적인 process
		method : class에 소속되어 있는 함수
			   	   복잡한 처리를 간결히 정리할 수 있다.
				   중복된 처리를 정리하고 호출할 수 있다.
		// 형식
		    return값(자료형) 함수명(인수, 인자, Parameter, 가상인수, 매개변수)
		    {
		    	처리
		        return 값 : char, int, double, String.. void
		    }
		
		// 사용 예
		int funcName(char c, double d){
			처리
			return 정수;
		}
		
		// 호출 방법
		int r;
		r = funcName('A', 123.4567);
		*/
		
		func1();
		func2("hello");
		double d = func3();
		System.out.println("d = " + d);
		int r = func4(12.34);
		System.out.println("r = " + r);
		
		// get ASCII Code value
		int asc = func5('A');
		System.out.println("asc = " + asc);
		
		// function parameter array
		int[] array = { 2, 4, 6 };
		func6(array);
		
		// array value changed because of reference variable
		for (int i = 0 ; i < array.length ; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
		}
		
		int[] arr = new int[1];
		arr[0] = 1;
		int n = 1;
		func7(n, arr);
		System.out.println("n = " + n); // n : 1
		System.out.println("arr[0] = " + arr[0]); // arr[0] : 2
		
		int[] arr2 = func8(2);
		System.out.println(Arrays.toString(arr2));
		
		int[] reArray = new int[10];
		func9(2,reArray);
		System.out.println(Arrays.toString(reArray));
		
	}
	
	static void func1() {
		System.out.println("func1 호출");
	}
	
	static void func2(String s) {
		System.out.println("func2 호출 s = " + s);
	}
	
	static double func3() {
		System.out.println("func3 호출");
		return 1.23;
	}
	
	static int func4(double d) {
		System.out.println("func4 호출");
		d = d * 10;
		return (int)d;
	}
	static int func5(char c) {
		System.out.println("func5 호출");
		return (int)c;
	}
	
	static int func6(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			//System.out.println("arr[" + i + "] = " + arr[i]);
			arr[i] = arr[i] / 2;
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
		return 1;
	}
	
	static void func7(int n, int[] arr) {
		n = n * 2;
		arr[0] = arr[0] * 2;
	}
	
	static int[] func8(int n) {
		int[] r_arr = new int[10];
		for (int i = 0; i < r_arr.length; i++) {
			r_arr[i] = (i + 1) * n;
		}
		return r_arr;
	}
	
	static void func9(int n, int[] r_arr) {
		for (int i = 0; i < r_arr.length; i++) {
			r_arr[i] = (i + 1) * n;
		}
	}
	
}
