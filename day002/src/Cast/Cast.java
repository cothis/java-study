package Cast;

public class Cast {
	public static void main(String[] args) {
		/*
		 * 자료형 변환
		 * ===Example===
		 * int -> short
		 * short -> int
		 * =============
		 * 
		 * Type		size	우선순위
		 * -----------------------
		 * boolean	1 byte	낮음
		 * byte		1 byte	 ↑
		 * short	2 byte	 |
		 * int		4 byte	 |
		 * long		8 byte	 |
		 * 					 |
		 * float	4 byte	 ↓
		 * double	8 byte	높음
		 */
		
		// auto(자동 형변환) 암시적(implicit)	작은 그릇 -> 큰 그릇
		short sh = 10;
		int num;
		num = sh;
		System.out.println("num = " + num);
		// cast(강제 형변환) 명시적(Explicit)	큰 그릇 -> 작은 그릇
		num = 32768;
		sh = (short) num;
		System.out.println("sh = " + sh);	// sh = -32767
		
		float f;
		long l = 1234567890123L;
		
		f = l;
		System.out.println("f = " + f);		// f = 1.23456795E12
											// E12 == 10^12
		
		double d;
		d = l;
		System.out.println("d = " + d);		// d = 1.234567890123E12
		
		// E-2 == 10^-2
		d = 1.23E-2;
		System.out.println("d = " + d);
		
		double tag;
		int num1, num2;
		num1 = 3;
		num2 = 2;
		
		tag = num1 / num2;
		System.out.println("tag = " + tag);	// tag = 1.0
		
		tag = (double) num1 / num2;
		System.out.println("tag = " + tag);	// tag = 1.5
		
		tag = num1 / (double) num2;
		System.out.println("tag = " + tag);	// tag = 1.5
		
		d = 12570.12;
		int result = (int) d;
		System.out.println("result : " + result);
	}
}
