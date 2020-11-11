package function;

public class Function {
	public static void main(String[] args) {
		/*
		function 복습
			- 함수 == method
			- 들어가는 값 - > 인자, 인수, parameter, 매개변수(가인수)
			- 나오는 값 -> return 값
		
		나오는 값의 자료형 함수명 (들어가는 값(0개 이상))
		{
			처리 내용
			
			return 나오는 값
		}
		*/

		// 가변 인수 
		// 항상 마지막 인수여야 한다.
		allocParam(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		allocParam(11, 22, 33, 44, 55);
		
		allocFunc("world", 2, 4, 6);
	}
	public static void allocParam(int... num) { // printf("format", arg1, arg2, arg3...)
		int sum = 0;
		
		for(int i = 0 ; i < num.length ; i++) {
			sum = sum + num[i];
		}
		System.out.println("sum:" + sum);
	}
	
	public static void allocFunc(String str, int... num) {
		System.out.println("str: " + str);
		for (int i = 0; i < num.length; i++) {
			System.out.println("num[i] = " + num[i]);
		}
	}
}
