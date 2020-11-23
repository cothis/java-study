package day004.Work;

// random Number 찾기 게임
// rule
// 랜덤넘버 만들기 1~100사이
// 유저 입력 -> 1~100 사이 검증
// 랜덤숫자와 비교

import java.util.Scanner;

public class Work01 {
	public static final int chance = 10;
	public static void main(String[] args) {
		// 스캐너 생성
		Scanner scanner = new Scanner(System.in);
		
		Loop:while (true) {
			System.out.println("1. 게임하기    2. 종료");
			int select = scanner.nextInt();
			switch (select) {
				case 1: {
					// 랜덤넘버 생성(1~100)
					int answer = (int) (Math.random() * 100) + 1;
					int userNumber;

					// loop (기회는 10번)
					for (int i = 0; i < chance; i++) {
						// 유저 입력(1~100 검증)
						while (true) {
							System.out.println("숫자를 입력해주세요. 남은 기회 :" + (chance - i) + ", 정답 : " + answer);
							System.out.print("> ");
							userNumber = scanner.nextInt();
							if (userNumber > 0 && userNumber <= 100) {
								break;
							} else {
								System.out.println("범위를 확인하시고 다시 입력해주세요.");
							}
						}
						// 랜덤 숫자 비교
						// 맞으면 정답 출력 후 Loop 종료
						if (userNumber == answer) {
							System.out.println("정답입니다.");
							break;
						}

						// 비교 결과(Up/Down) 출력
						if (userNumber > answer) {
							System.out.println("너무 큽니다.");
						} else {
							System.out.println("너무 작습니다.");
						}

					}

				}
					break;
				case 2:
					break Loop;
				default:
					break;
			}
		}
		System.out.println("사용해주셔서 감사합니다.");
		
				
		scanner.close();		
	}
}
