package day011.work.dice;

public class DiceController {
	private Dice d1;
	private Dice d2;
	private int answer;
	private int userPredict;
	private int userCoin;
	private int refund;
	private int baedang;	
	
	public DiceController() {
		d1 = new Dice();
		d2 = new Dice();
	}
	
	public int getRefund() {
		return refund;
	}
	
	public void rollDices() {
		d1.roll();
		d2.roll();
		answer = d1.getDiceNumber() + d2.getDiceNumber();
	}
	
	public void setCoin(int coin) {
		this.userCoin = coin;
	}
	
	public boolean setUserPredict(int userPredict) {
		if(userPredict == 2 || userPredict == 12) {
			return false;
		}
		this.userPredict = userPredict;
		return true;
	}
	
	public int getAnswer() {
		return answer;
	}
	
	public int checkAnswer() {
		if(userPredict == answer) {
			if (userPredict == 3 || userPredict == 11)
				baedang = 18;
			else if (userPredict == 4 || userPredict == 10)
				baedang = 12;
			else if (userPredict == 5 || userPredict == 9)
				baedang = 9;
			else if (userPredict == 6 || userPredict == 8)
				baedang =  7;
			else
				baedang =  6;
		} else {
			baedang = 0;
		}
		refund = userCoin * baedang;
		return refund;
	}
	
	public int getBaedang() {
		return baedang;
	}
}
