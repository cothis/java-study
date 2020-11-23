package day010.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileProcByTeacher {
	static File createFile(String filename) {
		// 파일 객체 생성
		// 입력 : 파일 이름
		// 출력 : 파일 객체
		
		File f = new File("D:/tmp/" + filename + ".txt");
		if(f.exists()) {
			System.out.println(filename + ".txt 파일이 이미 존재합니다.");
		}
		else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(filename + ".txt 파일을 생성하였습니다.");
		}
		return f;
	}
	
	static boolean dataSave(File f, String[] datas) {
		// 파일 쓰기
		// 입력 : File 객체, String[] 데이터
		// 출력 : boolean 쓰기 결과
		
		try {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	static String[] dataLoad(File f) {
		// 파일 읽기
		// 입력 : File 객체
		// 출력 : String[] 데이터
		
		String datas[] = null;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			// 데이터의 수 취득
			int count = 0;
			String str;
			while((str = br.readLine()) != null) {
				count++;
			}
			
			br.close();
			fr = new FileReader(f);
			br = new BufferedReader(fr); // file pointer 초기화
			
			datas = new String[count];
			int i = 0;
			while((str = br.readLine()) != null) {
				datas[i] = str;
				i++;
			}
			System.out.println(Arrays.toString(datas));
			br.close();
			fr.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public static void main(String[] args) throws Exception {
		// 파일 생성 - 파일명 => 파일생성
		String filename = "hello";
		File f = createFile(filename);
		
		// 파일 쓰기/추가 쓰기 - input data
		String[] str = {"안녕하세요", "건강하세요", "성공하세요" };
		boolean b = dataSave(f, str);
		if(b) {
			System.out.println("데이터를 저장했습니다.");
		} else {
			System.out.println("데이터 저장에 실패했습니다.");
		}
		
		// 파일 읽기 - return data
			// 파일의 모든 데이터를 String[]으로 담기
		@SuppressWarnings("unused")
		String[] reads = dataLoad(f);
		
		// 파일 추가 쓰기 input data
	}
}
