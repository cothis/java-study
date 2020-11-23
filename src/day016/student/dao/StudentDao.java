package day016.student.dao;

import day016.student.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentDao {
	Scanner sc = new Scanner(System.in);
	List<Student> list = new ArrayList<>();

	public StudentDao(int capacity) {
		list = new ArrayList<>(capacity);
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
	
	private void printNames(List<String> nameList) {
		StringBuilder str = new StringBuilder();
		for(int i = 0 ; i < list.size(); i++) {
			if(i == 0 ) {
				str.append("[ ");
			} else {
				str.append(", ");
			}
			str.append(list.get(i).getName());
		}
		str.append(" ]");
		System.out.println(str);
	}

	private List<Integer> printIndexes(String name) {
		StringBuilder str = new StringBuilder();
		List<Integer> numberList = new ArrayList<>();
		str.append("[ ");
		for(int i = 0 ; i < list.size(); i++) {
			if(name.equals(list.get(i).getName())) {
				if(i != 0) {
					str.append(", ");
				}
				int number = list.get(i).getNumber();
				str.append(number);
				numberList.add(number);
			}
		}
		str.append(" ]");

		System.out.println(str);
		return numberList;
	}
	
	private boolean hasNumber(int number) {
		boolean result = false;
		for(int i = 0; i < list.size(); i++) {
			if (number == list.get(i).getNumber()) {
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
		List<String> nameList = getStudentsName();
		printNames(nameList);
		int index = -1;
		int equalCount = 0;
		
		while(true) {
			System.out.println("학생 이름을 입력해주세요.");
			String name = inputString("이름: ");
			for (int i = 0; i < list.size(); i++) {
				if (nameList.get(i).equals(name)) {
					index = i;
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
				index = selectByNumber(name);
				break;
			}
		}
		return index;
	}

	private int selectByNumber(String name) {
		int index = -1;
		while(true) {
			System.out.println("학생 번호를 입력해주세요.");
			List<Integer> numberList = printIndexes(name);
			System.out.print("번호: ");
			try {
				index = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				sc.nextLine();
				continue;
			}
			boolean hasNumber = false;
			if (numberList.contains((Object)index)) {
				hasNumber = true;
				break;
			}

			System.out.println("리스트에서 맞는 번호를 선택해주세요.");
		}
		return index-1;
	}
	
	private List<String> getStudentsName() {
		List<String> nameList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			nameList.add(list.get(i).getName());
		}
		return nameList;
	}
	
	private boolean isEmpty() {
		if (list.size() == 0) {
			System.out.println("등록된 학생이 존재하지 않습니다.");
		}
		return list.size() == 0;
	}
	
	// CRUD
	// 추가, 삭제, 검색, 수정
	public void insert() { // Create
		// 학생 정보 추가
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
		list.add(st);
		System.out.println("학생 정보가 추가되었습니다.");

		System.out.println(Arrays.toString(list.toArray()));
		
	}
	
	public void remove() { // Remove
		// 학생 정보 제거
		if(isEmpty()) return;
			
		int index = selectByName();
		// 삭제
		list.remove(index);
		System.out.println("학생이 삭제되었습니다.");
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	public void select() { // Read
		// 학생 정보 읽기
		if (isEmpty()) return;
		
		int index = selectByName();
		Student selectedStudent = list.get(index);
		System.out.println(selectedStudent);
	}
	
	public void update() { // Update
		// 학생 정보 수정
		if (isEmpty()) return;
		
		int index = selectByName();
		Student selectedStudent = list.get(index);
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
	
	private void swap(List<Student> list, int i, int j) {
		Student temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public List<Student> sort() {
		// by 1:number, 2:name, 3:kor, 4:eng, 5:math
		List<Student> sorted = list;

		System.out.println("정렬 기준(1:number, 2:name, 3:kor, 4:eng, 5:math)");
		int by = inputNumber("> ");
		
		for(int i = 0 ; i < sorted.size() - 1; i++) {
			for(int j = i; j < sorted.size(); j++) {
				switch(by) {
					case 1:
					{
						if (sorted.get(i).getNumber() > sorted.get(j).getNumber()) {
							swap(sorted, i, j);
						}
						break;
					}
					case 2:
					{
						if (sorted.get(i).getName().hashCode() > sorted.get(j).getName().hashCode()) {
							swap(sorted, i, j);
						}
						break;
					}
					case 3:
					{
						if (sorted.get(i).getKor() > sorted.get(j).getKor()) {
							swap(sorted, i, j);
						}
						break;
					}
					case 4:
					{
						if (sorted.get(i).getEng() > sorted.get(j).getEng()) {
							swap(sorted, i, j);
						}
						break;
					}
					case 5:
					{
						if (sorted.get(i).getMath() > sorted.get(j).getMath()) {
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
		List<Student> sortedList = sort();
		for (Student student : sortedList) {
			System.out.println(student);
		}
	}
	
	public void close() {
		sc.close();
	}
}
