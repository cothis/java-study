package Array;

public class Array01 {
	public static void main(String[] args) {
		/*
		 * Array : 배열
		 *         변수의 확장 기능
		 *         정의: 같은 자료형 변수의 묶음
		 *         
		 * int number;
		 * int charPosNum;
		 * 
		 * 관리 요소 : index number == 숫자
		 *          0 ~ (n - 1) n: 배열의 갯수
		 *          
		 * int num1, num2, num3, num4, num5;
		 * 
		 * int num[] = new int[5];
		 * 
		 * 형식 : 
		 * 		자료형 배열변수명[] = new 자료형[크기];
		 *   	int array[] = new int[10];
		 *                    new : 동적할당
		 *                    delete : 할당삭제(구버전) delete[] array
		 *                             Garbage Collector가 자동적으로 삭제해준다.
		 * 
		 * stack		heap		static			sys
		 * local변수		동적할당		전역변수 및 정적변수
		 * array[]		new int[10]
		 * 
		 * 정적(static) 할당 : 정해진 만큼
		 * 동적(dynamic) 할당 : 원하는 만큼
		 * 
		 * array[인덱스]
		 * 
		 * int array[] = new int[10];
		 * array[0]
		 * array[1]
		 * array[2]
		 *   :
		 * array[9]
		 * 
		 * 초기화
		 * (O) int num = 12;
		 * 
		 * (O) int num;
		 *     num = 12;
		 * 
		 * (O) int array[] = {1, 2, 3};
		 * 
		 * (X) int array[];
		 *     array = {1, 2, 3};
		 * 
		 */
		
		// 아래 3가지 모두 동일
		// int array[] = new int[3];
		// int []array = new int[3];
		int[] array = new int[3];
		
		array[0] = 11;
		array[1] = 22;
		array[2] = 33;

		@SuppressWarnings("unused")
		int array1[] = { 111, 222, 333 };
		
		/* 안되는 경우
		int array2[];
		array2 = {111,222,333};
		/**/
		
		/* 가능한 경우
		int array2[];
		array2 = new int[3];
		array2[0] = 111;
		array2[1] = 222;
		array2[2] = 333;
		/**/
		
		/* Local 변수 초기화 안되있는 에러 발생
		int num;
		System.out.println(num);
		/**/
		
		/* No Error. 0으로 초기화 해준다.
		int array2[];
		array2 = new int[3];
		array2[0] = 1;
		
		System.out.println(array[1]);
		*/
		
		int array3[] = null;	// null -> (0x00000000)
		System.out.println(array3);
		
		char charArr1[] = new char[5];
		charArr1[0] = 'h';
		charArr1[1] = 'e';
		charArr1[2] = 'l';
		charArr1[3] = 'l';
		charArr1[4] = 'o';
		
		System.out.println(charArr1.length);
		
		System.out.println(charArr1);
		
		System.out.println(charArr1[0]);
		System.out.println((int)charArr1[0]); // ASCII code
		
	}
}
