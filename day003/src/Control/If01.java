package Control;

public class If01 {
	public static void main(String[] args) {
		/*
		 * 제어문
		 * - 조건문 if (with < > >= <= == != and && || !)
		 *   if (조건) {
		 *     내용
		 *   } else if (조건) {
		 *     내용
		 *   } else {
		 *     내용
		 *   }
		 *   
		 */
		
		int number = 6;
		
		if (number > 5) {
			System.out.println("number is greater than 5");
		}
		
		if (number >= 6) {
			System.out.println("number is greater than or equal to 6");
		}
		
		if (number == 6) {
			System.out.println("number is 6");
		}
		
		if (number != 5) {
			System.out.println("number is not 5");
		}
		
		if (number >= 0 && number < 10) {
			System.out.println("number is between 0 and 9");
		}
		
		if (number < 5 || number > 10) {
			System.out.println("number is less than 5 or greater than 10");
		}
		
		if (number > 10) {
			System.out.println("number is greater than 10");
		} else {
			System.out.println("number is less than or equal to 10");
		}
		
		number = 85;
		
		if (number == 100) {
			System.out.println("A++");
		} else if (number >= 90) {
			System.out.println("A");
		} else if (number >= 80) {
			System.out.println("B");
		} else {
			System.out.println("less than 80");
		}
		
		// 조건문 안에 조건문
		number = 75;
		
		if (number >= 75) {
			if (number >= 90) {
				System.out.println("A");
			} else if (number >= 80) {
				System.out.println("B");
			} else {
				System.out.println("C");
			}
			
		} else {
			System.out.println("Please Retry");
		}
		
		boolean b;
		b = false;
		if (b) {
			System.out.println("b is true");
		}
		
		if (!b) {
			System.out.println("b is !b");
		}
	}
}












