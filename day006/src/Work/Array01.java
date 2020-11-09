package Work;

class Solution {
	public void sum1d(int[] arr) {
		System.out.println();
		System.out.println("sum1d result");
		int sum = 0;
		for(int el : arr) {
			sum += el;
		}
		
		
		System.out.println("sum=" + sum);
	} // end of sum1d
	
	public void sum2d(int[][] arr) {
		System.out.println();
		System.out.println("sum2d result");
		int total = 0;
		float average = 0;
		int count = 0;
		for(int[] cols : arr) {
			for(int el : cols) {
				total += el;
				count++;
			}
		}
		average = total / (float) count;		
		
		System.out.println("total=" + total);
		System.out.println("average=" + average);
	}
	
	public String enscript(String src, char[] abcCode, char[] numCode) {
		System.out.println();
		System.out.println("enscript result");
		String result = "";
		
		for (int i = 0 ; i < src.length(); i++) {
			char ch = src.charAt(i);
			if (ch >= '0' && ch <= '9') {
				// 숫자 변환
				int index = ch - '0';
				result = result + numCode[index];
			} else if (ch >= 'a' && ch <= 'z') {
				// 글자 변환
				int index = ch - 'a';
				result = result + abcCode[index];
			}
		}
		
		System.out.println("src:" + src);
		System.out.println("result:" + result);	
		return result;
	}
	
	public void descript(String password, char[] abcCode, char[] numCode) {
		System.out.println();
		System.out.println("descript result");
		String result = "";
		for (int i = 0 ; i < password.length() ; i++) {
			char ch = password.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				// 숫자 변환
				int index;
				for(index = 0; index < numCode.length; index++) {
					if (ch == numCode[index]) {
						break;
					}
				}
				result = result + index;
			} else {
				// 글자 변환
				int index;
				for(index = 0; index < abcCode.length; index++) {
					if (ch == abcCode[index]) {
						break;
					}
				}
				result = result + (char)(index + 'a');
			}
		}

		System.out.println("password:" + password);
		System.out.println("result:" + result);
	}
	
	
}


public class Array01 {
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] arr = {10, 20, 30, 40, 50};
		sol.sum1d(arr); // 결과 sum=150
		
		int[][] arr2 = {
				{5, 5, 5, 5, 5},
				{10, 10, 10, 10, 10},
				{20, 20, 20, 20, 20},
				{30, 30, 30, 30, 30}
		};		
		sol.sum2d(arr2);
		
		/* abcCode 생성
		String str = "`~!@#$%^&*()-_+=|[]{};:,./";
		for (int i = 0; i < str.length() ; i++) {
			if(i == 0)
				System.out.print("'");
			else
				System.out.print(",'");
			System.out.print(str.charAt(i) + "'");
		}
		/**/
		// a ~ z
		char[] abcCode = {
				'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'
		};
		// 0123456789
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		String src = "hello201109";
		String password = sol.enscript(src, abcCode, numCode);
		sol.descript(password, abcCode, numCode);
		
		


		
	} // end of main
} // end of class
