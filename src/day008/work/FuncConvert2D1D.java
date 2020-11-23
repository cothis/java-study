package day008.work;

import java.util.Arrays;

public class FuncConvert2D1D {
	public static int[] convert2dTo1d(int[][] array) {
		if(array == null || array.length == 0) return null;

		int[] result = null;
		
		for(int i = 0; i < array.length; i++) {
			int targetPos = 0;
			if(result == null) {
				result = new int[array[i].length];
			} else {
				targetPos = result.length;
				result = Arrays.copyOf(result, result.length + array[i].length);
			}
			System.arraycopy(array[i], 0, result, targetPos, array[i].length);
		}
		return result;
	}

	public static void main(String[] args) {
		// 2차원 배열을 1차원 배열로 바꾸는 메소드 구현
		int[][] array2d = {
				{1, 2, 3},
				{2, 4}
		};

		int[] array1d = convert2dTo1d(array2d);
		System.out.println(Arrays.toString(array1d));
	}
}
