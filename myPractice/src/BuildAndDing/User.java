package BuildAndDing;

public class User {
	private String name;
	private int money;
	private int[] cards;
	private boolean play;
	final static int MONEY = 1000;
	
	public User() {
		this("default user", MONEY);
	}
	public User(String name, int money) {
		this.name = name;
		this.money = money;
		this.play = false;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int[] getCards() {
		return cards;
	}
	public void setCards(int[] cards) {
		this.cards = cards;
	}
	public boolean isPlay() {
		return play;
	}
	public String toString() {
		String str = name + ", " + money + ", card : [";
		for(int i = 0 ; i < cards.length ; i++) {
			if (i != 0) {
				str = str + ", ";
			} 
			str = str + cards[i];
		}
		return str + "]"; 
	}
}
