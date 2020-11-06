package Work;

import java.util.Scanner;

public class Work06StringValidation {
	/*
	 * 입력된 문자열이 모두 숫자인지 확인하는 코드 작성
	 * String "12345" 모두 숫자입니다
	 * String "1234a" 숫자가 아닙니다.
	 */
	public static void main(String[] args) {
		// 선언
		Scanner scanner = new Scanner(System.in);
		boolean isNumber = true;		// 숫자인지
		int numStartIndex = 0;			// 숫자가 시작하는 인덱스(기본은 0인데 -가 있으면 1로 바뀜)
		boolean isRealNumber = false;	// 실수인지
		
		// 입력
		System.out.println("숫자를 입력해주세요.");
		System.out.print("> ");
		String str = scanner.next();
		System.out.println("입력하신 글자 : " + str);
		System.out.println();
		
		// 체크
		for(int i = 0; i < str.length(); i++) {
			// ASCII 코드값 획득
			int num = str.charAt(i);
			
			// ASCII 45 == '-', 첫번째 글자가 -인 경우 음수로 간주
			if(i == numStartIndex && num == 45) {
				numStartIndex++;
				continue;
			}
			
			// ASCII 46 == '.', 첫번째/마지막 글자가 아니고
			//  '.'이 처음 나온 경우 실수로 간주
			if((i != numStartIndex && i != str.length() -1) 
					&& num == 46 && isRealNumber == false) {
				isRealNumber = true;
				continue;
			}
			
			// ASCII 48~57 == 0~9 숫자
			if(num >= 48 && num <= 57) {
				continue;				
			}
			
			// if문에서 걸러지지 않으면 숫자가 아니며, for loop 종료
			isNumber = false;
			break;
		}
		
		// 숫자/문자 여부 및 정수/실수 여부 출력
		if (isNumber) {
			if (isRealNumber) {
				System.out.println("모두 숫자이며 실수입니다.");
			} else {
				System.out.println("모두 숫자이며 정수입니다.");
			}
		} else {
			System.out.println("숫자가 아닙니다.");
		}
		
		// 입력된 알파벳 문자열을 모두 대문자로 바꿔보기.
		System.out.println("upperCase: " + str.toUpperCase());
		
		// 종료
		scanner.close();
	}
}
