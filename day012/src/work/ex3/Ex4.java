package work.ex3;

public class Ex4 {
	public static void main(String[] args) {
		/*
		Marine ma = new Marine();
		Tank ta = new Tank();
		Dropship dr = new Dropship();
		*/
		Unit[] unitArray = new Unit[5];
		unitArray[0] = new Marine();
		unitArray[1] = new Marine();
		unitArray[2] = new Marine();
		unitArray[3] = new Tank();
		unitArray[4] = new Dropship();
		
		for (Unit unit : unitArray) {
			int x = (int)(Math.random() * 300);
			int y = (int)(Math.random() * 200);
			unit.move(x, y);
			unit.stop();
			if(unit instanceof Marine) {
				((Marine)unit).stimPack();
			} else if (unit instanceof Tank ) {
				((Tank)unit).changeMode();
			} else if (unit instanceof Dropship) {
				((Dropship)unit).load();
			}
		}
		
		
	}
}

class Unit {
	int x, y;
	void move(int x, int y) {
		System.out.println("x = " + x + " y = " + y);
	}
	void stop() {
		System.out.println("멈췄습니다.");
	}
}

class Marine extends Unit { // 보병
	void stimPack() { 
		/*스팀팩을 사용한다.*/
		System.out.println("스팀팩!");		
	}
}

class Tank extends Unit { // 탱크
	void changeMode() { 
		/*공격모드를 변환한다.*/
		System.out.println("모드 변환!");
	} 
}

class Dropship extends Unit { // 수송선
	void load() { 
		/*선택된 대상을 태운다.*/ 
		System.out.println("태운다");
	}
	void unload() { 
		/*선택된 대상을 내린다.*/ 
		System.out.println("내린다");
	}
}