package day013.baseball.main;

import java.util.Scanner;

import day013.baseball.controller.Controller;
import day013.baseball.model.Batter;
import day013.baseball.model.Human;
import day013.baseball.model.Pitcher;

public class Main {
	Controller controller = new Controller();
	Scanner sc = new Scanner(System.in);
	final boolean DEV = false;
	public final static int ERR_WRONG = 1;
	public final static int ERR_REDUNDANT = 2;
	public final static int ERR_RANGE = 3;
	public final static int ERR_EMPTY = 4;
	public final static int ERR_FILE_WRITE = 5;
	public final static int ERR_ARRAY_EMPTY = 6;
	public final static int ERR_FILE_NOT_EXIST = 7;
	public final static int ERR_FILE_READ = 8;
	
	public static void main(String[] args) {
		Main view = new Main();
		view.close();
	}
	
	public Main() {
		init();
		if (DEV) testInput();
		
		menu();
	}
	
	private void testInput() {
		Human human = new Batter(1, "홍길동", 23, 183.2, 3, 4, 0.8);
		controller.insert(human);
		human = new Pitcher(2, "일지매", 22, 168.3, 1, 2, 3.8);
		controller.insert(human);
		System.out.println("테스트 선수가 추가되었습니다.");
	}
	
	private void init() {
		System.out.println("야구 회원 관리 시스템입니다.");
	}
	
	public void close() {
		sc.close();
		System.out.println("프로그램이 종료됩니다.");
	}
		
	public static void printWrongMessage(int errorNumber) {
		switch(errorNumber) {
			case ERR_WRONG: {
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			case ERR_REDUNDANT: {
				System.out.println("중복된 데이터가 존재합니다.");
				break;
			}
			case ERR_RANGE: {
				System.out.println("범위가 잘못되었습니다.");
				break;
			}
			case ERR_EMPTY: {
				System.out.println("데이터가 존재하지 않습니다.");
				break;
			}
			case ERR_FILE_WRITE: {
				System.out.println("파일 쓰기가 불가능합니다.");
				break;
			}
			case ERR_ARRAY_EMPTY: {
				System.out.println("배열이 비거나 nul입니다.");
				break;
			}
			case ERR_FILE_NOT_EXIST: {
				System.out.println("파일이 존재하지 않습니다.");
				break;
			}
			case ERR_FILE_READ: {
				System.out.println("파일 읽기가 불가능합니다.");
				break;
			}
			default: {
				System.out.println("알수 없는 에러가 발생했습니다.");
				break;
			}
		}
	}
	
	private int getUserInt(String message, int min, int max) {
		int number;
		while (true) {
			try {
				System.out.println(message);
				System.out.print("> ");
				number = sc.nextInt();
			} catch (Exception e) {
				printWrongMessage(ERR_WRONG);
				sc.nextLine();
				continue;
			}
			if(number >= min && number <= max) {
				break;
			} 
			else {
				printWrongMessage(ERR_RANGE);
			}
		}
		return number;
	}
	
	private double getUserDouble(String message, double min, double max) {
		double number;
		while (true) {
			try {
				System.out.println(message);
				System.out.print("> ");
				number = sc.nextDouble();
			} catch (Exception e) {
				printWrongMessage(ERR_WRONG);
				sc.nextLine();
				continue;
			}
			if(number >= min && number <= max) {
				break;
			}
			else {
				printWrongMessage(ERR_RANGE);
			}
		}
		return number;
	}
	
	private void menu() {
		int choice;
		while(true) {
			choice = getUserInt("1.선수 등록  2.선수 삭제  3.선수 검색  4.선수 수정  5.선수 모두 출력  6.데이터 저장  7.종료", 1, 7);
			
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
				printWrongMessage(ERR_WRONG);
				continue;
			}
			if(str.trim().equals("")) {
				printWrongMessage(ERR_WRONG);
				continue;
			}
			break;
		}
		return str;
	}
	
