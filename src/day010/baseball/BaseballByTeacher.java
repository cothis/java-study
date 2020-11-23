package day010.baseball;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballByTeacher {
	int[] r_num;
	int[] u_num;
	boolean clear;
	int count;
	
	// 초기화
	public void init() {
		r_num = new int[3];
		u_num = new int[3];
		clear = false;
		count = 1;
		random();
	}
	
	public void loop() {
		int w = 0;
		while (w < 10) {
			userInput();
			clear = finding();
			
			if(clear) {
				break;
			}
			w++;
			count++;
		}
	}

	// 랜덤 숫자 배열
	public void random() {
		boolean[] swit = new boolean[10];
		int r, w;
		for(int i = 0; i < swit.length; i++) {
			swit[i] = false;
		}
		
		w = 0;
		while (w < 3) {
			r = (int)(Math.random() * 10);
			if (swit[r] == false) {
				swit[r] = true;
				r_num[w] = r + 1;
				w++;
			}
		}
		System.out.println(Arrays.toString(r_num));
	}
	
	// 유저 입력
	public void userInput() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < u_num.length; i++) {
			while(true) {
				try {
					System.out.print((i+1)+"번째 숫자 : ");
					u_num[i] = sc.nextInt();			
					break;
				} catch (Exception e) {
					System.out.println("잘못입력하셨습니다.");
				}
			}
		}
	}
	
	// 판정 strike, ball
	public boolean finding() {
		int strike = 0;
		int ball = 0;
		// strike, ball
		for(int i = 0; i < r_num.length; i++) {
			for(int j = 0; j < u_num.length; j++) {
				if(r_num[i] == u_num[j] && i != j) {
					ball++;
				} else if (r_num[i] == u_num[j] && i==j) {
					strike++;
				}
			}
		}
		if(strike > 2) {
			System.out.println("정답입니다!");
			return true;
		}
		else {
			System.out.println((strike + " strike " + ball + " ball"));
			return false;
		}
	}
	
	// 결과
	public void result() {
		System.out.println(count + "회 시도");
		if(clear) {
			System.out.println("Game Clear!!");
		}
	}
}
