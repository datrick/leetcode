package exceptions;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {

	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<>(SIZE);
		for (int i = 0; i < SIZE; i ++) {
			list.add(new Integer(i));
		}
	}

	public void writeList() {

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("OutFile.txt", true)))){
			for (int i = 0; i < SIZE; i ++)
				out.println("Value at: " + i + " = " + list.get(i));
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}

	public static void main(String [] argv) {
		ListOfNumbers obj = new ListOfNumbers();
		obj.writeList();
	}
}



