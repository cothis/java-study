package day003.Work;

/*
 * 1 ~ 1000 사이의 수를 전부 합친 값을 출력하라.
 */

public class Work13 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum = sum + i;
		}
		System.out.println("sum(1, 1000) = " + sum);
	}
}
