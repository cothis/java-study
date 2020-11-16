package work.student.view;

import java.util.Scanner;

import work.student.dao.StudentDao;

public class View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//메뉴(view)
		
		StudentDao stDao = new StudentDao(10);
		
		while(true) {
			System.out.println("1. 학생정보 추가");
			System.out.println("2. 학생정보 삭제");
			System.out.println("3. 학생정보 검색");
			System.out.println("4. 학생정보 수정");
			System.out.println("5. 종료");
			System.out.println("어느 작업을 하시겠습니까?");
			System.out.print("> ");
			int select = 0;
			try {
				select = sc.nextInt();
			} catch (Exception e) {
				System.out.println("잘못입력하셨습니다.");
				sc.nextLine();
				continue;
			}
			
			switch (select) {
				case 1: { // 학생정보 추가
					stDao.insert();
					break;					
				}
				case 2: { // 학생정보 삭제
					stDao.remove();
					break;					
				}
				case 3: { // 학생정보 검색
					stDao.select();
					break;					
				}
				case 4: { // 학생정보 수정
					stDao.update();
					break;					
				}
				default: {
					break;
				}
			}
			
			if(select == 5) {
				break;
			}
		} // while
	}
}
