package WrapperClass;

public class String01 {
	public static void main(String[] args) {
		/*
		 * String : Wrapper class
		 * 			문자열 저장, 편집, 정보 취득 등		
		 */
		
		String str;
		// 클래스명 (객체)변수명
		str = "안녕하세요"; // str = new String("안녕하세요");
		// 리터럴은 공통 Pool에 저장되는걸로 아는데..
		System.out.println(str);
		System.out.println("new: " + (new String("하이") == new String("하이")));
		System.out.println("literal: " + ("하이" == "하이"));
		
		char[] chArray = {'안', '녕'};
		for (int i = 0; i < chArray.length; i++) {
			System.out.print(chArray[i]);
		}
		System.out.println();
		System.out.println(chArray);
		
		String str1 = new String("하이");
		String str2 = new String("바이");
		
		// 문자열의 결합
		String str3;
		//str3 = str1 + str2;
		str3 = str1.concat(str2);
		System.out.println("str3: " + str3);
		
		// 문자열 비교
		String str4 = "hello";
		String str5 = "hell";
		str5 = str5 + "o";
		System.out.print("== 비교 : ");
		if(str4 == str5) {
			System.out.println("같습니다");
		} else {
			System.out.println("다릅니다");
		}
		
		System.out.print("equals : ");
		if(str4.equals(str5)) {
			System.out.println("같습니다");
		} else {
			System.out.println("다릅니다");
		}
		
		// 지정 문자의 위치 취득
		char[] charArray = { 'a', 'b', 'c' };
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 'b') {
				System.out.println("index: " + i);
				break;
			}
		}
		
		// 지정 문자의 위치 취득(String)
		String str6 = "abcdabcdabcd";
		int n;
		n = str6.indexOf('c');
		System.out.println("index(Str): " + n);
		n = str6.lastIndexOf('c');
		System.out.println("Last index(Str): " + n);
		
		// 문자열의 길이
		String str7 = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("length:" + str7.length());
		
		str7 = "I can do it";
		System.out.println("length:" + str7.length());
		
		// replace(수정)
		str7 = "A*B**C"; // *이 필요없는 문자일때
		String str8 = str7.replace("*", "");
		System.out.println(str8);
		
		// split
		/*
		 * token을 활용해서 문자열을 자른다.
		 * hello-world-java '-' token
		 */
		String str9 = "홍길동-24-2001/12/21-180.1";
		String[] strArray = str9.split("-");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		
		// 범위를 통해서 문자열을 취득(substring)
		String str10 = "abcdefg";
		String substr = str10.substring(2, 5);	// 2부터 시작해서 5번지 전까지(즉, 2~4)
		System.out.println(substr);
		substr = str10.substring(4);	// 4번지부터 끝까지
		System.out.println(substr);
		
		// 모든 문자열을 대문자, 소문자로 변경
		String str11 = "abcDEF";
		System.out.println(str11.toUpperCase());
		System.out.println(str11.toLowerCase());
		
		// 앞의 공백을 제거해 주는 함수
		String str12 = "            java c언어 python      ";
		System.out.println(str12.trim());
		
		// 숫자 -> 문자열
		// valueOf
		int num = 123;
		long lo = 1234L;
		double d = 123.4567;
		@SuppressWarnings("unused")
		String s1 = String.valueOf(num); // num + ""; 이 더 간단
		@SuppressWarnings("unused")
		String s2 = String.valueOf(lo);
		@SuppressWarnings("unused")
		String s3 = String.valueOf(d);
		System.out.printf("%d %d %f\n", num, lo, d);
		
		// 탐색 : 지정 문자열을 포함하는지
		String str13 = "서울시 강남구";
		boolean b1 = str13.contains("서울");
		System.out.println(b1);
		
		// String을 배열로 사용
		String str14 = "가나다라마";
		char c = str14.charAt(2);
		System.out.println("c= " + c);
	}
}
