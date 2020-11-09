package Work;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 선언
		Scanner scanner = new Scanner(System.in);
		int[] array;
		boolean ascending;
		
		System.out.println("이 프로그램은 아직 예외처리가 되어 있지 않습니다.");
		
		// user한테 몇개 정렬할지 물어본다.
		System.out.println("몇개 입력하시겠습니까?");
		System.out.print("> ");
		// 개수에 맞게 배열 확보
		array = new int[scanner.nextInt()];
		
		// 숫자 입력 받기(개수만큼)
		for (int i = 0 ; i < array.length; i++) {
			System.out.printf("(%d/%d) 숫자를 입력해주세요%n", i + 1, array.length);
			System.out.print("> ");
			array[i] = scanner.nextInt();
		}
		
		// 올림/내림 선택
		System.out.println("정렬 방법을 선택해주세요.");
		System.out.println("1. 오름차순, 2. 내림차순");
		System.out.print("> ");
		ascending = (scanner.nextInt() == 1);
		
		
		// 정렬
		System.out.println("입력된 배열: " + Arrays.toString(array)); // 정렬 전 배열 출력
		for (int i = 0 ; i < array.length - 1; i++) {
			for (int j = i + 1 ; j < array.length; j++) {
				if((ascending && array[i] > array[j]) || (!ascending && array[i] < array[j])) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		// 결과 출력
		String str = (ascending)? "(오름차순)" : "(내림차순)";
		System.out.println("정렬된 배열: " + Arrays.toString(array) + str);
		
		// 프로그램 종료
		scanner.close();
	}
}
