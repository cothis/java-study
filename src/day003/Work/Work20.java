package day003.Work;
/*
 * 사칙 연산을 할 수 있는 프로그램을 작성하라.
 */

import java.util.Scanner;

public class Work20 {
	public static int validateInt(Scanner scanner, int count, char operator) {
		int number = 0;
		while (true) {
			System.out.println(count + "번째 숫자를 입력해주세요");
			System.out.print("> ");
			try {
				number = scanner.nextInt();
				if(operator == '/' && number == 0) {
					System.out.println("나누기 연산의 분모에 0을 입력하실 수 없습니다.");
				} else {
					break;
				}
			} catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				scanner.nextLine();
			}
		}
		return number;
	}
	
	public static char validateOperator(Scanner scanner) {
		char c = ' ';
		while (true) {
			System.out.println("연산자를 입력해주세요.(+, -, *, /, %)");
			System.out.print("> ");
			c = scanner.next().charAt(0);
			if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
		return c;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int firstNumber = validateInt(scanner, 1, ' ');
		char operator = validateOperator(scanner);
		int secondNumber = validateInt(scanner, 2, operator);
		
		double result = 0;
		boolean divide = false;
		
		switch (operator) {
			case '+':
				result = firstNumber + secondNumber;
				break;
			case '-':
				result = firstNumber - secondNumber;
				break;
			case '*':
				result = firstNumber * secondNumber;
				break;
			case '/':
				result = firstNumber / (double)secondNumber;
				divide = true;
				break;
			case '%':
				result = firstNumber % secondNumber;
				break;
			default:
				result = 0;
				break;
		}	
		if (divide) {
			System.out.printf("%d %c %d = %f\n", firstNumber, operator, secondNumber, result);
		} else {
			System.out.printf("%d %c %d = %d\n", firstNumber, operator, secondNumber, (int) result);			
		}
		
		String a = "ddf";
		a.charAt(0);
		scanner.close();
	}
}