	private int getHaveOrNotUserInt(String message, int min, int max, boolean have) {
		int number = 0;
		while(true) {
			number = getUserInt(message, min, max);
			if(hasNumber(number) == have) {
				break;
			}
			else if(have){
				printWrongMessage(ERR_EMPTY);
			} else {
				printWrongMessage(ERR_REDUNDANT);
			}
		}
		return number;
	}
	
	private boolean hasNumber(int number) {
		return controller.hasNumber(number);
	}
	
	private void insert() {
		System.out.println("선수 등록 화면입니다.");
		if(!controller.checkSpace()) {
			System.out.println("공간이 부족합니다.");
			return;
		}
		
		Human human;
		System.out.println("선수 타입을 입력해주세요.");
		while(true) {
			int type = getUserInt("1.투수  2.타자", 1, 2);
			if (type == 1) {
				human = new Pitcher();
				break;
			} else if (type == 2) {
				human = new Batter();
				break;
			}
			System.out.println("잘못 입력하셨습니다.");
		}
		
		inputInfo(human);
		
		controller.insert(human);
		System.out.println("선수가 추가되었습니다.");
		
		allPrint();
	}

	private void inputInfo(Human human) {
		int number = getHaveOrNotUserInt("선수 번호", 1, Integer.MAX_VALUE, false);
		human.setNumber(number);
		inputInfoWithoutNumber(human);
	}
	
	private void inputInfoWithoutNumber(Human human) {
		String name = getUserStr("선수 이름");
		int age = getUserInt("선수 나이", 1, Integer.MAX_VALUE);
		double height = getUserDouble("선수 키", 1, Double.MAX_VALUE);
		
		human.setName(name);
		human.setAge(age);
		human.setHeight(height);
		
		if (human instanceof Pitcher) {
			// 투수
			Pitcher p = (Pitcher) human;
			int win = getUserInt("승리 횟수", 0, Integer.MAX_VALUE);
			int lose = getUserInt("패배 횟수", 0, Integer.MAX_VALUE);
			double defence = getUserDouble("방어율", 0, Double.MAX_VALUE);
			
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
			
		} else if (human instanceof Batter) {
			// 타자
			Batter b = (Batter) human;
			int hitCount = getUserInt("타수", 0, Integer.MAX_VALUE);
			int hits = getUserInt("안타수", 0, Integer.MAX_VALUE);
			double battingAve = getUserDouble("타율", 0, Double.MAX_VALUE);
			
			b.setHitCount(hitCount);
			b.setHits(hits);
			b.setBattingAve(battingAve);
		}
	}
	
	private void delete() {
		System.out.println("선수 삭제 화면입니다.");
		int choice = getHaveOrNotUserInt("선수 번호", 1, Integer.MAX_VALUE, true);
		
		controller.delete(choice);
		System.out.println("선수가 삭제되었습니다.");
		
		allPrint();
	}

	private void select() {
		System.out.println("선수 검색 화면입니다.");
		int choice = getHaveOrNotUserInt("선수 번호", 1, Integer.MAX_VALUE, true);
		
		Human human = controller.select(choice);
		System.out.println(human);
	}
	
	private void update() {
		System.out.println("선수 수정 화면입니다.");
		int choice = getHaveOrNotUserInt("선수 번호", 1, Integer.MAX_VALUE, true);
		Human human = controller.select(choice);
		
		inputInfoWithoutNumber(human);
		
		controller.update(choice, human);
		System.out.println("선수 정보가 수정되었습니다.");
	}
	
	private void allPrint() {
		System.out.println("선수 전체 출력 화면입니다.");
		Human[] list = controller.allPrint();
		for (Human human : list) {
			System.out.println(human);
		}
	}
	
	private void dataSave() {
		System.out.println("선수 데이터를 저장합니다.");
		controller.dataSave();
		System.out.println("선수 데이터를 저장했습니다.");
	}
}
