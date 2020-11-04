package Work;

import java.util.Scanner;

/*
 * 하나의 수를 입력 받고 10의 배수로 입력 받은 수는 어느 범위에 있는지 
 * 출력되는 프로그램을 작성하라.
 */
public class Work14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1~100 사이의 숫자를 입력해주세요");
		System.out.print("> ");
		int userNumber = scanner.nextInt();
		
		// 방법 1
		System.out.println("방법 1");
		if (userNumber == 100) {
			System.out.println("입력하신 숫자는 100입니다.");
		}
		else {
			int rangeStartNumber;
			rangeStartNumber = (userNumber / 10) * 10;
			
			System.out.println("입력하신 숫자는 " + rangeStartNumber + "보다 크거나 같고 " + (rangeStartNumber + 10) + "보다 작습니다.");
		}
		
		// 방법 2
		System.out.println("방법 2");
		if (userNumber == 100) {
			System.out.println("입력하신 숫자는 100입니다.");
		} else if (userNumber >= 90) {
			System.out.println("입력하신 숫자는 90보다 크거나 같고 100보다 작습니다.");
		} else if (userNumber >= 80) {
			System.out.println("입력하신 숫자는 80보다 크거나 같고 90보다 작습니다.");
		} else if (userNumber >= 70) {
			System.out.println("입력하신 숫자는 70보다 크거나 같고 80보다 작습니다.");
		} else if (userNumber >= 60) {
			System.out.println("입력하신 숫자는 60보다 크거나 같고 70보다 작습니다.");
		} else if (userNumber >= 50) {
			System.out.println("입력하신 숫자는 50보다 크거나 같고 60보다 작습니다.");
		} else if (userNumber >= 40) {
			System.out.println("입력하신 숫자는 40보다 크거나 같고 50보다 작습니다.");
		} else if (userNumber >= 30) {
			System.out.println("입력하신 숫자는 30보다 크거나 같고 40보다 작습니다.");
		} else if (userNumber >= 20) {
			System.out.println("입력하신 숫자는 20보다 크거나 같고 30보다 작습니다.");
		} else if (userNumber >= 10) {
			System.out.println("입력하신 숫자는 10보다 크거나 같고 20보다 작습니다.");
		} else if (userNumber >= 0) {
			System.out.println("입력하신 숫자는 0보다 크거나 같고 10보다 작습니다.");
		}
		
		// 방법 3
		System.out.println("방법 3");
		for(int i = 100; i > 0; i = i-10) {
			if ( userNumber >= i) {
				System.out.println("입력하신 숫자는 " + (i) + "보다 크거나 같고 " + (i + 10) + "보다 작습니다.");
//				break;
			}
		}
		
		scanner.close();		
	}
}
