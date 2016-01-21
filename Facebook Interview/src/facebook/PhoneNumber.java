package facebook;

import java.util.LinkedList;
import java.util.List;

public class PhoneNumber {
	
	char[][] dict = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
			{'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
	
	public List<String> letterCombinations(String digits) {
		List<String> rslt = new LinkedList<>(), next = null;
		if (digits == null || digits.length() <= 0)
			return rslt;
		rslt.add("");
		for (char c: digits.toCharArray()) {
			char[] candidates = dict[c - '2'];
			next = new LinkedList<>();
			for (String s: rslt) {
				StringBuilder sb = new StringBuilder(s);
				for (char ch: candidates) {
					sb.append(ch);
					next.add(sb.toString());
					sb.deleteCharAt(sb.length() - 1);
				}
			}
			rslt = next;
		}
		return rslt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "234";
		System.out.println(new PhoneNumber().letterCombinations(digits));
	}

}
