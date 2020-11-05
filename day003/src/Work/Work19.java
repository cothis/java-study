package Work;
/*
 * 다음의 모양이 출력되도록 작성하라.
 * *
 * **
 * ***
 * ****
 * *****
 * ****
 * ***
 * **
 * *
 */
public class Work19 {
	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++) {
			for(int j = 0; j < i && j < 10 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		int array[] = {2, 5, 3, 1, 6, 5};
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i] ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
