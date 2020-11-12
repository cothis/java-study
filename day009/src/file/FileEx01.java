package file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileEx01 {
	public static void main(String[] args) {
	/*
		source code -> 알고리즘(logic 구현)
		
		file : 저장 매체 -> 기능	== Database
			       데이터 저장, 불러오기
		
		*.txt
		*.jpg *.dll *.lib *.jar *.bmp
		
		dll(Dynamic Link Library) : 동적 파일
		lib(Library) : 정적 파일
	*/
		/*// 파일 목록 출력
		File fdir = new File("c:\\");
		
		String[] fileList = fdir.list();
		for(int i = 0; i < fileList.length; i++) {
			System.out.println((i + 1) + ". "+ fileList[i]);
		}
		*/
		
		/*// 파일, 폴더, 그 외 판별
		File fdir = new File("c:\\");
		File[] filelist = fdir.listFiles();
		for(int i = 0; i < filelist.length; i++) {
			if(filelist[i].isFile()) {
				System.out.println("[파일]" + filelist[i].getName());
			} else if(filelist[i].isDirectory()) {
				System.out.println("[폴더]" + filelist[i].getName());
			} else {
				System.out.println("[?]" + filelist[i].getName());
			}
		}
		*/
		
		// 파일 생성
		String fileStr = "D:\\tmp\\newfile.txt";	//D:/tmp/newfile.txt 가능
		File newFile = new File(fileStr);
		
		try {
			if(newFile.createNewFile()) {
				System.out.println("파일 생성 성공");
			} else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}
}
