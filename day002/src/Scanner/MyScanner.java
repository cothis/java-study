package Scanner;

import java.util.Scanner;

public class MyScanner {
	public static void main(String[] args) {
		// 입력(console)
		Scanner scanner = new Scanner(System.in);
		
		// boolean(true/false)
		/*
		boolean b;
		System.out.print("b = ");
		b = scanner.nextBoolean();
		System.out.println("b: " + b);
		/**/
		
		// int(정수)
		/*
		int i;
		System.out.print("i = ");
		i = scanner.nextInt();
		System.out.println("i: " + i);
		/**/
		
		// double(실수)
		/*
		double d;
		System.out.print("d = ");
		d = scanner.nextDouble();
		System.out.println("d: " + d);
		/**/
		
		// String(문자열)
		String str;
		System.out.print("str = ");
		str = scanner.next();
		System.out.println("str: " + str);

		scanner.close();
	}

}
