package datainout;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class DataInOut {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		try (FileInputStream fin = new FileInputStream("data.txt")) {
			int tmp;
			tmp = fin.read();
			System.out.println(tmp);
		} catch (EOFException e) {
			
		}
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream("dataFile"))) {
			String[] names = {"Yueqi", "duoduo", "pangniu"};
			double[] height = {154.1, 160.3, 164.9};
			int[] eyes = {2, 3, 4};
			for (int i = 0; i < names.length; i ++) {
				out.writeUTF(names[i]);
				out.writeDouble(height[i]);
				out.writeInt(eyes[i]);
			}
		}
		System.out.println("Data Writen");
		
		try (DataInputStream in = new DataInputStream(new FileInputStream("dataFile"))) {
			while (true) {
				System.out.format("%10s's height is %.2f, and %1$10s has %d eyes%n", in.readUTF(), in.readDouble(), in.readInt());
			} 
		}catch(EOFException e) {
		
		}
	}
}
