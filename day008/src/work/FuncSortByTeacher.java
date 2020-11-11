package work;

import java.util.Arrays;
import java.util.Scanner;

public class FuncSortByTeacher {
	public static void main(String[] args) {
		boolean[] up = new boolean[1];
		
		// 입력
		int[] number = inputNumber(up);
		System.out.println(Arrays.toString(number));
		System.out.println("up : " + up[0]);
		
		// 정렬
		sort(number, up[0]);
		
		// 출력
		printResult(number, up[0]);		
		
		// 입력
			// 숫자의 갯수
			// 동적할당
			// 숫자들의 읩력
				// 정상적인 숫자 체크
			// 올림/내림
		
		// 정렬처리
			// 올림/내림
			// 교환
		
		// 결과출력
			// 올림/내림
			// 숫자출력
	}
	
	static void printResult(int[] array, boolean up) {
		if (up) {
			System.out.println("오름차순 정렬입니다.");
		}
		else {
			System.out.println("내림차순 정렬입니다.");
		}
		
		System.out.println(Arrays.toString(array));
	} // end of printResult
	
	static void sort(int[] array, boolean up) {
		for(int i = 0; i < array.length -1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(up) { // 오름차순
					if(array[i] > array[j]) {
						swap(array, i, j);
					}
				}
				else { // 내림차순
					if(array[i] < array[j]) {
						swap(array, i, j);
					}
				}
			} // end of for j
		} // end of for i
	} // end of sort
	
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	static int[] inputNumber(boolean[] upAddress) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자의 갯수 : ");
		int count = sc.nextInt();
		int[] number = new int[count];
		
		int w = 0;
		while(w < number.length) {
			System.out.print((w+1)+"번째 수 : ");
			String numStr = sc.next();
			
			if(isNumber(numStr)) {
				number[w] = Integer.parseInt(numStr);
				w++;
			} else {
				printInputError();
			}
			
		}
		
		// 올림/내림
		while(true) {
			System.out.print("올림(1)/내림(2) : ");
			String udStr = sc.next();
			if(udStr.equals("1") || udStr.equals("2")) {
				upAddress[0] = udStr.equals("1");
				break;
			} else {
				printInputError();
			}
		}
		
		return number;
	}
	
	static void printInputError() {
		System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
	}
	
	static boolean isNumber(String str) {
		// 간단한 구현
		boolean result = true;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c < '0' || c > '9') {
				result = false;
				break;
			}
		}
		return result;
	}
	
}
