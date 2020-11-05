package Practice;

import Practice.*;

public class test {
	public static void printArray(int[] array) {
		for (int i = 0 ; i < array.length; i++) {
			if( i == 0) {
				System.out.print("[ ");
			} else {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		int[] array = { 9, 3, 2, 4, 0, 5, 8, 6, 7, 1 };
		int count;
		System.out.print("처음 Array : ");
		printArray(array);
		
		count = SelectionSort.sort(array);
		
		System.out.println("swap 횟수 : " + count);
		System.out.print("Sort 후 Array :");
		printArray(array);
	}
}
