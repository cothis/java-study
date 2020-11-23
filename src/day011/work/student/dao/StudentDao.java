package day011.work.student.dao;

import java.util.Arrays;
import java.util.Scanner;

import day011.work.student.model.Student;

public class StudentDao {
	Scanner sc = new Scanner(System.in);
	Student[] studentArray = null;
	int count = 0;
	
	public StudentDao(int capacity) {
		studentArray = new Student[capacity];
	}
	
	private String inputString(String message) { 
		String str = null;
		while(true) {
			System.out.print(message);
			str = sc.next();
			if(!str.trim().equals("")) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		return str;
	}
	
	private void printNames(String[] nameArray) {
		String result = "";
		int w = 0;
		while(nameArray[w] != null) {
			if (w == 0) {
				result = "[ ";
			} else {
				result = result + ", ";
			}
			result = result + nameArray[w];
			w++;
		}
		result = result + " ]";
		System.out.println(result);
	}

	private void printIndexes(int[] indexes) {
		String result = "";
		for(int i = 0; i < indexes.length; i++) {
			if (i == 0) {
				result = "해당 학생번호 : [ ";
			} else {
				result = result + ", ";
			}
			result = result + (indexes[i] + 1);
		}
		result = result + " ]";
		System.out.println(result);
	}
	
	private boolean hasNumber(int number) {
		boolean result = false;
		for(int i = 0; i < count; i++) {
			if (number == studentArray[i].getNumber()) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private int inputNumber(String message) {
		return inputNumber(message, false);
	}
	
	private int inputNumber(String message, boolean checkRange) {
		int score;
		while(true) {
			System.out.print(message);
			try {
				score = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.nextLine();
				continue;
			}
			if(score < 0 || score > 100) {
				System.out.println("0 ~ 100 사이를 입력해주세요.");
			} 
			else {
				break;
			}
		}
		return score;
	}

	private int selectByName() {
		// 학생 이름 리스트 표시
		String[] nameArray = getStudentsName();
		printNames(nameArray);
		int index = -1;
		int[] indexes = new int[count];
		for(int i = 0; i < indexes.length; i++) {
			indexes[i] = -1;
		}
		int equalCount = 0;
		
		while(true) {
			System.out.println("학생 이름을 입력해주세요.");
			String name = inputString("이름: ");
			for (int i = 0; i < count; i++) {
				if (nameArray[i].equals(name)) {
					index = i;
					indexes[equalCount] = i;
					equalCount++;
				}
			}
			
			if (equalCount == 0) {
				System.out.println("해당 학생이 존재하지 않습니다.");
			} 
			 else if (equalCount == 1) {
				break;
			} else {
				System.out.println("해당 학생이 여러명 존재합니다.");
				index = selectByNumber(indexes);
				break;
			}
		}
		return index;
	}

	private int selectByNumber(int[] indexes) {
		int index = -1;
		while(true) {
			System.out.println("학생 번호를 입력해주세요.");
			printIndexes(indexes);
			System.out.print("번호: ");
			try {
				index = sc.nextInt() - 1;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.nextLine();
				continue;
			}
			boolean hasNumber = false;
			for (int i = 0; i < indexes.length; i++) {
				if (index == indexes[i]) {
					hasNumber = true;
					break;
				}
			}
			if (hasNumber) {
				break;
			} else {
				System.out.println("리스트에서 맞는 번호를 선택해주세요.");
			}
		}
		return index;
	}
	
	private String[] getStudentsName() {
		String[] nameArray = new String[studentArray.length];
		for(int i = 0; i < studentArray.length; i++) {
			nameArray[i] = studentArray[i] == null ? null : studentArray[i].getName();
		}
		return nameArray;
	}
	
	private boolean isEmpty() {
		if (count == 0) {
			System.out.println("등록된 학생이 존재하지 않습니다.");
		}
		return count == 0;
	}
	
	// CRUD
	// 추가, 삭제, 검색, 수정
	public void insert() { // Create
		// 학생 정보 추가
		if(count < studentArray.length) {
			int number;
			String name;
			int kor;
			int eng;
			int math;
			
			System.out.println("학생 정보 입력");
			// 학생 번호 입력
			while (true) {
				number = inputNumber("번호: ");
				if (hasNumber(number)) {
					System.out.println("이미 존재하는 번호입니다.");
				}
				else {
					break;
				}
			}
			// 학생 이름 입력
			name = inputString("이름: ");
			// 국어 점수 입력
			kor = inputNumber("국어: ", true);
			// 영어 점수 입력
			eng = inputNumber("영어: ", true);
			// 수학 점수 입력
			math = inputNumber("수학: ", true);
			
			Student st = new Student(number, name, kor, eng, math);
			studentArray[count] = st;
			System.out.println("학생 정보가 추가되었습니다.");
			count++;
		} 
		else {
			System.out.println("학생 정보 입력공간이 다 찼습니다.");
		}
		
		System.out.println(Arrays.toString(studentArray));
		
	}
	
	public void remove() { // Remove
		// 학생 정보 제거
		if(isEmpty()) return;
			
		int index = selectByName();
		// 삭제
		for(int i = index; i < count - 1; i++) {
			studentArray[i] = studentArray[i + 1];
		}
		studentArray[count - 1] = null;
		count--;
		System.out.println("학생이 삭제되었습니다.");
		System.out.println(Arrays.toString(studentArray));
	}
	
	public void select() { // Read
		// 학생 정보 읽기
		if (isEmpty()) return;
		
		int index = selectByName();
		Student selectedStudent = studentArray[index];
		System.out.println(selectedStudent);
	}
	
	public void update() { // Update
		// 학생 정보 수정
		if (isEmpty()) return;
		
		int index = selectByName();
		Student selectedStudent = studentArray[index];
		int kor = inputNumber("국어: ");
		// 영어 점수 입력
		int eng = inputNumber("영어: ");
		// 수학 점수 입력
		int math = inputNumber("수학: ");
		
		selectedStudent.setKor(kor);
		selectedStudent.setEng(eng);
		selectedStudent.setMath(math);
		System.out.println("학생 정보가 변경되었습니다.");
	}
	
	private void swap(Student[] arr, int i, int j) {
		Student temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public Student[] sort() {
		// by 1:number, 2:name, 3:kor, 4:eng, 5:math
		Student[] sorted;
		sorted = Arrays.copyOf(studentArray, count);
		
		System.out.println("정렬 기준(1:number, 2:name, 3:kor, 4:eng, 5:math)");
		int by = inputNumber("> ");
		
		for(int i = 0 ; i < sorted.length - 1; i++) {
			for(int j = i; j < sorted.length; j++) {
				switch(by) {
					case 1:
					{
						if (sorted[i].getNumber() > sorted[j].getNumber()) {
							swap(sorted, i, j);
						}
						break;
					}
					case 2:
					{
						if (sorted[i].getName().hashCode() > sorted[j].getName().hashCode()) {
							swap(sorted, i, j);
						}
						break;
					}
					case 3:
					{
						if (sorted[i].getKor() > sorted[j].getKor()) {
							swap(sorted, i, j);
						}
						break;
					}
					case 4:
					{
						if (sorted[i].getEng() > sorted[j].getEng()) {
							swap(sorted, i, j);
						}
						break;
					}
					case 5:
					{
						if (sorted[i].getMath() > sorted[j].getMath()) {
							swap(sorted, i, j);
						}
						break;
					}
				} // switch
			}
		}
		
		
		return sorted;
	}
	
	public void list() {
		if (isEmpty()) return;
		Student[] sortedList = sort();
		for (Student student : sortedList) {
			System.out.println(student);
		}
	}
	
	public void close() {
		sc.close();
	}
}
