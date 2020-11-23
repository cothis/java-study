package day008.work;

public class FuncEncrypt {	
	public static String encrypt(String src) {
		char[] abcCode = getAbcCode();
		char[] numCode = getNumCode();
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
		return result;
	}
	
	public static String decrypt(String password) {
		char[] abcCode = getAbcCode();
		char[] numCode = getNumCode();
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
		return result;
	}
	
	public static char[] getAbcCode() {
		// a~z
		char[] abcCode = {
				'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'
		};
		return abcCode;
	}
	
	public static char[] getNumCode() {
		// 0123456789
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		return numCode;
	}
	
	public static void main(String[] args) {
		// 암호화 복호화 메소드 구현
		
		String originalCode = "hello201109";
		System.out.println("original code : " + originalCode);
		
		String encryptedCode = encrypt(originalCode);
		System.out.println("encrypted code : " + encryptedCode);
		
		String decryptedCode = decrypt(encryptedCode);
		System.out.println("decrypted code : " + decryptedCode);
	}
}
