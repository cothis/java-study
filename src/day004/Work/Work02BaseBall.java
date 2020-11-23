package day004.Work;

// baseball
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

import java.util.Scanner;

public class Work02BaseBall {
	public static final boolean DEV = true;
	public static final int MAX_CHANCE = 10;
	public static final int NUMBER_OF_ANSWER = 5;
	public static final int MAX_NUMBER = 10;
	
 	public static void printArray(int[] array) {
		for (int i = 0 ; i < array.length; i++) {
			if( i == 0) {
				System.out.print("[ ");
			} else {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.println(" ]");
	}	
	
	public static boolean isExist(int[] array, int number) {
		boolean existNumber = false;
		for(int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				// 배열에 이미 존재
				existNumber = true;
				break;
			}
		}
		return existNumber;
	}
	
	public static void game(Scanner scanner) {
		// 선언 및 초기화
		int[] randNumbers = new int[NUMBER_OF_ANSWER];
		int[] userNumbers = new int[NUMBER_OF_ANSWER];
		boolean clear = false;
		int loopCount;
		
		// 랜덤 숫자 3개 생성(array) 1 ~ 10 사이의 숫자
		// 이때 같은 숫자 안나오도록 확인
		loopCount = 0;
//		while(loopCount < NUMBER_OF_ANSWER) {
//			int num = (int) (Math.random() * 10) + 1;
//			// 배열에 이미 존재하는 값인지 확인
//			if(isExist(randNumbers, num)) {
//				// 이미 존재하면 continue 하고 다시 생성
//				continue;
//			}
//			randNumbers[loopCount] = num;
//			loopCount++;
//		}
		boolean[] match = new boolean[MAX_NUMBER];
		while (loopCount < NUMBER_OF_ANSWER) {
			int num = (int) (Math.random() * MAX_NUMBER);
			if (match[num] == false) {
				match[num] = true;
				randNumbers[loopCount] = num + 1;
				loopCount++;
			}
		}
		
		// Loop(10회)
		int chance = 0;
		while(chance < MAX_CHANCE) {
			// 숫자 입력(3회)
			// userNumbers 초기화
			for (int i = 0; i < userNumbers.length; i++) {
				userNumbers[i] = 0;
			}
			
			System.out.println();
			// 랜덤 array 확인
			if(DEV) {
				System.out.print("정답: ");
				printArray(randNumbers);
			}
			
			// 입력 시작 메세지
			System.out.printf("%d/%d회 시도\n", chance + 1, MAX_CHANCE);
			loopCount = 0;
			while(loopCount < NUMBER_OF_ANSWER) {
				System.out.println((loopCount + 1) + "번째 숫자를 입력해주세요.");
				System.out.print("> ");
				int num = scanner.nextInt();
				
				// 1 ~ 10 범위 확인
				if (num < 1 || num > MAX_NUMBER) {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
				// 같은 숫자 안나오도록 확인
				if(isExist(userNumbers, num)) {
					System.out.println("중복된 숫자를 입력하셨습니다.");
					continue;
				}
				userNumbers[loopCount] = num;
				loopCount++;
			}
			// 입력한 숫자 출력해주기
			System.out.print("입력하신 숫자 : ");
			printArray(userNumbers);
			
			// 비교 및 출력
			int strike = 0;
			int ball = 0;
			
			for (int i = 0; i < userNumbers.length; i++) {
				for ( int j = 0; j < randNumbers.length; j++) {
					// 값이 같을때
					if ( userNumbers[i] == randNumbers[j]) {
						if (i == j) {
							// strike
							strike++;
						} else {
							// ball
							ball++;
						}
					}
				}
			}
			System.out.println("result: " + strike + "strike " + ball + "ball");
			
			chance++;
			// 정답이면 Loop 종료
			if(strike == NUMBER_OF_ANSWER) {
				clear = true;
				break;
			}
		}
		// 최종 결과 출력
		if (clear) {
			System.out.println("정답입니다! 축하합니다.");
		} else {
			System.out.println("아쉽지만 실패입니다. 다시 시도하세요.");
		}
	}
	
	public static int menu(Scanner scanner) {
		System.out.println("----------");
		System.out.println("비트 야구 게임");
		System.out.println("1. 게임 시작");
		System.out.println("2. 종료");
		System.out.println("----------");
		System.out.print("> ");
		return scanner.nextInt();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 게임 메뉴
		boolean test = true;
		while (test) {
			int select = menu(scanner);
			if (select == 1) {
				game(scanner);
			} else if (select == 2) {
				System.out.println();
				System.out.println("사용해주셔서 감사합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
		scanner.close();
	}
}










