package work;

import java.util.Arrays;

public class Work {
	public static double getDistance(int x1, int y1, int x2, int y2) {
		double value;
		value = Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2);
		value = Math.sqrt(value);
		return value;
	}
	
	public static int[] shuffle(int[] arr) {
		if(arr.length <= 1) {
			return arr;
		}
		
		boolean[] pos = new boolean[arr.length];
		int[] result = Arrays.copyOf(arr, arr.length);
		int i = 0;
		while (i < arr.length){
			int index = (int) (Math.random() * arr.length);
			if(pos[index] == false && index != i) {
				pos[index] = true;
				int temp = result[i];
				result[i] = result[index];
				result[index] = temp;
				i++;
			}
		}
		return result;
	}
	
	public static int max(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -999999;
		}
		
		int max = arr[0];
		for(int el : arr) {
			if(max < el) {
				max = el;
			}
		}
		
		return max;
	}
	
	public static boolean isNumber(String str) {
		boolean dot = false;
		boolean error = false;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '-') {
				if(i != 0 || str.length() <= 1) {
					error = true;
					break;
				}
			} else if (c == '.') {
				if(dot == false && i != 0 && i != str.length() -1) {
					dot = true;
				}
				else {
					error = true;
					break;
				}
			} else if (c < '0' || c > '9') {
				error = true;
				break;
			}
		}
		return !error;
	}
	
	public static void twice(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = arr[i] * 2;
		}
	}
	
	public static int divide(int num1, int num2, int[] tag) {
		int result = num1 / num2;
		tag[0] = num1 % num2;
		return result;
	}
	
	public static void main(String[] args) {
		int[] temp = null;
		max(temp);
		
		// ex1 distance point
		System.out.println("==========================");
		System.out.println("ex1 distance point");
		double distance = getDistance(1, 1, 2, 2);
		System.out.println("두 점 사이의 거리는 " + distance + "입니다.");
		
		// ex2 shuffle
		System.out.println("==========================");
		System.out.println("ex2 shuffle");
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
		
		// ex3 max
		System.out.println("==========================");
		System.out.println("ex3 max");
		int[] data = { 3, 2, 9, 4, 7};
		System.out.println(Arrays.toString(data));
		System.out.println("최대값: " + max(data));
		
		// ex4 isNumber
		System.out.println("==========================");
		System.out.println("ex4 isNumber");
		String str = "123";
		System.out.println(str+"는 숫자입니까?" + isNumber(str));
		str = "1234o";
		System.out.println(str+"는 숫자입니까?" + isNumber(str));
		
		// ex5 twice
		System.out.println("==========================");
		System.out.println("ex5 twice");
		int[] nums = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(nums));
		twice(nums);
		System.out.println(Arrays.toString(nums));
		
		// ex6 divide
		System.out.println("==========================");
		System.out.println("ex6 divide");
		int num1 = 9;
		int num2 = 2;
		int res;
		int[] tag = new int[1];
		
		res = divide(num1, num2, tag);
		System.out.printf("%d/%d의 몫: %d, 나머지: %d",num1, num2, res, tag[0]);
		System.out.println();
		System.out.println("==========================");
	}
}
