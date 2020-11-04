package Work;

/*
 * 구구단을 1단부터 9단까지 출력하는 프로그램을 작성하라.
 */
public class Work15 {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d ", i, j, i * j);				
			}
			System.out.println();
		}
	}
}
