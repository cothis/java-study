package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
	int[] numArray;
	int[] sortedArray;
	
	public void main() {
		inputNumArray(5);
		printResult("Origin", numArray);
		
		sort();
		
		printResult("Sorted", sortedArray);
	}
	
	public int validateInput(int index) {
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

	void inputNumArray(int count) {
		numArray = new int[count];
		
		int w = 0;
		while(w < count) {
			numArray[w] = validateInput(w);		
			w++;
		}
	}

	void sort() {
		if(numArray == null) return;
		
		sortedArray = Arrays.copyOf(numArray, numArray.length);
		
		for(int i = 0; i < sortedArray.length - 1; i++) {
			for(int j = i + 1; j < sortedArray.length ; j++) {
				if(sortedArray[i] > sortedArray[j]) {
					swap(sortedArray, i, j);
				}
			}
		}
	}
	
	void swap(int[] array, int srcPos, int destPos) {
		if(array == null) {
			System.out.println("swap 대상 배열이 null입니다.");
			return;
		}
		if(array.length <= srcPos || array.length <= destPos) {
			System.out.println("swap 대상 배열의 길이가 인덱스보다 짧습니다.");
			System.out.println("대상길이 : " + array.length + ", srcpos :" + srcPos + ", destpos : " + destPos);
			return;
		}
		
		int temp = array[srcPos];
		array[srcPos] = array[destPos];
		array[destPos] = temp;
	}

	void printResult(String prefix, int[] array) {
		if(array == null) {
			System.out.println("대상 배열이 null입니다.");
			return;
		}
		System.out.println(prefix + " : " + Arrays.toString(array));
	}
}
