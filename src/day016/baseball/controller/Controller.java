package day016.baseball.controller;

import day016.baseball.main.Main;
import day016.baseball.model.Batter;
import day016.baseball.model.Human;
import day016.baseball.model.Pitcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
	private List<Human> list = new ArrayList<>();
	private DataProc file = new DataProc();
	private static int id = 0;
	
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
		if(array != null && array.length != 0) {
			for (String s : array) {
				Human h = strToHuman(s);
				list.add(h);
			}
		}
	}
	
	private Human strToHuman(String stringObj) {
		Human human = null;
		String[] elements = stringObj.split(",");
		for(int i = 0 ; i < elements.length; i++) {
			elements[i] = elements[i].substring(elements[i].indexOf(":") + 1).trim();
		}

		int number = Integer.parseInt(elements[0]);
		String name = elements[1];
		int age = Integer.parseInt(elements[2]);
		double height = Double.parseDouble(elements[3]);
		if(number / 1000 == 1) {
			int win = Integer.parseInt(elements[4]);
			int lose = Integer.parseInt(elements[5]);
			double defence = Double.parseDouble(elements[6]);
			human = new Pitcher(number, name, age, height, win, lose, defence);
		}
		else if (number / 5000 == 1) {
			int hitCount = Integer.parseInt(elements[4]);
			int hits = Integer.parseInt(elements[5]);
			double battAverage = Double.parseDouble(elements[6]);
			human = new Batter(number, name, age, height, hitCount, hits, battAverage);
		}
		
		return human;
	}
	
	public boolean hasNumber(int number) {
		boolean res = false;
		for(int i = 0 ; i < list.size(); i++) {
			if (list.get(i).getNumber() == number) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public void insert(Human newHuman) {
		id++;
		int inputId = id;
		if(newHuman instanceof Pitcher) {
			inputId += 1000;
		}
		else if(newHuman instanceof Batter) {
			inputId += 5000;
		}
		newHuman.setNumber(inputId);
		list.add(newHuman);
	}
	
	public void delete(int number) {
		list.remove(select(number));
	}
	
	public Human select(int number) {
		for (Human human : list) {
			if(human.getNumber() == number) {
				return human;
			}
		}
		return null;
	}
	
	public void update(int number, Human updatedHuman) {
		list.set(number, updatedHuman);
	}
	
	public List<Human> allPrint() {
		return list;
	}
	
	public void dataSave() {
		String[] array = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			array[i] = list.get(i).toString();
		}
		file.dataSave(array, false);
	}
	
	public List<Human> getRating(int type) {
		List<Human> sorted = new ArrayList<>();

		for (Human human : list) {
			if ((human instanceof Pitcher && type == 1) || (human instanceof Batter && type == 2)) {
				sorted.add(human);
			}
		}
		for(int i = 0; i < sorted.size() - 1; i++) {
			for(int j = i; j < sorted.size(); j++) {
				if(type == 1) {
					Pitcher pi = (Pitcher)sorted.get(i);
					Pitcher pj = (Pitcher)sorted.get(j);
					if(pi.getDefence() > pj.getDefence()) {
						swap(sorted, i, j);
					}
				}
				else if (type == 2) {
					Batter bi = (Batter)sorted.get(i);
					Batter bj = (Batter)sorted.get(j);
					if(bi.getBattingAve() < bj.getBattingAve()) {
						swap(sorted, i, j);
					}
				}
			}//for j
		}// for i
		
		return sorted;
	}
	
	private void swap(List<Human> list, int i, int j) {
		Human tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
	
}
