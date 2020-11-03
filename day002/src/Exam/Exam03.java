package Exam;

public class Exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		int age;
		boolean man;
		String phone;
		double height;
		String address;
		
		System.out.printf("================================================================\n");
		System.out.printf("\\ name\t\tage\tman\tphone\t\theight\taddress\t\\\n");
		System.out.printf("================================================================\n");
		
		name = "홍길동";
		age = 20;
		man = true;
		phone = "010-111-2222";
		height = 175.12;
		address = "경기도";
		System.out.printf("\\ \"%s\"\t%d\t%b\t%s\t%s\t\"%s\"\t\\\n", name, age, man, phone, height, address);
		
		name = "일지매";
		age = 18;
		man = true;
		phone = "02-123-4567";
		height = 180.01;
		address = "서울";
		System.out.printf("\\ \"%s\"\t%d\t%b\t%s\t%s\t\"%s\"\t\\\n", name, age, man, phone, height, address);
		
		name = "장옥정";
		age = 14;
		man = false;
		phone = "02-345-7890";
		height = 155.78;
		address = "부산";
		System.out.printf("\\ \"%s\"\t%d\t%b\t%s\t%s\t\"%s\"\t\\\n", name, age, man, phone, height, address);
		
		System.out.printf("================================================================\n");
	}

}
