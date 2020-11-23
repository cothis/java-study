package day010.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileWrite {
	public static void main(String[] args) throws Exception {
		File f = new File("D:/tmp/test.txt");
		
		/*// 한 글자씩 쓰기 .. 파일이 있으면 덮어쓰고, 없으면 만든다.
		FileWriter fw = new FileWriter(f);
		fw.write("Hello" + "\n");
		fw.close(); // 매우 중요
		*/
		
		/*// 추가 쓰기
		FileWriter fw = new FileWriter(f, true);
		fw.write("Hello" + "\n");
		fw.close();
		*/
		
		// 문장으로 쓰기
		FileWriter fw = new FileWriter(f);			// 파일쓰기 object 생성
		BufferedWriter bw = new BufferedWriter(fw);	// 문장 쓰기
		PrintWriter pw = new PrintWriter(bw);
		
		pw.print("안녕 ");
		pw.println("HiHi");
		pw.println("건강하세요 ");
		pw.close();
		bw.close();
		fw.close();
	}
}
