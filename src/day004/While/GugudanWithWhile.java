package day004.While;

public class GugudanWithWhile {
	public static void main(String[] args) {
		// 2중 와일문을 이용한 구구단
		int first, second;
		
		first = 1;
		while(first < 10) {
			second = 1;
			while(second < 10) {
				System.out.printf("%d X %d = %d\t", first, second, first * second);
				second++;
			}
			System.out.println();
			first++;
		}
	}
}
