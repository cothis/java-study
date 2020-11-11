package work;

import java.util.Arrays;
import java.util.Scanner;

public class FuncBaseballByTeacher {
	public static void main(String[] args) {
		
		int[] r_num = null;
		boolean clear;
		
		// initialize
		clear = false;
			// random
		r_num = random();
		System.out.println(Arrays.toString(r_num));

		// loop
			// user input
			// finding
			// message
		clear = loop(r_num);
		
		// release message
		resultPrint(clear);
	}
	
	static void resultPrint(boolean clear) {
		if (clear) {
			System.out.println("Game Clear!!!");
		} else {
			System.out.println("Game Over~~~");
		}
	}
	
	static boolean loop(int[] r_num) {
		int strike = 0;
		int ball = 0;
		int[] u_num = new int[3];
		boolean clear = false;
		int w = 0;
		// loop
		while(w < 10) {
			// user input
			userInput(u_num);
			
			// find
			strike = strikeCheck(u_num, r_num);
			ball = ballCheck(u_num, r_num);
			
			if(strike == 3) {
				clear = true;
				break;
			}
			
			// message
			System.out.println(strike + " strike  " + ball + " ball");
			w++;
		}
		
		return clear;
	}
	
	static int ballCheck(int[] u_num, int[] r_num) {
		int ball = 0;
		for (int i = 0; i < r_num.length; i++) {
			for (int j = 0; j < r_num.length; j++) {
				if(u_num[i] == r_num[j] && i != j) {
					ball++;
				}
			}
		}
		return ball;
	}
	
	static int strikeCheck(int[] u_num, int[] r_num) {
		int strike = 0;
		for (int i = 0; i < r_num.length; i++) {
			if(u_num[i] == r_num[i]) {
				strike++;
			}
		}
		return strike;
	}
	
	static void userInput(int u_num[]) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			for(int i = 0; i < u_num.length; i++) {
				System.out.print((i+1) + "번째 수 : ");
				u_num[i] = sc.nextInt();
			}
			if(u_num[0] != u_num[1] && 
					u_num[0] != u_num[1] && 
					u_num[1] != u_num[2]) {
				break;
			}
			System.out.println("같은 숫자를 입력하셨습니다. 다시 입력하세요.");
		}
	}
	
	static int[] random() {
		boolean[] swit = new boolean[10];
		int[] r_num = new int[3];
		int r;
		int w = 0;
		
		while(w < 3) {
			r = (int) (Math.random() * 10);
			if(swit[r] == false) {
				swit[r] = true;
				r_num[w] = r + 1;
				w++;
			}
		} // end of while
		return r_num;
	}
}
