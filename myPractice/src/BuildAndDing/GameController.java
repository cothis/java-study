package BuildAndDing;

import java.util.Arrays;

import BuildAndDing.*;

public class GameController {
	private User user;
	private User[] computers; 
	private int[] deck;
	final static int BETTING_COST = 100;
	
	public GameController(String name) {
		this(name, 3);
	}
	
	public GameController(String name, int pcNumber) {
		this.computers = new User[pcNumber];
		for (int i = 0; i < pcNumber; i++) {
			computers[i] = new User("test" + (i + 1), User.MONEY);
		}
		this.user = new User(name, 100);
		
		deck = new int[20];
	}
	
	public User getUser() {
		return user;
	}
	
	public void makeCards() {
		// 인당 5장의 화투패
		// 총 20장 가지고 진행
		boolean[] isShuffled = new boolean[20];
		int i = 0;
		while(i < 20) {
			int random = (int) (Math.random() * 20);
			if (isShuffled[random] == false) {
				isShuffled[random] = true;
				deck[i] = random + 1;
				i++;
			}
		}
	}
	
	public void giveCards() {
		for(int i=0; i<4; i++) {
			User user;
			if(i == 0) {
				user = this.user;
			} else {
				user = computers[i - 1];
			}
			int[] cards;
			cards = Arrays.copyOfRange(deck, i * 5, (i * 5 + 5));
			user.setCards(cards);
			System.out.println(user);
		}
	}
	
	public boolean useMoney() {
		if(user.getMoney() < BETTING_COST) {
			return false;
		}
		user.setMoney(user.getMoney() - BETTING_COST);
		return true;
	}
	
	public void checkComputerPlay() {
		for (int i = 0; i < computers.length ; i++) {
			int[] cards = computers[i].getCards();
			for (int j = 0; j < cards.length; j++) {
				
			}
		}
	}
	
}
