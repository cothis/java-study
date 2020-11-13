package work;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 성적관리 프로그램
 * 
 * 1. 몇 명의 학생의 통계 입력
 * 2. 입력(입력 체크)
 *    이름, 국어, 수학, 영어
 * 3. 각 학생들의 총점
 * 4. 총점의 1등
 * 5. 과목의 1등
 * 6. 과목의 최하점자
 * 7. 총점의 평균
 * 8. 이름을 입력하면, 그 학생의 성적 출력
 */

public class FuncStudent {
	Scanner sc;
	String[][] students;
	int[] total;
	
	public FuncStudent() {
		sc = new Scanner(System.in);
		
		students = null;
		total = null;

		insertStudents();
		
		calcTotal();
		
		printResult();
		
		printStudent();
		
		sc.close();
	}
	
	private void insertStudents() {
		// 입력
			// 학생 수
			// 학생 정보
		System.out.print("학생 수 입력 : ");
		int numStudent = sc.nextInt();
		students = new String[numStudent][4];
		
		int w = 0;
		while(w < students.length) {
			insertStudentScore(w);
			w++;
		}
		
	}
	
	private void insertStudentScore(int index) {
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("국어: ");
		String kor = sc.next();
		
		System.out.print("영어: ");
		String eng = sc.next();
		
		System.out.print("수학: ");
		String math = sc.next();
		
		students[index][0] = name;
		students[index][1] = kor;
		students[index][2] = eng;
		students[index][3] = math;
	}
	
	
	private void calcTotal() {
		// 계산
			// 총점
		total = new int[students.length];
		
		for(int i = 0; i < students.length; i++) {
			for(int j = 1 ; j < 4; j++) {
				int score = Integer.parseInt(students[i][j]);
				total[i] = total[i] + score;
			}
		}
	}
	
	private void printResult() {
		// 출력
			// 총점 배열
			// 총점 1등
			// 과목 1등
			// 과목 최하점자
			// 총점 평균
		int index;
		int score;
		double average;
		
		//1. 총점 배열
		for(int i = 0; i < students.length; i++) {
			System.out.println(students[i][0] + " 학생의 총점 : " + total[i]);
		}
		
		//2. 총점 1등
		index = getMaxTotalIndex();
		System.out.println("총점 1등은 " + students[index][0] + " 학생입니다. 총점 : " + total[index]);
		
		//3. 과목 1등
		index = getSubjectIndex(true);
		score = Integer.parseInt(students[index][1]);
		System.out.println("국어 1등은 " + students[index][0] + " 학생입니다. 점수 : " + score);
		
		//4. 과목 최하점자
		index = getSubjectIndex(false);
		score = Integer.parseInt(students[index][1]);
		System.out.println("국어 꼴등은 " + students[index][0] + " 학생입니다. 점수 : " + score);
		
		//5. 총점 평균
		average = getAverage();
		System.out.println("총점의 평균 : " + average);
		
	}
	
	private double getAverage() {
		int sum = 0;
		double average;
		for(int i = 0 ; i < total.length; i++) {
			sum = sum + total[i];
		}
		average = sum / (double) total.length;
		return average;
	}
	
	private int getSubjectIndex(boolean isMax) {
		int index = 0;
		int tempScore = Integer.parseInt(students[0][1]); //kor
		for(int i = 0 ; i < students.length; i++) {
			int subjectScore = Integer.parseInt(students[i][1]);
			if((isMax && tempScore < subjectScore) || (!isMax && tempScore > subjectScore)) {
				tempScore = subjectScore;
				index = i;
			}
		}
		return index;
	}
	
	private int getMaxTotalIndex() {
		int maxIndex = 0;
		int max = total[0];
		for(int i = 0 ; i < total.length; i++) {
			if(max < total[i]) {
				max = total[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	private void printStudent() {
		// 입력
			// 학생이름
			// 성적 출력
		System.out.print("조회할 학생의 이름: ");
		String name = sc.next();
		String[] st = null;
		for(int i = 0; i < students.length; i++) {
			if(students[i][0].equals(name)) {
				st = students[i];
				break;
			}
		}
		
		System.out.println(Arrays.toString(st));
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		FuncStudent fc = new FuncStudent();
	}
}
