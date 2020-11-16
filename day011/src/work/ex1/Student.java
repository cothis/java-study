package work.ex1;

public class Student {
	public String name;
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	private int sum;
	private double average;
	
	public int getTotal(int...number) {
		if(number.length == 0) {
			System.out.println("합계 계산 인자가 입력되지 않았습니다.");
			return 0;
		}
		
		sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum += number[i];
		}
		average = sum / (double) number.length;
		return sum;
	}
	
	public double getAverage() {
		return average; 
	}
}
