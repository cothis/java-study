package day011.student;

public class Main {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setNumber(1);
		stu.setName("홍길동");
		stu.setKor(95);
		stu.setEng(100);
		stu.setMath(85);
		
		String name = stu.getName();
		
		System.out.println(name);
		
		Student[] students = new Student[3];
		for(int i = 0 ; i < students.length; i++) {
			students[i] = new Student();
		}
		
		students[0].setName("홍길동");
		students[0].setNumber(1);
		students[0].setKor(100);
		students[0].setMath(50);
		students[0].setEng(50);
	}
}
