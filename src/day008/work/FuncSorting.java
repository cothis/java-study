package day008.work;

import java.util.Arrays;
import java.util.Scanner;

public class FuncSorting {
	public static int validateInputInt(int index) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int number = 0;
		String input;
		
		while(true) {
			System.out.print((index + 1) + "번째 숫자 : ");
			input = sc.next();
			
			boolean error = false;
			for(int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if(c == '-') {
					if(i != 0 || input.length() <= 1) {
						error = true;
						break;
					}
				} else if (c < '0' || c > '9') {
					error = true;
					break;
				}
			}
			if(error) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				break;
			}
		}
		number = Integer.parseInt(input);
		return number;
	}
	
	public static int[] inputNumber(int count) {
		int[] result = new int[count];
		
		int w = 0;
		while(w < count) {
			result[w] = validateInputInt(w);		
			w++;
		}
		

		return result;
	}
	public static int[] sort(int[] array) {
		if(array == null) return null;
		if(array.length == 1) return array;
		
		int[] result = Arrays.copyOf(array, array.length);
		
		for(int i = 0; i < result.length - 1; i++) {
			for(int j = i + 1; j < result.length ; j++) {
				if(result[i] > result[j]) {
					swap(result, i, j);
				}
			}
		}
		
		
		return result;
	}
	public static void swap(int[] array, int srcPos, int destPos) {
		if(array == null) {
			System.out.println("swap 대상 배열이 null입니다.");
			return;
		}
		if(array.length >= srcPos || array.length >= destPos) {
			System.out.println("swap 대상 배열의 길이가 인덱스보다 짧습니다.");
			return;
		}
		
		int temp = array[srcPos];
		array[srcPos] = array[destPos];
		array[destPos] = temp;
		
	}
	
	public static void printResult(String prefix, int[] array) {
		if(array == null) {
			System.out.println("대상 배열이 null입니다.");
			return;
		}
		System.out.println(prefix + " : " + Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		// 숫자 여러개를 입력받고 sorting하는 메소드 구현

		// 입력 부분, 정상적인 숫자 체크
		int[] array = inputNumber(5);
		printResult("Origin", array);

		// 정렬 처리, swap
		int[] sortedArray = sort(array);
		
		// 결과 출력
		printResult("Sorted", sortedArray);
	}
}
