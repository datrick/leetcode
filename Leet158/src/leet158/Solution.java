package leet158;

import java.util.ArrayList;
import java.util.List;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class Solution extends Reader4 {
	/**
	 * @param buf Destination buffer
	 * @param n   Maximum number of characters to read
	 * @return    The number of characters read
	 */
	private List<Character> list = new ArrayList<>();
	
	public int read(char[] buf, int n) {
		char[] buff = new char[4];	
		int num = 0;
		while (list.size() < n) {
			num = read4(buff);
			for (int i = 0; i < num; i ++) 
				list.add(buff[i]);
			if (num < 4)
				break;
		}
		for (num = 0; !list.isEmpty() && num < n; num ++)
			buf[num] = list.remove(0);
		return num;
	}
	public static void main(String[] arg) {
		char[] buf = new char[1024];
		Solution obj = new Solution();
		obj.read(buf, 7);
		for (int i = 0; i < 7; i ++)
			System.out.printf("%c ", buf[i]);
		System.out.println("");
	}
}
