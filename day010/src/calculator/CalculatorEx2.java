package calculator;

import java.util.Scanner;

public class CalculatorEx2 {
	int num1;
	int num2;
	int result;
	String op;
	
	public int inputNumber(String order) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input;
		while(true) {
			System.out.println(order + " 숫자를 입력해주세요");
			System.out.print("> ");
			input = sc.next();
			
			boolean error = false;
			for(int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if(c == '-') {
					if(i != 0 || input.length() <= 1) {
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
				break;
			}
		}
		return Integer.parseInt(input);
	}

	public void inputOperator() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input;
		while(true) {
			System.out.println("연산자(+ - * / %)를 입력해주세요");
			System.out.print("> ");
			input = sc.next();

			if(input.equals("+") || input.equals("-") || 
					input.equals("*") || input.equals("/") || input.equals("%")) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		op = input;
	}
	
	public void calculate() {
		switch(op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			case "%":
				result = num1 / num2;
				break;
		}
	}

	public void print() {
		num1 = inputNumber("첫번째");
		inputOperator();
		num2 = inputNumber("두번째");
		calculate();
		
		System.out.printf("%d %s %d = %d", num1, op, num2, result);
	}
}
