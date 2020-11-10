package calculator;

import java.util.Scanner;

public class Calculator {
	public static double validateInputDouble(Scanner sc, String order) {
		double number = 0;
		while(true) {
			System.out.println(order + " 숫자를 입력해주세요");
			System.out.print("> ");
			String input = sc.next();
			
			boolean dot = false;
			boolean error = false;
			for(int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if(c == '-') {
					if(i != 0 || input.length() <= 1) {
						error = true;
						break;
					}
				} else if (c == '.') {
					if(dot == false && i != 0 && i != input.length() -1) {
						dot = true;
					}
					else {
						error = true;
						break;
					}
				} else if (c < '0' || c > '9') {
					error = true;
					break;
				}
			}
			if(error) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				number = Double.parseDouble(input);
				break;
			}
		}
		return number;
	}
	
	public static char validateInputOperator(Scanner sc) {
		char operator;
		while(true) {
			System.out.println("연산자(+ - * / %)를 입력해주세요");
			System.out.print("> ");
			String input = sc.next();
			
			if (input.length() > 1) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			
			boolean error = false;
			operator = input.charAt(0);
			switch (operator) {
				case '+':
				case '-':
				case '*':
				case '/':
				case '%':
					break;
				default:
					error = true;
					break;
			}
			
			if(error) {
				System.out.println("잘못 입력하셨습니다.");
			} else {
				break;
			}
		}
		return operator;
	}
	
	public static double calculate(double num1, double num2, char operator, boolean[] zero) {
		double result = 0;
		switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				if(num2 == 0) {
					zero[0] = true;
					break;
				}
				result = num1 / num2;
				break;
			case '%':
				if(num2 == 0) {
					zero[0] = true;
					break;
				}
				result = num1 / num2;
				break;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		/*
		 * 계산기
		 * 1. 첫번째 수 입력(숫자인지 아닌지?)
		 * 2. 연산자(정확히 연산자인지?)
		 * 3. 두번째 수 입력(숫자인지 아닌지?)
		 * 4. 연산 처리
		 * 5. 결과 출력 -> 1번으로
		 */
		Scanner sc = new Scanner(System.in);
		
		double firstNum;
		double secondNum;
		char operator;
		
		// 1. 첫번째 수 입력(validate)
		firstNum = validateInputDouble(sc, "첫번째");
		
		// 2. 연산자 입력( + - * / % )
		operator = validateInputOperator(sc);
		
		// 3. 두번째 수 입력(validate)
		secondNum = validateInputDouble(sc, "두번째");
		
		// 연산처리
		boolean[] zero = new boolean[1];
		double result = calculate(firstNum, secondNum, operator, zero);
		boolean zeroDivisor = zero[0];
		
		// 결과 출력
		if(zeroDivisor) {
			System.out.println("분모에 0을 넣을 수 없습니다.");
		} else {
			System.out.printf("%f %c %f = %f", firstNum, operator, secondNum, result);
		}

		sc.close();
	}
}
