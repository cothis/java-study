package Exam;

import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 사용자 정보
		String name;
		int age;
		boolean man;
		String phone;
		double height;
		String address;
		
		System.out.print("name: ");
		name = scanner.next();
		System.out.print("age: ");
		age = scanner.nextInt();
		System.out.print("man: ");
		man = scanner.nextBoolean();
		System.out.print("phone: ");
		phone = scanner.next();
		System.out.print("height: ");
		height = scanner.nextDouble();
		System.out.print("address: ");
		address = scanner.next();
		
		System.out.println("입력하신 내용은 아래와 같습니다.");
		System.out.printf("name: %s\n"
				+ "age: %d\n"
				+ "man: %b\n"
				+ "phone: %s\n"
				+ "height: %.2f\n"
				+ "address: %s\n", name, age, man, phone, height, address);
		
		scanner.close();
	}
}
