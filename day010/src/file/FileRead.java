package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileRead {
	public static void main(String[] args) {
	/*
		
	*/
		File f = new File("D:\\tmp\\test.txt");
		//File f = new File("D:/tmp/newfile.txt");
		
		try {
			FileReader fr = new FileReader(f);
			String str = "";
			
			/*//한글자씩 읽는 법
			int c = fr.read();	// 한 문자씩 읽는다.
			while(c != -1) {	// -1 == 파일의 끝
				System.out.println((char)c);
				str += (char)c;
				c = fr.read();
			}
			System.out.println(str);
			*/
			
			//한 줄씩 읽는 법		Buffer == 저장 공간
			BufferedReader br = new BufferedReader(fr);
			
			while ((str = br.readLine()) != null) { // 파일끝(null)이 아닐때까지
				System.out.println(str);
			}
			br.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (Exception e) {
			System.out.println("그 외 예외처리");
		} 
	}
}
