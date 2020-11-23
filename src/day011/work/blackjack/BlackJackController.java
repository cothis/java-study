package day011.work.blackjack;

import java.util.Arrays;

public class BlackJackController {
	CardDeck cardDeck = new CardDeck();
	User player = new Player();
	User dealer = new Dealer();
	
	public BlackJackController() {
		cardDeck.shuffle();
	}
	
	public void firstDraw() {
		// 각각 두장씩 건네주기
		for (int i = 0 ; i < 2; i++) {
			draw();
		}
	}
	
	public void draw() {
		int card;
		if(player.canChoice()) {
			card = cardDeck.withdrawCard();
			player.receiveCard(card);
		}
		if(dealer.canChoice()) {
			card = cardDeck.withdrawCard();
			dealer.receiveCard(card);
		}
	}
	
	public static void main(String[] args) {
		BlackJackController bc = new BlackJackController();
		bc.cardDeck.shuffle();
		System.out.println(Arrays.toString(bc.cardDeck.card));
	}
	
	public int result() {
		// 0 : blackjack(21) 1.5배
		// 1 : bust 실패
		// 2 : push 비긴다
		// 3 : player > dealer : 이겼다
		// 4 : player < dealer : 졌다
		int playerSum = player.getSum();
		int dealerSum = dealer.getSum();
		if(playerSum == 21) {
			return 0;
		} else if(playerSum > 21) {
			return 1;
		} else if(playerSum == dealerSum) {
			return 2;
		} else if(playerSum > dealerSum) {
			return 3;
		} else if(playerSum < dealerSum) {
			return 4;
		}
		return -1;		
	}
}
