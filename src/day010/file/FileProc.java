package day010.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileProc {
	public static File createFile(String path) throws Exception {
		File f = new File(path);
		if(f.exists() == false) {
			f.createNewFile();
		}
		return f;
	}
	
	public static void writeFile(File f, String str, boolean append) throws IOException {
		if (f.canWrite() == false) {
			System.out.println("파일 쓰기가 불가능합니다.");
			return;
		}
		
		FileWriter fw = new FileWriter(f, append);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.write(str + "\n");
		
		pw.close();
		bw.close();
		fw.close();
	}
	
	public static void writeFile(File f, String[] array, boolean append) throws IOException {
		if (f.canWrite() == false) {
			System.out.println("파일 쓰기가 불가능합니다.");
			return;
		}
		if (array == null || array.length == 0) {
			System.out.println("입력된 String 배열이 잘못되었습니다.");
			return;
		}
		FileWriter fw = new FileWriter(f, append);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		for(int i = 0; i < array.length; i++) {
			pw.println(array[i]);
		}
		pw.close();
		bw.close();
		fw.close();
	}
	
	public static String[] readFile(File f) throws Exception {
		if (f.exists() == false) {
			System.out.println("파일이 존재하지 않습니다.");
			return null;
		}
		if (f.canRead() == false) {
			System.out.println("파일 읽기가 불가능합니다.");
			return null;
		}
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String allLine = "";
		String oneLine = "";
		int count = 0;
		while((oneLine = br.readLine()) != null) {
			allLine = allLine + oneLine + "\n";
			count++;
		}
				
		String[] result = new String[count];
		result = allLine.split("\n");
		
		br.close();
		fr.close();
		return result;		
	}
	public static void main(String[] args) throws Exception {
		// 파일 생성 - 파일명 => 파일생성
		File f = createFile("D:/tmp/mytest.txt");
		
		// 파일 쓰기/추가 쓰기 - input data
		String[] writeData = { "hello", "world", "test" };
		writeFile(f, writeData, false);
		
		// 파일 읽기 - return data
			// 파일의 모든 데이터를 String[]으로 담기
		String[] readData = readFile(f);
		System.out.println(Arrays.toString(readData));
		
		// 파일 추가 쓰기 input data
		writeFile(f, "appended Text", true);
	}
}
