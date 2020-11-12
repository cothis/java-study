package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionEx02 {
	public static void main(String[] args) {
		// NullPointerException
		String str = null;
		try {
			System.out.println(str.length());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		// ArrayIndexOutOfBoundsException
		int[] arr = { 1, 2, 3 };
		try {
			System.out.println(arr[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		// FileNotFoundException
		File f = new File("c:\\xxx.txt");
		FileInputStream is;
		
		try {
			is = new FileInputStream(f);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// NumberFormatException
		try {
			int num1 = Integer.parseInt( (int) Double.parseDouble("123.4567") + "");
			System.out.println("num1 = " + num1);
			int num = Integer.parseInt("123.4567");
			System.out.println("num = " + num);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		// StringIndexOutOfBoundsException
		try {
			String str1 = "abc";
			char c = str1.charAt(3);
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
