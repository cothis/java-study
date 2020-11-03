package Variable;

public class mainClass {
	public static void main(String[] args) {
		
		// 변수의 종류
		
		// 숫자형
			// 정수형
			byte by;	// 1byte == 8bit(256가지)			-128	~	127		0000 0000(맨앞 0:양수 1: 음수)
			by = 127;
			System.out.println("by = " + by);
			short sh;	// 2byte == 16bit(65536가지)		-32768	~	32767
			sh = 1234;
			System.out.println("sh = " + sh);
			int i;		// 4byte == 32bit(약 42억가지)
			i = 12232131;
			System.out.println("i = " + i);
			long l;		// 8byte == 64bit(약 1840경가지)
			l = 121212123423432554L;
			System.out.println("l = " + l);

			// 실수형
			float f;	// 4byte
			f = 123.456789f;
			System.out.println("f = " + f);
			double d;	// 8byte
			d = 123.456789;
			System.out.println("d = " + d);
		
		// 문자형
			// 문자
			char c;		// 2byte == character
						// a ~ z, A ~ Z, @, #, $, %, 가, 나, 다 ... 한 글자만 가능
			c = 'A';
			System.out.println("c = " + c);
			
			c = '가';
			System.out.println("c = " + c);
			// 문자열 : 하나 이상의 문자 Array, String(Wrapper class)
			String str;
			str = "hello";
			System.out.println("str = " + str);
			str = "abc";
			System.out.println("str = " + str);

		// 논리형(true/false)
			boolean b;	// 1byte
			b = true;	// 1의 의미
			b = false;	// 0의 의미
			System.out.println("b = " + b);
	}
}
