package day011.work.blackjack;

public class User {
	int[] card = new int[50];
	int coin = 10000;
	int count = 0;
	boolean stay = false;
	
	public void receiveCard(int card) {
		this.card[count] = card;
		count++;
	}
	
	public boolean canChoice() {
		return false;
	}
	
	public int getSum() {
		int sum = 0;
		for(int i = 0 ; i < count ; i++) {
			sum += card[i];
		}
		return sum;
	}
	
	public void setStay() {
		stay = true;
	}
	
	public int[] getCards() {
		int[] presentCard = new int[count];
		for(int i = 0 ; i < count; i++) {
			presentCard[i] = card[i];
		}
		return presentCard;
	}
}

class Player extends User {
	public boolean canChoice() {
		return getSum() < 21 && !stay;
	}
}

class Dealer extends User {
	public boolean canChoice() {
		if(getSum() >= 17) {
			return false;
		}
		else {
			return true;
		}
	}
}
