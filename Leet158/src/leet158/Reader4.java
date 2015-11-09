package leet158;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader4 {
	private static final String filename = "C:\\Javacode\\Leet158\\src\\leet158\\input.txt";
	private File file = new File(filename);
	int read4(char[] buf) {
		int num = 0;
		try(FileReader fr = new FileReader(this.file);
				BufferedReader br = new BufferedReader(fr);) {
			num = br.read(buf, 0, 4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("inprocedure read4" + e.toString());
			e.printStackTrace();
		} 
		return num;
	}
}
