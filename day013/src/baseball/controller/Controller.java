package baseball.controller;

import baseball.model.Human;

public class Controller {
	private Human[] humanArr = new Human[20];
	private int memberCount;
	private DataProc file;
	
	public Controller() {
		file = new DataProc("temp");
		file.dataLoad();
	}
	
	public void insert() {
		
	}
	
	public void delete() {
		
	}
	
	public void select() {
		
	}
	
	public void update() {
		
	}
	
	public void allPrint() {
		
	}
	
	public void dataSave() {
		file.dataSave();
	}
	
	public boolean checkSpace() {
		return memberCount < humanArr.length; 
	}
}
