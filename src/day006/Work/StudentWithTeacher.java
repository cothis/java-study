package day006.Work;

import java.util.Arrays;
import java.util.Scanner;

public class StudentWithTeacher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 선언
		String[][] student = null;
//		{
//			{"홍길동", "90", "100", "85"},
//			{"홍길냥", "80", "50", "75"},
//			{"고길동", "50", "30", "25"}
//		};
		int sum;
		double avg;
		@SuppressWarnings("unused")
		int max, min;
		
		// 초기화
		sum = 0;
		
		// 1. 몇명의 학생의 통계
		System.out.print("학생의 수를 입력 = ");
		int count = sc.nextInt();
		
		student = new String[count][4];
		
		// 2. 이름, 국어, 수학, 영어 입력
		int w = 0;
		while ( w < student.length) {
			System.out.print("이름 = ");
			String name = sc.next();
			
			System.out.print("국어 = ");
			String kor = sc.next();
			
			System.out.print("영어 = ");
			String eng = sc.next();
			
			System.out.print("수학 = "); 
			String math = sc.next();
			
			if(name.trim().equals("")) {
				System.out.println("이름을 입력해 주십시오.");
				continue;
			}
			
			boolean error = false;
			for (int i = 0; i < kor.length(); i++) {
				char c = kor.charAt(i);
				if (c < '0' || c > '9') {
					error = true;
					System.out.println("국어 점수가 잘못되었습니다.");
					break;
				}
			}
			if(error) {
				continue;
			}
			
			error = false;
			for (int i = 0; i < eng.length(); i++) {
				char c = eng.charAt(i);
				if (c < '0' || c > '9') {
					error = true;
					System.out.println("영어 점수가 잘못되었습니다.");
					break;
				}
			}
			if(error) {
				continue;
			}
			
			error = false;
			for (int i = 0; i < math.length(); i++) {
				char c = math.charAt(i);
				if (c < '0' || c > '9') {
					error = true;
					System.out.println("수학 점수가 잘못되었습니다.");
					break;
				}
			}			
			if(error) {
				continue;
			}
			
			// 정상적으로 입력한 경우
			student[w][0] = name;
			student[w][1] = kor;
			student[w][2] = eng;
			student[w][3] = math;
			
			w++;
		}
		
		// 전체 학생 정보 출력
		for(String[] st : student) {
			System.out.println(Arrays.toString(st));
		}
		
		// 3. 각 학생들의 총점
		int[] scoreSum = new int[student.length];
		for(int i = 0; i < student.length; i++) {
			int kor = Integer.parseInt(student[i][1]);
			int eng = Integer.parseInt(student[i][2]);
			int math = Integer.parseInt(student[i][3]);
			scoreSum[i] = kor + eng + math;
		}
		
		for (int i = 0 ; i < student.length; i++) {
			String name = student[i][0];
			System.out.printf("%s의 총점: %d%n", name, scoreSum[i]);
		}
		
		// 4. 총점의 최고점
		String[] maxStudent = student[0];
		max = scoreSum[0];
		for (int i = 1 ; i < scoreSum.length ; i++) {
			if(max < scoreSum[i]) {
				max = scoreSum[i];
				maxStudent = student[i];
			}
		}
		System.out.println("총점의 최고점 학생 : " + maxStudent[0]);
		System.out.println("총점의 최고점 : " + max);
		
		// 5. 과목의 1등(국어)
		int[] scoreKor = new int[student.length];
		int scoreMax = Integer.parseInt(student[0][1]);

		for(int i = 1; i < student.length; i++) {
			scoreKor[i] = Integer.parseInt(student[i][1]);
			if(scoreMax < scoreKor[i]) {
				scoreMax = scoreKor[i];
				maxStudent = student[i];
			}
		}
		System.out.println("국어의 최고점 학생 : " + maxStudent[0]);
		System.out.println("국어의 최고점 : " + scoreMax);
		
		// 6. 과목의 최하점(수학)
		int[] scoreMath = new int[student.length];
		int scoreMin = Integer.parseInt(student[0][3]);
		for(int i = 1; i < student.length; i++) {
			scoreMath[i] = Integer.parseInt(student[i][1]);
			if(scoreMin > scoreMath[i]) {
				scoreMin = scoreMath[i];
				maxStudent = student[i];
			}
		}
		System.out.println("수학의 최저점 학생 : " + maxStudent[0]);
		System.out.println("수학의 최저점 : " + scoreMax);
		
		// 7. 총점의 평균
		sum = 0; // 위에서 초기화하긴 했지만 그냥 한번 더해줌
		for(int n : scoreSum) {
			sum = sum + n;
		}
		avg = sum / (double) student.length;
		System.out.println("총점의 합계 : " + sum);
		System.out.println("총점의 평균 : " + avg);
		
		// 8. 이름을 입력하면 해당 학생의 성적 출력
		System.out.println("확인하실 학생의 이름을 입력해주세요.");
		System.out.println("===== 학생 리스트 =====");
		for(String[] st : student) {
			System.out.print(st[0] + "  ");
		}
		System.out.println();
		
		while(true) {
			System.out.print("이름 : ");
			String name = sc.next();
			int findIndex = -1;
			for (int i = 0; i < student.length; i++) {
				if (student[i][0].equals(name)) {
					findIndex = i;
					break;
				}
			}
			if(findIndex == -1) {
				System.out.println("해당 학생이 없습니다.");
				continue;
			} else {
				System.out.println(Arrays.toString(student[findIndex]));
				break;
			}
		} // 이름 입력 Loop 종료
		
		sc.close();
	}
}
