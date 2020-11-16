package work.blackjack;

public class CardDeck {
	int[] card;
	int count = 0;
	
	public CardDeck() {
		card = new int[13*4]; // 1~10, j,q,k 4종
		for(int i = 0; i < card.length; i++) {
			card[i] = (i / 4) + 1;
		}
	}
	
	public void shuffle() {
		boolean[] swit = new boolean[card.length];
		
		int w = 0;
		while(w < card.length) {
			int index = (int) (Math.random() * card.length);
			if (swit[index] == false) {
				swit[index] = true;
				int tmp = card[w];
				card[w] = card[index];
				card[index] = tmp;
				w++;
			}
		}
	}
	
	public int withdrawCard() {
		int c = card[count];
		count++;
		return c;
	}
}
