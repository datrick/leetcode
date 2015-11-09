package leet301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionII {
		public List<String> removeInvalidParentheses(String s) {
			List<String> rslt = new ArrayList<>();
			Set<String> set = new HashSet<>();
			int left  = 0, right = 0, i = 0;
			for (i = 0; i < s.length(); i ++) {
				char c = s.charAt(i);
				left += c == '(' ? 1 : 0;
				right += c == ')' ? 1 : 0;
				if (right > left)
					break;
			}
			if (left == right) {
				rslt.add(s);
				return rslt;
			}
			char c = left > right ? '(' : ')';
			StringBuilder sb = new StringBuilder(s);
			for (int j = 0, last = -2; j < s.length() && j <= i; j ++) {
				char ch = sb.charAt(j);
				if (ch == c && last != j - 1) {
					sb.deleteCharAt(j);
					set.addAll(this.removeInvalidParentheses(sb.toString()));
					sb.insert(j, c);
				}
				if (ch == c && last == j - 1)
					last = j;
			}
			rslt.addAll(set);
			return rslt;
		}
		
}
