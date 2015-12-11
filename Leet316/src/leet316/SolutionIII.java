package leet316;

import java.util.LinkedList;

public class SolutionIII {

	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 0)
			return "";
		int[] counter = new int[26];
		int num = 0;
		char[] a = s.toCharArray();
		for (char c: a) {
			if (counter[c - 'a'] ++ == 0)
				num ++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; ) {
			if (counter[a[i] - 'a'] == 0) {
				i ++;
				continue;
			}
			char c = a[i];
			int j = i;
			while (counter[a[j] - 'a'] > 1) {
				if (a[j] < c)
					c = a[j];
				counter[a[j ++] - 'a'] --;
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
