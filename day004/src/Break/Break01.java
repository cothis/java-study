package Break;

public class Break01 {
	public static void main(String[] args) {
		/*
		 *  break: 탈출
		 *  	   loop문과 같이 사용
		 *         swtich case문 -> break
		 *         
		 *  for (int i = 0; i < 10; i++) {
		 *      if(i == 5) {
		 *          break;
		 *      }
		 *  }
		 */
		int n = 0;
		for (int i = 0; i < 100; i++) {
			System.out.println("i = " + i);
			if (i == 12) {
				n = i;
				break;
			}
		}
		System.out.println("n = " + n);
		
		char charArr[] = { 'A', 'B', 'C', 'D' };
		for (int i = 0; i < charArr.length; i++) {
			System.out.println(i + ":" + charArr[i]);
			if(charArr[i] == 'C') {
				System.out.println("C 문자를 찾았습니다.");
				break;
			}
		}
		
		// 바깥 for loop를 탈출하지 못했다
		for (int i = 0; i < 5; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < 4; j++) {
				System.out.println("  j = " + j);
				if (i == 3 && j == 2) {
					break;
				}
			}
		}
		
		// 탈출방법 1
		boolean b = false;
		for (int i = 0; i < 5; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < 4; j++) {
				System.out.println("  j = " + j);
				if (i == 3 && j == 2) {
					b = true;
				}
				if(b) {
					break;
				}
			}
			if(b) {
				break;
			}
		}
		
		// 탈출방법 2
		myLoopOut:for (int i = 0; i < 5; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j < 4; j++) {
				System.out.println("  j = " + j);
				if (i == 3 && j == 2) {
					break myLoopOut;
				}
			}
		}
		
	}
}






