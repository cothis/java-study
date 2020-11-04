package Control;

public class Switch01 {
	public static void main(String[] args) {
		/*
		 * switch : 조건문으로 값이 명확해야 한다.
		 * 
		 * 가독성(可讀性) : 쓰여진 글을 보통 사람들이 얼마나 쉽게 읽을수 있는가
		 * 
		 *   switch (변수명) {
		 *   case A:
		 *     내용
		 *     break;
		 *   case B:
		 *     내용
		 *     break;
		 *     :
		 *   default:
		 *     내용
		 *     break;
		 *   }
		 */

		int num = 2;
		switch (num) {
			case 1:
				System.out.println("num은 1입니다");
				break;
			case 2:
				System.out.println("num은 2입니다");
				break;
			case 3:
				System.out.println("num은 3입니다");
				break;
			default:
				System.out.println("num은 ?입니다");
				break;
		}
		
		char c = '가';
		switch (c) {
			case '가':
				System.out.println("c는 가입니다");
				break;
			case '나':
				System.out.println("c는 나입니다");
				break;
			case '다':
				System.out.println("c는 다입니다");
				break;
			default:
				System.out.println("c는 ?입니다");
				break;
		}
		
		/* 안되는 경우 - 실수는 안된다.
		double d = 3.141592;
		switch (d) {
			case 3.14:	
				break;
			default:
				break;
		}
		/**/
		
		// jdk 1.7에서 추가된 String switch
		String str = "hello";
		switch (str) {
			case "가나다":
				System.out.println("str은 가나다");
				break;
			case "hello":
				System.out.println("str은 hello");
				break;
			default:
				break;
		}
		
		/* 조건식 사용 안됨.
		switch (num) {
			case num > 1:
				break;
			default:
				break;
		}
		/**/
	}
}
