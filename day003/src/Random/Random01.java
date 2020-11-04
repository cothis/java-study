package Random;

public class Random01 {
	public static void main(String[] args) {
		/*
		 * random : 난수, 무작위  <-> pattern
		 * 
		 */
		
		int randNum;
		randNum = (int) (Math.random() * 10); // 0 ~ 9
		System.out.println("randNum = " + randNum);
		
		randNum = (int) (Math.random() * 10) + 10; // 10 ~ 19
		System.out.println("randNum = " + randNum);
		
		randNum = ((int) (Math.random() * 5) + 1 ) * 10; // 10, 20, 30, 40, 50
		System.out.println("randNum = " + randNum);
		
		randNum = (int) (Math.random() * 3) - 1; // -1 0 1
		System.out.println("randNum = " + randNum);
		
		// 11 23 14 56 78
		int randArrNum[] = { 11, 23, 14, 56, 78 };
		randNum = (int) (Math.random() * 5); // 0 ~ 4
		System.out.println(randArrNum[randNum]);
		
		
		
	}
}
