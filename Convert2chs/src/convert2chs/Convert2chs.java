package convert2chs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Convert2chs {

	final static Charset ENCODING = StandardCharsets.UTF_8;
	final static Charset ENCODING_O  = StandardCharsets.US_ASCII;
	public void readUnicodeFile(String fileName, String targetFile) throws IOException, FileNotFoundException {
		try (BufferedReader reader = new BufferedReader(
										new InputStreamReader(
											new FileInputStream(
												fileName), ENCODING_O.name()));
			 BufferedWriter writer = new BufferedWriter(
					 					new OutputStreamWriter(
					 							new FileOutputStream(targetFile, true), ENCODING.name()))) {
			writer.write('\uFEFF');
			String line = null;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String fileName = "E:\\Javacodes\\Convert2chs\\srt.srt", targetFile = "E:\\Javacodes\\Convert2chs\\newSrt.txt";
		Convert2chs obj = new Convert2chs();
		obj.readUnicodeFile(fileName, targetFile);
	}

}
