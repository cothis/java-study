package day010.numberpop;
/*
	숫자 빼기 게임
	Random : 15 ~ 100 -> 1개
	user 입력 범위 : (1 ~ 5)
	user 자기 점수
	계속 빼다가 0과 같거나 작으면 진다.
*/

import java.util.Scanner;

public class PopGame {
	int answer;
	int userNum;
	Scanner sc;
	int userId;
	int[] userScore;
	final boolean DEV = false;
	final int MAX_ANSWER_RANGE = 100;
	final int MIN_ANSWER_RANGE = 10;
	final int NUMBER_OF_USERS = 2;
	final int MAX_USER_RANGE = 10;
	final int MIN_USER_RANGE = 1;
	
	void init() {
		sc = new Scanner(System.in);
		random();
		loopGame();
		printResult();
	}
	
	void random() {
		int multiple = MAX_ANSWER_RANGE - MIN_ANSWER_RANGE + 1;
		answer = (int)(Math.random() * multiple) + MIN_ANSWER_RANGE;
		System.out.println("랜덤 숫자(" + MIN_ANSWER_RANGE + " ~ " + MAX_ANSWER_RANGE+ ")가 생성되었습니다.");
		if(DEV) {
			System.out.println("현재 랜덤 숫자 : " + answer);
		}
		
	}
		
	void loopGame() {
		userId = 1;
		userScore = new int[NUMBER_OF_USERS];
		while(true) {
			input();
			if(check()) {
				break;
			} else {
				System.out.println("user" + userId + "님 통과!");
				System.out.println();
			}
			
			userId++;
			if(userId > NUMBER_OF_USERS) {
				userId = 1;
			}
		}
			
	}

	void input() {
		while(true) {
			try {
				System.out.println("user" + userId + "님 " + MIN_USER_RANGE + " ~ " + MAX_USER_RANGE + " 사이의 숫자를 입력해주세요.");
				System.out.print("> ");
				userNum = sc.nextInt();
				if (userNum >= MIN_USER_RANGE && userNum <= MAX_USER_RANGE) {
					break;
				}
				else {
					System.out.println("범위가 벗어났습니다.");
				}
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.nextLine(); // 버퍼 비우기
			}
		}
	}
	
	boolean check() {
		answer = answer - userNum;
		if(answer > 0) {
			userScore[userId - 1] += userNum;
		} 
		return answer <= 0;
	}
	
	void printResult() {
		System.out.println("user" + userId + "님이 한턱 쏘세요!");
		System.out.println("총 점수는 아래와 같습니다.");
		for(int i = 0 ; i < userScore.length; i++) {
			System.out.println("user" + (i + 1) + " : " + userScore[i] + "점");
		}
	}
	
	void close() {
		System.out.println("프로그램이 종료되었습니다.");
		sc.close();
	}
}
