package Work;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
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
		Scanner scanner = new Scanner(System.in);
		// 선언 및 초기화
		int numStudents = 0;
		int insertCount = 0;
		String[][] students = null;
		
		while(true) {
			System.out.println();
			System.out.println("비트 성적관리 프로그램입니다.");
			System.out.println("1. 전체 학생 수 입력");
			System.out.printf("2. 학생 정보 추가(%d/%d)%n", insertCount, numStudents);
			System.out.println("3. 총점 통계");
			System.out.println("4. 과목별 통계");
			System.out.println("5. 학생별 성적");
			System.out.println("6. 프로그램 종료");
			System.out.print("> ");
			String selectStr = scanner.next();
			System.out.println();
			if(selectStr.length() > 1) {
				System.out.println("잘못 입력하셨습니다");
				continue;
			}
			char selectChar = selectStr.charAt(0);
			if (selectChar < '1' || selectChar > '6') {
				System.out.println("잘못 입력하셨습니다");
				continue;
			}
			int select = selectChar - '0'; 
			if(select == 1) {
				// 전체 학생 수 입력
				while(true) {
					System.out.println("전체 학생 수를 입력해주세요.");
					System.out.print("> ");
					String num = scanner.next();
					boolean validate = true;
					for (char c : num.toCharArray()) {
						if(c < '0' || c > '9') {
							validate = false;
							break;
						}
					}
					// issue : 저장된 학생보다 작아질 때 확인 처리
					if(validate) {
						// 학생수 처리
						numStudents = Integer.parseInt(num);
						System.out.println("총 학생 수 : " + numStudents);
						students = new String[numStudents][4];
						break;
					}
				}
			} else if(select == 2) {
				// 학생 정보 추가
				if (insertCount == numStudents) {
					System.out.println("모든 학생을 입력하셨습니다.");
					continue;
				}
				System.out.println("학생 정보를 입력하겠습니다.");
				System.out.print("이름 : ");
				String name = scanner.next();
				String kor = null;
				String eng = null;
				String math = null;
				
				while(true) {
					System.out.print("국어 : ");
					kor = scanner.next();
					boolean check = false;
					for(int i = 0 ; i < kor.length() ; i++) {
						char c = kor.charAt(i);
						if (c >= '0' && c <= '9') {
							check = true;
							break;
						}
					}
					if(check) break;
					else {
						System.out.println("잘못 입력하셨습니다.");
					}
				}
				
				while(true) {
					System.out.print("영어 : ");
					eng = scanner.next();
					boolean check = false;
					for(int i = 0 ; i < eng.length() ; i++) {
						char c = eng.charAt(i);
						if (c >= '0' && c <= '9') {
							check = true;
							break;
						}
					}
					if(check) break;
					else {
						System.out.println("잘못 입력하셨습니다.");
					}
				}
				
				while(true) {
					System.out.print("수학 : ");
					math = scanner.next();
					boolean check = false;
					for(int i = 0 ; i < math.length() ; i++) {
						char c = math.charAt(i);
						if (c >= '0' && c <= '9') {
							check = true;
							break;
						}
					}
					if(check) break;
					else {
						System.out.println("잘못 입력하셨습니다.");
					}
				}
				
				students[insertCount][0] = name;
				students[insertCount][1] = kor;
				students[insertCount][2] = eng;
				students[insertCount][3] = math;
				insertCount++;				
			} else if(select == 3) {
				// 총점 통계
				System.out.println("총점 통계입니다.");
				if (insertCount == 0) {
					System.out.println("입력된 학생이 없습니다.");
					continue;
				}
				
				// 임시 Array 생성 및 students 복사
				// total Array 생성
				String[][] tempArray = students;
				int[] total = new int[insertCount];
				for (int i = 0; i < insertCount; i++) {
					for (int j = 1; j < 4; j++){
						total[i] += Integer.parseInt(tempArray[i][j]);
					}
				}
				for (int i = 0; i < insertCount - 1; i++) {
					for (int j = i + 1; j < insertCount ; j++) {
						if (total[i] > total[j]) {
							String[] temp = tempArray[i];
							tempArray[i] = tempArray[j];
							tempArray[j] = temp;
							int tempTotal = total[i];
							total[i] = total[j];
							total[j] = tempTotal;
						}
					}
				}
				System.out.println("이름	총점");
				for (int i = 0 ; i < insertCount; i++) {
					System.out.println(tempArray[i][0] + "	" + total[i]+"점");
				}
			} else if(select == 4) {
				// 과목별 통계
				System.out.println("과목별 통계입니다.");
				if (insertCount == 0) {
					System.out.println("입력된 학생이 없습니다.");
					continue;
				}
				
				System.out.println("과목을 선택해주세요. 1.국어  2.영어  3.수학");
				System.out.print("> ");
				String subject = scanner.next();
				
				int index = 0;
				String subjectName = "";
				
				if(subject.equals("1")) {
					index = 1;
					subjectName = "국어";
				} else if (subject.equals("2")) {
					index = 2;
					subjectName = "영어";
				} else if (subject.equals("3")) {
					index = 3;
					subjectName = "수학";
				} else {
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
				
				// 임시 Array 생성 및 students 복사
				// Subject score Array 생성
				String[][] tempArray = students;
				int[] subjectScore = new int[insertCount];
				for (int i = 0; i < insertCount; i++) {
					subjectScore[i] += Integer.parseInt(tempArray[i][index]);
				}
				
				for (int i = 0; i < insertCount - 1; i++) {
					for (int j = i + 1; j < insertCount ; j++) {
						if (subjectScore[i] > subjectScore[j]) {
							String[] temp = tempArray[i];
							tempArray[i] = tempArray[j];
							tempArray[j] = temp;
							int scoreTemp = subjectScore[i];
							subjectScore[i] = subjectScore[j];
							subjectScore[i] = scoreTemp;
						}
					}
				}
				System.out.println("이름	" + subjectName);
				for (int i = 0 ; i < insertCount; i++) {
					System.out.println(tempArray[i][0] + "	" + subjectScore[i]+"점");
				}
				
				
				
				
			} else if(select == 5) {
				// 학생별 성적
				System.out.println("학생별 성적입니다.");
				if (insertCount == 0) {
					System.out.println("입력된 학생이 없습니다.");
					continue;
				}
				
				System.out.println("학생 이름을 입력해주세요.");
				System.out.print("> ");
				String name = scanner.next();
				int index = -1;
				for (int i = 0 ; i < insertCount ; i++) {
					if (students[i][0].equals(name)) {
						index = i;
						break;
					}
				}
				
				if(index >= 0) {
					System.out.println(name + " 학생의 성적입니다.");
					System.out.println("국어	영어	수학");
					for(int i = 1; i < 4 ; i++) {
						System.out.print(students[index][i] + "	");
					}
					System.out.println();
				} else {
					System.out.println("해당 학생이 존재하지 않습니다.");
				}
				
				
			} else if(select == 6) {
				break;
			}
		}
		System.out.println("사용해주셔서 감사합니다.");
		scanner.close();		
	}
}
