package baseball;

import java.util.Arrays;
import java.util.Scanner;

public class Baseball {
	int[] answerArray;
	int[] userArray;
	int strike;
	int ball;
	
	void init() {
		answerArray = new int[3];
		userArray = new int[3];
		
		game();
	}
	
	void generateAnswerArr() {
		boolean[] batch = new boolean[9];
		int w = 0;
		while(w < answerArray.length) {
			int bIndex = (int)(Math.random() * 9);
			if(batch[bIndex] == false) {
				batch[bIndex] = true;
				answerArray[w] = bIndex + 1;
				w++;
			}
		}
	}

	void inputUserArray() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int w = 0;
		boolean[] checkArray = new boolean[9];
		while(w < 3) {
			System.out.print((w + 1) + "번째 숫자 : ");
			String numStr = sc.next();
			
			boolean isNum = isNumber(numStr);
			if (!isNum) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			int number = Integer.parseInt(numStr);

			boolean inRange = inRange(number, 1, 10);
			if(!inRange) {
				System.out.println("숫자가 범위를 벗어났습니다.");
				continue;
			}
			
			boolean hasNum = hasNumber(checkArray, number - 1);
			if (hasNum) {
				System.out.println("중복된 숫자가 있습니다.");
				continue;
			}
			
			userArray[w] = number;				
			w++;
		}
	}

	boolean inRange(int number, int min, int max) {
		boolean inRange = number >= min && number <= max;
		return inRange;
	}
	
	boolean isNumber(String str) {
		boolean result = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				result = false;
				break;
			}
		}
		
		return result;
	}

	boolean hasNumber(boolean[] checkArray, int number) {
		boolean result = checkArray[number];
		checkArray[number] = true;
		
		return result;
	}

	void compArray() {
		strike = 0;
		ball = 0;
		
		for(int i = 0; i < answerArray.length; i++) {
			for(int j = 0; j < userArray.length; j++) {
				if(answerArray[i] == userArray[j]) {
					if(i == j) {
						strike++;
					} else {
						ball++;
					}
				}
			}
		}
	}

	void printResult() {
		System.out.println(strike + "strike  " + ball + "ball");
	}

	void game() {
		int chance = 0;
		
		generateAnswerArr();
		System.out.println(Arrays.toString(answerArray)); // check random Number(answer)
		
		while(chance < 10) {
			System.out.println((chance + 1) + "번째 시도입니다.");
			
			strike = 0;
			ball = 0;
		
			inputUserArray();
			System.out.println(Arrays.toString(userArray)); // check random Number(user)
			
			compArray();
			
			printResult();
			if(strike == 3) {
				System.out.println("정답입니다. 고생하셨습니다.");
				break;
			} else {
				System.out.println("틀렸습니다.");
			}
			chance++;
		}
	}
}
