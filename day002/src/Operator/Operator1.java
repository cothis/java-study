package Operator;

public class Operator1 {
	public static void main(String[] args) {
		/*
		 * operator
		 * 사칙연산 : +, -, *, /, %
		 * 
		 */
		
		int num1, num2;
		int result;
		
		num1 = 25;
		num2 = 7;
		
		result = num1 + num2;
		System.out.println("num1 + num2 = " + result);
		
		// " /		"hello" \ "world"
		System.out.println("\"hello\" \\ \"world\"");
		
		result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result);
		
		// /, % 계산 시 제수(divisor)가 0이면 안된다.
		result = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + result);
		
		// 가장 많이 사용되는 연산
		int n = 0;
		n = n + 1;	// 자기 자신을 갱신
		System.out.println("n = " + n);
		n += 1;
		System.out.println("n = " + n);
		
		// increment, decrement
		n = 0;
		System.out.println("n = " + n + " 초기화");
		n++;
		System.out.println("n = " + n);
		++n;
		System.out.println("n = " + n);
		n--;
		System.out.println("n = " + n);
		--n;
		
		int num = 1;
		System.out.println("num = " + num + " 초기화");
		int tag;
		tag = num++;	// 괄호가 있어도 동일
		System.out.println("tag(1++) = " + tag);
		tag = ++num;
		System.out.println("tag(++2) = " + tag);
		
		num = 0;
		tag = (num++);
		System.out.println(tag);
		tag = (--num);
		System.out.println(tag);
		tag = (--num);
		System.out.println(tag);
	}
}
