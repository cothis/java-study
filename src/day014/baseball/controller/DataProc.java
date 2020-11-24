package day014.baseball.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import day014.baseball.main.Main;

public class DataProc {
	File f;
	public DataProc(){
		
	}
	
	public File CreateFile(String filename){
		f = new File("D:/tmp/" + filename + ".txt");
		if(f.exists() == false) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return f;
	}
	
	public boolean dataSave(String[] array, boolean append) {
		if (f.canWrite() == false) {
			Main.printWrongMessage(Main.ERR_FILE_WRITE);
			return false;
		}
		if (array == null || array.length == 0) {
			Main.printWrongMessage(Main.ERR_ARRAY_EMPTY);
		}
		
		try {
			FileWriter fw = new FileWriter(f, append);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for(int i = 0; i < array.length; i++) {
				pw.println(array[i]);
			}
			
			pw.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;		
	}
	
	public String[] dataLoad() throws Exception {
		if (f.exists() == false) {
			Main.printWrongMessage(Main.ERR_FILE_NOT_EXIST);
			return null;
		}
		if (f.canRead() == false) {
			Main.printWrongMessage(Main.ERR_FILE_READ);
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
}
