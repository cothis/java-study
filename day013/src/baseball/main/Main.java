package baseball.main;

import java.util.Scanner;

import baseball.controller.Controller;
import baseball.model.Batter;
import baseball.model.Human;
import baseball.model.Pitcher;

public class Main {
	Controller controller = new Controller();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Main view = new Main();
		view.close();
	}
	
	public Main() {
		init();
		
		menu();
	}
	
	private void init() {
		System.out.println("야구 회원 관리 시스템입니다.");
	}
	
	public void close() {
		sc.close();
		System.out.println("프로그램이 종료됩니다.");
	}
	
	private void printWrongMessage() {
		System.out.println("잘 못 입력하셨습니다.");
	}
	
	private int getUserInt(String message) {
		int number;
		while (true) {
			try {
				System.out.println(message);
				System.out.print("> ");
				number = sc.nextInt();
			} catch (Exception e) {
				printWrongMessage();
				sc.nextLine();
				continue;
			}
			break;
		}
		return number;
	}
	
	private double getUserDouble(String message) {
		double number;
		while (true) {
			try {
				System.out.println(message);
				System.out.print("> ");
				number = sc.nextDouble();
			} catch (Exception e) {
				printWrongMessage();
				sc.nextLine();
				continue;
			}
			break;
		}
		return number;
	}
	
	private void menu() {
		int choice;
		while(true) {
			choice = getUserInt("1.선수 등록  2.선수 삭제  3.선수 검색  4.선수 수정  5.선수 모두 출력  6.데이터 저장  7.종료");
			
			switch (choice) {
				case 1: {
					insert();
					break;
				}
				case 2: {
					delete();
					break;
				}
				case 3: {
					select();
					break;
				}
				case 4: {
					update();
					break;
				}
				case 5: {
					allPrint();
					break;
				}
				case 6: {
					dataSave();
					break;
				}
				case 7: {
					break;
				}
				default: {
					System.out.println("해당 항목이 존재하지 않습니다.");
					break;
				}
			}// switch
			if(choice == 7) {
				break;
			}
		}//while
	}//menu
	
	private String getUserStr(String message) {
		String str;
		while (true) {
			try {
				System.out.println(message);
				System.out.print("> ");
				str = sc.next();
			} catch (Exception e) {
				printWrongMessage();
				continue;
			}
			if(str.trim().equals("")) {
				printWrongMessage();
				continue;
			}
			break;
		}
		return str;
	}
	
	private void insert() {
		System.out.println("선수 등록 화면입니다.");
		if(!controller.checkSpace()) {
			System.out.println("공간이 부족합니다.");
			return;
		}
		Human human;
		
		System.out.println("선수 타입을 입력해주세요.");
		int type;
		while(true) {
			type = getUserInt("1.투수  2.타자");
			if (type == 1 || type == 2) {
				break;
			}
			System.out.println("잘못 입력하셨습니다.");
		}
		
		int number = getUserInt("선수 번호");
		String name = getUserStr("선수 이름");
		int age = getUserInt("선수 나이");
		double height = getUserDouble("선수 키");
		
		if (type == 1) {
			// 투수
			int win = getUserInt("승리 횟수");
			int lose = getUserInt("패배 횟수");
			double defence = getUserDouble("방어율");
			
			human = new Pitcher(number, name, age, height, win, lose, defence);
			
		} else {
			// 타자
			int hitCount = getUserInt("타수");
			int hits = getUserInt("안타수");
			double battingAve = getUserDouble("타율");
			
		}
		
		
		
		
		controller.insert();
	}
	
	private void delete() {
		System.out.println("선수 삭제 화면입니다.");
		controller.delete();
	}

	private void select() {
		System.out.println("선수 검색 화면입니다.");
		controller.select();
	}
	
	private void update() {
		System.out.println("선수 수정 화면입니다.");
		controller.update();
	}
	
	private void allPrint() {
		System.out.println("선수 전체 출력 화면입니다.");
		controller.allPrint();
	}
	
	private void dataSave() {
		System.out.println("선수 데이터를 저장합니다.");
		controller.dataSave();
	}
}
