package day006.arrays;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		/*
		 * 1차원 배열
		 * Array : 같은 자료형 변수들의 묶음
		 *         index number로 관리된다.
		 *         int[] arr = new int[배열크기];
		 *                     new int[5] <- 0 ~ 4 인덱스
		 *                     
		 *         int[] arr = new int[3];
		 *         int[] arr = { 1, 2, 3 };
		 *         
		 * String[] member = { "홍길동", "24", "서울시" };
		 * int age = Interger.parseInt(member[1]);
		 * 
		 * 2차원 배열 : 1차원 배열변수들의 배열
		 * 
		 * 선언 및 초기화 방법
		 * int[][] array2 = new int[4][3];  // 4 X 3 사이즈 배열(행4, 열3)
		 * int[][] array2 = {               // 정사각형이 아닐수도 있다. 
		 * 				{1, 2, 3},
		 *              {4, 5, 6}, 
		 *              {7, 8}
		 * };
		 * 
		 */
		
		// Exercise 1
		{
			System.out.println();
			System.out.println("Exercise 1");
			int[][] array = new int[3][];
			int[] row1 = {1,2,3};
			int[] row2 = {4,5,6, 7};
			
			array[0] = row1;
			array[1] = row2;
			array[2] = row1;
			
			System.out.println(Arrays.deepToString(array));
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.printf("array[%d][%d]=%d ", i, j, array[i][j]);
				}
				System.out.println();
			}
		}
		
		// Exercise 2
		{
			System.out.println();
			System.out.println("Exercise 2");
			char[][] cArr = {
					{'A', 'B', 'C'},
					{'D', 'E', 'F'}
			};
			/*
			   cArr[1][1] == 'E'
			   c언어 pointer라면
			   
			   char** cArr
			   *(*(cArr + 1) + 1) == 'E'
			 */
			
			
			for (int i = 0; i < cArr.length; i++) {
				for (int j = 0; j < cArr[i].length; j++) {
					System.out.printf("(%d,%d):%c ", i, j, cArr[i][j]);
				}
				System.out.println();
			}
		}
		
		// Exercise 3
		{
			System.out.println();
			System.out.println("Exercise 3");
			int[][] array2D = new int[3][2];
			array2D[0][0] = 11;
			array2D[0][1] = 12;
			array2D[1][0] = 21;
			array2D[1][1] = 22;
			array2D[2][0] = 31;
			array2D[2][1] = 32;
			for (int i = 0; i < array2D.length; i++) {
				for (int j = 0; j < array2D[i].length; j++) {
					System.out.printf("(%d,%d):%d ", i, j, array2D[i][j]);
				}
				System.out.println();
			}
		}
		
		// alias -> pointer
		{
			System.out.println();
			System.out.println("Alias -> Pointer");
			int[] array = {111, 222, 333};
			int[] alias = array;
			
			for (int i = 0; i < alias.length; i++) {
				System.out.printf("alias[%d]:%d%n", i, alias[i]);
			}
			System.out.println("alias[1] = 200 변경");
			alias[1] = 200;
			
			for (int i = 0; i < alias.length; i++) {
				System.out.printf("array3[%d]:%d%n", i, array[i]);
			}
		}
		
		// foreach : foreach에서는 index를 얻을 수 없다.
		{   // int i를 위해 일부러 블록 생성(변수 scope)
			int i = 0;
			int[] array = {111, 222, 333};
			for (int el : array) {
				System.out.printf("array3[%d]:%d%n", i, el);
				i++;
			}
		}
		
		// 직접 해보기
		{	
			System.out.println();
			System.out.println("직접 해보기");
			// 2차원 선언
			int[][] myArray = new int[3][3];
			// 값을 대입
			int n = 0;
			for (int i = 0; i < myArray.length; i++) {
				for (int j = 0; j < myArray[i].length; j++) {
					myArray[i][j] = n;
					n++;
				}
			}
			// 출력
			System.out.println(Arrays.deepToString(myArray));
		}
		
		// 2차원 배열을 1차원 배열로 변환하기
		{
			System.out.println();
			System.out.println("2차원 배열을 1차원 배열로 변환하기");
			
			int[][] array = new int[2][3];
			int[] array1D = new int[array.length * array[0].length];
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					array[i][j] = (int) (Math.random()*array1D.length);
				}
			}
			// 2D -> 1D
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					array1D[array[i].length * i + j] = array[i][j];
				}
			}
			System.out.println("변환전 2차원 배열: " + Arrays.deepToString(array));
			System.out.println("변환된 1차원 배열: " + Arrays.toString(array1D));
			
			System.out.println("또다른 방법");
			int[] both = null;
			for (int i = 0 ; i < array.length; i++) {
				if(both == null) {
					both = Arrays.copyOf(array[i], array[i].length);
				} else {
					both = Arrays.copyOf(both, both.length + array[i].length);
					System.arraycopy(array[i], 0, both, both.length - array[i].length, array[i].length);
				}
			}
			System.out.println(Arrays.toString(both));
		}
		
		// Array swap 1 : 원소 하나씩 바꾸는 방법.. 비효율적
		{
			System.out.println();
			System.out.println("Array swap 1");
			int[] numberOne = { 1, 2, 3, 4, 5 };
			int[] numberTwo = { 11, 22, 33, 44, 55 };
			for (int i = 0 ; i < numberOne.length; i++) {
				int temp = numberOne[i];
				numberOne[i] = numberTwo[i];
				numberTwo[i] = temp;
			}
			
			for (int i = 0; i < numberOne.length; i++) {
				System.out.print(numberOne[i] + " ");
			}
			System.out.println();
		}
		
		// Array swap 2 : 주소값만 서로 swap
		{
			System.out.println();
			System.out.println("Array swap 2");
			int[] numberOne = { 1, 2, 3, 4, 5 };
			int[] numberTwo = { 11, 22, 33, 44, 55 };
			
			int[] oneNum = numberOne;
			int[] twoNum = numberTwo;
			int[] temp;
			temp = twoNum;
			twoNum = oneNum;
			oneNum = temp;
			
			System.out.print("number one : ");
			for (int i = 0; i < numberOne.length; i++) {
				System.out.print(numberOne[i] + " ");
			}
			System.out.println();
			
			System.out.print("number one(swap) : ");
			for (int i = 0; i < oneNum.length; i++) {
				System.out.print(oneNum[i] + " ");
			}
			System.out.println();
		}
		
		// Sorting(정렬)
		/*
		 * 성능 : java < oracle
		 * Sorting : 정렬
		 *           숫자의 크기에 따라서 순번대로 
		 *           오름차순(1 2 3 4 5), 내림차순(5 4 3 2 1)
		 * Sort의 종류
		 *  - 선택(Selection) 정렬
		 *  - 버블(Bubble) 정렬
		 *  - 합병(Merge) 정렬
		 *  - 퀵(Quick) 정렬
		 *  
		 * 알고리즘의 4대 요소 : 정렬, 셔플, *트리, *탐색 (*: 중요)
		 * 
		 * 
		 */
		
		{
			System.out.println("선택 정렬");
			int[] number = { 3, 2, 5, 4, 1};
			/*
			 *               3  2  5  4  1 (0 - 1)
			 *               2  3  5  4  1 (0 - 2)
			 *               2  3  5  4  1 (0 - 3)
			 *               2  3  5  4  1 (0 - 4)
			 *               1  3  5  4  2 (0 - 5)
			 *               1  3  5  4  2 (1 - 2)
			 *               1  3  5  4  2 (1 - 3)
			 *               1  2  5  4  3 (1 - 4)
			 *               1  2  4  5  3 (2 - 3)
			 *               1  2  3  5  4 (2 - 4)
			 *               1  2  3  4  5 (3 - 4)
			 */
			System.out.println("정렬전 배열: " + Arrays.toString(number));
			
			boolean ascending = true;
			for (int i = 0; i < number.length - 1; i++) {
				for (int j = i + 1; j < number.length; j++) {
					int temp = number[i];
					if((ascending && number[i] > number[j]) || (!ascending && number[i] < number[j])) {
						number[i] = number[j];
						number[j] = temp;
					} 
				}
			}
			
			// 출력
			System.out.println("정렬된 배열: " + Arrays.toString(number));
			
		}
		
		// 자율학습(Quick Sort)
		
	}
}
