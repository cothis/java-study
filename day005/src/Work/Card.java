package Work;

public class Card {
	final static int NUMBER_OF_PICK = 4;
	public static void main(String[] args) {
		// 카드 : 0 ~ 51
		/* 
		 * 1 ~ 10 J Q K (4벌)
		 * 1 ~ 10(11 12 13)
		 * 
		 * 0 ~ 12 : 스페이드
		 * 13 ~ 25 : 다이아
		 * 26 ~ 38 : 하트
		 * 39 ~ 51 : 클로버
		 * 
		 * 랜덤숫자가 1이면 -> 2 스페이드
		 * 51 -> 13(K) 클로버
		 */
		
		int[] cards = new int[NUMBER_OF_PICK];
		boolean[] select = new boolean[52];
		
		// 카드 섞고 NUMBER_OF_PICK 만큼 뽑기
		int loopCount = 0;
		while(loopCount < NUMBER_OF_PICK) {
			int randomNumber = (int) (Math.random() * 52);
			if (select[randomNumber] == false) {
				select[randomNumber] = true;
				cards[loopCount] = randomNumber + 1;
				loopCount++;
			}
		}
		
		for (int i = 0 ; i < NUMBER_OF_PICK; i++) {	
			int card = cards[i];
			int type = card / 13; // 0: 스페이드, 1: 다이아, 2: 하트, 3: 클로버
			int number = card % 13 + 1;
			
			System.out.print("당신의 카드는 ");
			if (number <= 10) {
				System.out.print(number);
			} else if (number == 11){
				System.out.print("J");
			} else if (number == 12){
				System.out.print("Q");
			} else if (number == 13){
				System.out.print("K");
			} else {
				System.out.print("Error");
			}
			
			switch(type) {
				case 0:
					System.out.print(" 스페이드");
					break;
				case 1:
					System.out.print(" 다이아");
					break;
				case 2:
					System.out.print(" 하트");
					break;
				case 3:
					System.out.print(" 클로버");
					break;
				default:
					System.out.print(" 에러");
					break;
			}
			
			System.out.println();
		}
		
	}
}
