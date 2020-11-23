package day011.work.dice;

public class Dice {
	private int diceNumber;
	
	public Dice() {
		roll();
	}
	
	public void roll() {
		diceNumber = (int)(Math.random() * 6) + 1;
	}
	
	public int getDiceNumber() {
		return diceNumber;
	}
}
