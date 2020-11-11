package work;

import java.awt.print.Printable;
import java.util.Arrays;
import java.util.Scanner;

//baseball
/*
*  1 ~ 10
*  
*  7 3 5
*  1 2 3	<- 			1 ball
*  2 3 7	<- 1 strike	1 ball
*  7 3 6	<- 2 strike
*  
*  랜덤 숫자 3개, 달라야 한다.
*  유저로부터 입력받은 숫자도 전부 달라야 한다.
*  
*  횟수 제한은 10회의 기회
*/

public class FuncBaseball {
	static void genRanNumArr(int[] rNumArray) {
		boolean[] batch = new boolean[9];
		int w = 0;
		while(w < rNumArray.length) {
			int bIndex = (int)(Math.random() * 9);
			if(batch[bIndex] == false) {
				batch[bIndex] = true;
				rNumArray[w] = bIndex + 1;
				w++;
			}
		}
	}
	
	static void inputUserNumArr(int[] uNumArray) {
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
			
			uNumArray[w] = number;				
			w++;
		}
	}
	
	static boolean inRange(int number, int min, int max) {
		boolean inRange = number >= min && number <= max;
		return inRange;
	}
	
	static boolean isNumber(String str) {
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
	
	static boolean hasNumber(boolean[] checkArray, int number) {
		boolean result = checkArray[number];
		checkArray[number] = true;
		
		return result;
	}
	
	static int[] compArray(int[] answerArray, int[] userArray) {
		int[] result = new int[2]; // strike, ball
		int strike = 0;
		int ball = 0;
		
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
		result[0] = strike;
		result[1] = ball;
		
		return result;
	}
	
	static void printResult(int[] result) {
		System.out.println(result[0] + "strike  " + result[1] + "ball");
	}
	
	static void game() {
		int[] rNumArray = new int[3];
		int[] uNumArray = new int[3];
		int[] result = new int[2]; // 0: strike, 1: ball
		
		int chance = 0;
		
		genRanNumArr(rNumArray);
		System.out.println(Arrays.toString(rNumArray)); // check random Number(answer)
		
		while(chance < 10) {
			System.out.println((chance + 1) + "번째 시도입니다.");
		
			inputUserNumArr(uNumArray);
			System.out.println(Arrays.toString(uNumArray)); // check random Number(user)
			
			result = compArray(rNumArray, uNumArray);
			
			printResult(result);
			if(result[0] == 3) {
				System.out.println("정답입니다. 고생하셨습니다.");
				break;
			} else {
				System.out.println("틀렸습니다.");
			}
			chance++;
		}
		
		
	}
	
	public static void main(String[] args) {
		game();
	}
}
