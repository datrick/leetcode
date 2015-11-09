package leet301;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	private List<String> removeIP(String s, char c, int i, int num, int left, int right) {
		List<String> rslt = new ArrayList<>();
		int last = -2;
		for (int j = i; j < s.length(); j ++) {
			char ch = s.charAt(j);
			if (ch == c && num > 0 && last != j - 1) {
				StringBuilder sb = new StringBuilder(s);
				sb.deleteCharAt(j);
				last = j;
				rslt.addAll(removeIP(sb.toString(), c, j, num - 1, left, right));
			}
			if (ch == c && num > 0 && last == j - 1)
				last = j;
			left += ch == '(' ? 1 : 0;
			right += ch == ')' ? 1 : 0;
			if (right > left)
				return rslt;
		}
		if (left == right)
			rslt.add(s);
		return rslt;
	}
	
	public List<String> removeInvalidParentheses(String s) {
		int left = 0, right = 0;
		for (int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			left += c == '(' ? 1 : 0;
			right += c == ')' ? 1 : 0;
		}
		char c = left > right ? '(' : ')';
		int num = left > right ? (left - right) : (right - left);
		List<String> rslt = this.removeIP(s, c, 0, num, 0, 0);
		if (rslt.isEmpty())
			rslt.add("");
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "((((((())))((";
		System.out.println(new SolutionII().removeInvalidParentheses(s));
	}

}
