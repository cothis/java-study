package WrapperClass;

public class WrapperClass01 {
	public static void main(String[] args) {
		/*
		 * Wrapper Class
		 * 일반 자료형을 클래스화한 것 
		 * 클래스 : 설계도(저장요소, 기능)
		 *
		 * 일반 자료형			Wrapper Class
		 * boolean			BOOL
		 * short			Short
		 * int				Integer
		 * long				Long
		 * 
		 * float			Float
		 * double			Double
		 * 
		 * char				CHAR
		 * char[]			String
		 * 
		 */
		
		// 숫자 -> 문자열
		String str = 123 + "";
		
		// 문자열 -> 숫자
		int number = Integer.parseInt("123") + 1;
		
		double dnumber = Double.parseDouble("123.4567");
		
		// toString(), valueOf()
		Integer in = new Integer(23);
		String tostr = in.toString();
		tostr = in + "";
		tostr = String.valueOf(in);
		System.out.println(tostr);
		
	}
}
