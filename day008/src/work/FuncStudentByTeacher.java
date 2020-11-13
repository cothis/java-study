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

public class FuncStudentByTeacher {
	public static void main(String[] args) {
		String[][] student = null;
		
		// 학생 수
		int count = studentCountInput();
		
		// 학생 정보 입력
		student = studentInput(count);
		
		for(int i = 0 ; i < student.length ; i++) {
			System.out.println(Arrays.toString(student[i]));
		}
		
		// 학생 총점
		studentAllNum(student);
		
		// 총점의 1등
		studentAllNumOne(student);
		
		// 과목의 1등
		studentTitleOne(student);
	}
	
	/*
	 * 함수명: studentCountInput
	 * 매개변수 : 없음
	 * return : 학생수
	 * 내용 : 학생수를 입력받는다.
	 */
	static int studentCountInput() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수 입력 : ");
		int count = sc.nextInt();
		
		return count;
	}
	
	static String[][] studentInput(int count) {
		if(count < 1) {
			System.out.println("학생 수 입력이 잘못 되었습니다.");
			return null;
		}
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String[][] student = new String[count][4];
		
		for (int i = 0; i < student.length; i++) {
			System.out.println((i + 1) + "번째 학생 정보");
			String name;
			while(true) {
				System.out.print("이름 = ");
				name = sc.next();
				if(name.trim().equals("")) {
					System.out.println("이름을 입력해 주십시오.");
					continue;
				}
				break;
			}
			
			String[] language = titleFunc();
			
			// 정상적으로 입력한 경우
			student[i][0] = name;
			student[i][1] = language[0];
			student[i][2] = language[1];
			student[i][3] = language[2];
		}
		return student;
	}
	
	static String[] titleFunc() {
		// 사실 이 메소드는 continue가 잘못되어 있음.
		// while 간단하게 추가하면 해결됨
		// ==> 해결함
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String title[] = {"국어", "영어", "수학"};
		String score[] = new String[3];
		
		for(int i = 0; i < score.length; i++) {
			while(true) { // continue 오류 해결
				System.out.print(title[i] + " = ");
				score[i] = sc.next();
				if(isNumber(score[i]) == false) {
					System.out.println(title[i] + " 점수가 잘못되었습니다.");
					continue;
				}
				break; // continue 오류 해결
			}
		}
		return score;
	}
	
	static void studentAllNum(String[][] student) {
		if(student==null || student.length==0) {
			return;
		}
		
		int[] scoreSum = strArrToIntArr(student);
		
		for (int i = 0 ; i < student.length; i++) {
			String name = student[i][0];
			System.out.printf("%s의 총점: %d%n", name, scoreSum[i]);
		}
	}
	
	static void studentAllNumOne(String[][] student) {
		int[] scoreSum = strArrToIntArr(student);
		
		int max = scoreSum[0];
		for (int i = 1 ; i < scoreSum.length ; i++) {
			if(max < scoreSum[i]) {
				max = scoreSum[i];
			}
		}
		System.out.println("총점의 최고점 : " + max);
	}
	
	static int[] strArrToIntArr(String[][] student) {
		int[] scoreSum = new int[student.length];
		for(int i = 0; i < student.length; i++) {
			int kor = Integer.parseInt(student[i][1]);
			int eng = Integer.parseInt(student[i][2]);
			int math = Integer.parseInt(student[i][3]);
			scoreSum[i] = kor + eng + math;
		}
		return scoreSum;
	}
	
	static void studentTitleOne(String[][] student) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("과목 입력(국어1, 영어2, 수학3) : ");
		int title = sc.nextInt();
		
		int titleNum[][] = new int[student.length][3];
		for(int i = 0; i < titleNum.length; i++) {
			for(int j = 0; j < titleNum[i].length; j++) {
				titleNum[i][j] = Integer.parseInt(student[i][j + 1]);
			}
		}
		
		/*//check titleNum array
		for(int i = 0; i < titleNum.length; i++) {
			System.out.println(Arrays.toString(titleNum[i]));
		}
		*/
		int titleIndex = title - 1;
		int max = titleNum[0][titleIndex];
		for(int i = 0; i < titleNum.length; i++) {
			if(max < titleNum[i][titleIndex]) {
				max = titleNum[i][titleIndex];
			}
		}
		
		String[] titleName = {"국어", "영어", "수학"};
		System.out.println(titleName[titleIndex] + "의 최고 점수 : " + max);
	}
	
	static void sumOfAvg(String[][] student) {
		int[] sum = strArrToIntArr(student);
		
		int allSum = 0;
		for(int num : sum) {
			allSum += num;
		}
		
		double avg = allSum / (double)(sum.length);
		System.out.println("총점의 평균 : " + avg);
	}
	
	static boolean isNumber(String str) {
		boolean b = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				b = false;
				break;
			}
		}
		return b;
	}
}
