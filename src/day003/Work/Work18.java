package day003.Work;
/*
 * 다음의 모양이 출력되도록 작성하라.
 * *****
 * *****
 * *****
 * *****
 * *****
 * *****
 * *****
 * *****
 * *****
 */
public class Work18 {
	public static void main(String[] args) {
		// 방법 1
		System.out.println("방법 1");
		for(int i = 0; i < 9; i++) {
			System.out.println("*****");
		}
		
		// 방법 2
		System.out.println("방법 2");
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
