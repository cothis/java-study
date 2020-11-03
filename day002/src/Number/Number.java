package Number;

public class Number {
	public static void main(String[] args) {
		int num1;	// local(吏��뿭) variable, auto
		
		{
			int num2;	// local(吏��뿭) variable
			num1 = 23;	// memory : stack, heap, static, sys
						// 濡쒖뺄 蹂��닔�뒗 stack�뿉 ���옣�맂�떎.(�꽑�뼵 �떆)
		}
		
		num1 = 24;
		// num2 = 23;	// 蹂��닔 scope 踰쀬뼱�궓
		
		// 蹂��닔
		// �닽�옄�삎
		byte b;					// 1 byte
		short s;				// 2 byte
		int i;					// 4 byte
		long l = 12L;			// 8 byte
		
		float f = 123.456F;		// 4 byte
		double d;				// 8 byte
		
		/*
		 * app(window) == web(browser)
		 * 
		 * 愿�由� �봽濡쒓렇�옩
		 * oracle <- java -> web(html, javascript, css)
		 *                   JSP -> Vue, React
		 * 
		 */
		
		// 臾몄옄�삎
		char c = '한';			// 2 byte
		String str = "Hello";	// Wrapper Class
		String str1 = new String("Hello");	// �쐞�� �룞�씪, �떎留� 媛앹껜 二쇱냼媛믪� �떎由�. 由ы꽣�윺�� 怨듯넻 pool�뿉 ���옣�릺�굹, new String�� Heap�뿉 ���옣�맖
		str = str + " world";	// == str.concat(" world")
		
		// �끉由ы삎
		boolean b1 = true;	// 1
		b1 = false;			// 0
	}
}
