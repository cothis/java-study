package baseball.controller;

import java.util.Arrays;

import baseball.main.Main;
import baseball.model.Batter;
import baseball.model.Human;
import baseball.model.Pitcher;

public class Controller {
	private Human[] humanArr = new Human[20];
	private int memberCount;
	private DataProc file = new DataProc();
	
	public int getMemberCount() {
		return memberCount;
	}

	public Controller() {
		file.CreateFile("baseball");
		dataLoad();
		System.out.println("data loaded");
	}
	
	private void dataLoad() {
		String[] array = null;
		try {
			array = file.dataLoad();
		} catch (Exception e) {
			Main.printWrongMessage(Main.ERR_FILE_READ);
		}
		for (int i = 0; i < array.length; i++) {
			Human h = strToHuman(array[i]);
			humanArr[i] = h;
		}
		memberCount = array.length;
	}
	
	private Human strToHuman(String stringObj) {
		Human human = null;
		String[] elements = stringObj.split(",");
		for(int i = 0 ; i < elements.length; i++) {
			elements[i] = elements[i].substring(elements[i].indexOf(":") + 1).trim();
		}
		int type = Integer.parseInt(elements[0]);
		int number = Integer.parseInt(elements[1]);
		String name = elements[2];
		int age = Integer.parseInt(elements[3]);
		double height = Double.parseDouble(elements[4]);
		if(type == 1) {
			int win = Integer.parseInt(elements[5]);
			int lose = Integer.parseInt(elements[6]);
			double defence = Double.parseDouble(elements[7]);
			human = new Pitcher(number, name, age, height, win, lose, defence);
		}
		else if (type == 2) {
			int hitCount = Integer.parseInt(elements[5]);
			int hits = Integer.parseInt(elements[6]);
			double battAverage = Double.parseDouble(elements[7]);
			human = new Batter(number, name, age, height, hitCount, hits, battAverage);
		}
		
		return human;
	}
	
	public boolean hasNumber(int number) {
		boolean res = false;
		for(int i = 0 ; i < memberCount; i++) {
			if (humanArr[i].getNumber() == number) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public void insert(Human newHuman) {
		humanArr[memberCount] = newHuman;
		memberCount++;
	}
	
	public void delete(int number) {
		for(int i = number - 1; i < memberCount; i++) {
			humanArr[i] = humanArr[i + 1];
		}
		memberCount--;
		humanArr[memberCount] = null;
	}
	
	public Human select(int number) {
		return humanArr[number - 1];
	}
	
	public void update(int number, Human updatedHuman) {
		humanArr[number] = updatedHuman;
	}
	
	public Human[] allPrint() {
		Human[] res = Arrays.copyOf(humanArr, memberCount);
		return res;
	}
	
	public void dataSave() {
		String[] array = new String[memberCount];
		for(int i = 0; i < memberCount; i++) {
			int type = 0;
			if(humanArr[i] instanceof Pitcher) {
				type = 1;
			} else if (humanArr[i] instanceof Batter) {
				type = 2;
			}
			array[i] = "type: " + type + ", "+ humanArr[i].toString();
		}
		file.dataSave(array, false);
	}
	
	public boolean checkSpace() {
		return memberCount < humanArr.length; 
	}

	public Human[] getRating(int type) {
		Human[] src = new Human[memberCount];
		int index = 0;
		for(int i = 0; i < memberCount; i++) {
			if((humanArr[i] instanceof Pitcher && type == 1) || (humanArr[i] instanceof Batter && type == 2)) {
				src[index] = humanArr[i];
				index++;
			}
		}
		Human[] res = Arrays.copyOf(src, index);
		for(int i = 0; i < res.length - 1; i++) {
			for(int j = i; j < res.length; j++) {
				if(type == 1) {
					Pitcher pi = (Pitcher)res[i];
					Pitcher pj = (Pitcher)res[j];
					if(pi.getDefence() > pj.getDefence()) {
						swap(res, i, j);
					}
				}
				else if (type == 2) {
					Batter bi = (Batter)res[i];
					Batter bj = (Batter)res[j];
					if(bi.getBattingAve() < bj.getBattingAve()) {
						swap(res, i, j);
					}
				}
			}//for j
		}// for i
		
		return res;
	}
	
	private void swap(Human[] human, int i, int j) {
		Human tmp = human[i];
		human[i] = human[j];
		human[j] = tmp;
	}
	
}
