package BitOperator;

public class Bit {
	public static void main(String[] args) {
		/*
		 * bit : 0, 1
		 * 
		 * &  AND
		 * |  OR
		 * ^  XOR
		 * << left shift
		 * >> right shift
		 * ~  not
		 */
		
		int result;
		// AND
		// 1011 1100 -> 0xBC
		// 1100 1001 -> 0xC9 AND
		// ---------------------
		// 1000 1000 -> 0x88
		result = 0b10111100 & 0b11001001;
		System.out.printf("result is %d(0x%1$X)\n", result);
		
		/* OR 
		 * 0x5D | 0xE3
		 * 0101 1101(0x5D)
		 * 1110 0011(0xE3) OR
		 * ------------------
		 * 1111 1111(0xFF)
		 */
		result = 0x5D | 0xE3;
		System.out.printf("result is %d(0x%1$X)\n", result);
		
		/* XOR
		 * 0x37 ^ 0xAB
		 * 0011 0111(0x37)
		 * 1010 1011(0xAB) XOR
		 * -------------------
		 * 1001 1100(0x9C)
		 */
		result = 0x37 ^ 0xAB;
		System.out.printf("result is %d(0x%1$X)\n", result);
		
		/* ~ (NOT)
		 * 0101 1010(0x55) ~
		 * -----------------
		 * 1010 0101(0xAA)
		 */
		
		byte by = ~ 0x55;
		System.out.printf("by is %d(0x%1$X)\n", by);
		
		/* Shift
		 * 0x1B << n
		 * 0001 1011(0x1B) << n = 2
		 * ------------------------
		 * 0110 1100(0x6C)
		 * 27(0x1B)*4 = 108(0x6C)
		 * 2^n승 만큼 커진다 (Left shift)
		 * 
		 * 0x1b >> n
		 * 0001 1011(0x1B) >> n = 2
		 * ------------------------
		 * 0000 0110(0x06)
		 * 27(0x1B)/4 = 6
		 * 2^-n승 만큼 작아진다(Right shift)
		 * 이때 소수점은 잘린다.
		 */
		
		byte by1;
		by1 = 0x1 << 1;
		System.out.printf("by1 is %d(0x%1$X)\n", by1);
		by1 <<= 1;
		System.out.printf("by1 is %d(0x%1$X)\n", by1);
		by1 >>= 1;
		System.out.printf("by1 is %d(0x%1$X)\n", by1);
		
		
	}
}
