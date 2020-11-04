package Work;
/*
 * 1 ~ 100 사이의 짝수의 합과 홀수의 합을 각각 출력하도록 작성하라.
 */
public class Work17 {
	public static void main(String[] args) {
		int sumOdd = 0;
		int sumEven = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sumEven = sumEven + i;
			} else {
				sumOdd = sumOdd + i;
			}
		}
		
		System.out.println("짝수의 합 : " + sumEven);
		System.out.println("홀수의 합 : " + sumOdd);
	}
}
