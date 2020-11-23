package day010.oop;

public class OOP {
	/*
	Object Oriented Programming : 객체지향
	
	
	절차지향
	  - 50,000만 Line을 넘어가면 프로그래머 본인도 헤매게 된다.
	  	=> 1. 분산처리(함수)
	  	=> 2. 변수 -> number
	  	=> 3. 크기 -> 한계
	  	
		절차 지향
	0. 선언(변수)
	1. 초기화
	2. 랜덤
		1) 세부 1
		2) 세부 2	
	3. 입력
		1) 세부 1
		2) 세부 2
	4. 판단
	5. 결과
	
	학생 성적 관리 프로그램
	String[][] student = new String[3][4];
	[i][0]은 뭐고 [i][1] 은 뭐더라..?
	
	student			class Student {
		name			String name;
		kor				int kor;
		eng				int eng;
		math			int math;
					}
	
	클래스명 student = new 클래스명();
	student.name 은 이름이구나
	student.kor 은 국어점수구나
		
	class 클래스명 {
		변수들
		메소드들
	}
	
		stack		heap
	클래스명 변수 = new 클래스명();
			instance == 주체
			object == 객체
	*/
	public static void main(String[] args) {
		MyClass cls = new MyClass();
		System.out.println(cls);
		
		cls.c = 'A';
		cls.n = 123;
		cls.str = "hello";
		
		MyClass cls2 = new MyClass();
		cls2.c = 'B';
		cls2.n = 234;
		cls2.str = "world";
		
		// TV 2대 절차지향
		String[] name = new String[2];
		int[] channel = new int[2];
		boolean[] power = new boolean[2];
		
		name[0] = "Samsung";
		name[1] = "LG";
		
		channel[0] = 11;
		channel[1] = 24;
		
		power[0] = true;
		power[1] = false;
		
		System.out.println("메이커:" + name[0] + " " + channel[0] + " " + power[0]);
		System.out.println("메이커:" + name[1] + " " + channel[1] + " " + power[1]);
		
		
		// TV 2대 객체지향
		Tv tv1, tv2;
		tv1 = new Tv();
		tv2 = new Tv();
		
		tv1.name = "Samsung";
		tv1.channel = 11;
		tv1.power = true;
		tv1.print();
		
		tv2.name = "LG";
		tv2.channel = 24;
		tv2.power = false;
		tv2.print();
		
	}
}

class Tv {
	String name;	// 멤버변수
	int channel;
	boolean power;
	
	void print() {
		System.out.println("메이커:" + name + " " + channel + " " + power);
	}
}

class MyClass {
	char c;
	int n;
	String str;
}