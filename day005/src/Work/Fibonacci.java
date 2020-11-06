package Work;

// 앞의 두 수가 1과 1이라면 그담 수는 2가되고 
// 1, 1, 2, 3, 5, 8, 13, 21...
//피보나치 수열의 30번째 수는 무엇인지 계사하는 프로그램

public class Fibonacci {
	final static int TARGET = 30;
	public static void main(String[] args) {
		long prev = 0;
		long answer = 0;
		
		for (int i = 0; i < TARGET; i++) {
			if(i==0) {
				answer = 1;
			} else {
				long temp = answer;
				answer = answer + prev;
				prev = temp;
			}
			System.out.print(answer + ",");						
		}
		
		System.out.println();		
		System.out.println("result:" + answer);
	}
}
