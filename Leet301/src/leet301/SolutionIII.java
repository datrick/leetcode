package leet301;

import java.util.ArrayList;
import java.util.List;

public class SolutionIII {
	private void removeRight(String s, int i, int j, List<String> rslt) {
//		System.out.println("s:" + s);
//		System.out.println(rslt.toString());
		int k = i, sum = 0;
		while (k < s.length() && sum >= 0) {
			char c = s.charAt(k ++);
			sum += c == '(' ? 1 : (c == ')' ? -1 : 0);
		}
		if (sum >= 0) {
			StringBuilder sb = new StringBuilder();
			for (int l = 0; l < s.length(); l ++) {
				char c = s.charAt(l);
				sb.insert(0, c == '(' ? ')' : (c == ')' ? '(' : c));
			}
			rslt.add(sb.toString());
		} else {
			for (int l = j; l < k; l ++) {
				if (s.charAt(l) == ')' && (l == 0 || s.charAt(l - 1) != ')'))
					this.removeRight(s.substring(0, l) + s.substring(l + 1), k - 1, l, rslt);
			}
		}
	}
	public List<String> removeInvalidParentheses(String s) {
		List<String> rslt = new ArrayList<>(), list = new ArrayList<>();
		this.removeRight(s, 0, 0, rslt);
//		System.out.println(rslt.toString());
		for (String t: rslt)
			this.removeRight(t, 0, 0, list);
		return list;
	}
}
