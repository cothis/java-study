package Practice;

import Practice.test;

public class SelectionSort {
	public static int sort(int[] array) {
		int count = 0;
		for(int i = 0; i < array.length - 1; i++) {
			int index = i;
			for(int j = i + 1; j < array.length; j++) {
				if (array[index] >= array[j]) {
					index = j;
				}
			}
			if(array[i] != array[index]) {
				int temp = array[i];
				array[i] = array[index];
				array[index] = temp;
				count++;
				test.printArray(array);
			}
		}
		return count;
	}
}
