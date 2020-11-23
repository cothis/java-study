package day010.calculator;

import java.util.Scanner;

public class CalculatorEx1 {
	// num1, num2, operator
	int num1;	// member 변수
	int num2;
	int result;
	String op;
	
	public void input() { // member 메소드
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자 : ");
		num1 = sc.nextInt();
		
		System.out.print("연산자 : ");
		op = sc.next();
		
		System.out.print("두번째 숫자 : ");
		num2 = sc.nextInt();
		
		sc.close();
	}
	
	public void proccess() {
		switch(op) {
			case "+": {
				result = num1 + num2;
				break;
			}
			case "-": {
				result = num1 - num2;
				break;
			}
			case "*": {
				result = num1 * num2;
				break;
			}
			case "/": {
				result = num1 / num2;
				break;
			}
			default: {
				break;
			}
		}
	}
	
	public void print() {
		System.out.println(num1 + " " + op + " " + num2 + " = " + result);
	}
}
