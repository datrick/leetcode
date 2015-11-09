package leet291;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	private boolean doMatch(String p, String s, int i, int j, Map<Character, String> dict) {
		if (i == p.length() && j == s.length())
			return true;
		if (i >= p.length() || j >= s.length())
			return false;
		int k = j, m = 0, n = 0;	
		for (k = j + 1; k <= s.length(); k ++) {
			String t = s.substring(j, k);
			if (dict.containsValue(t))
				continue;
			dict.put(p.charAt(i), t);
//			System.out.println(p.charAt(i) + ": " + t);
			boolean goNext = true;
			for (m = i + 1, n = k; m < p.length() && n < s.length(); m ++) {
				if (!dict.containsKey(p.charAt(m)))
						break;
				String r = dict.get(p.charAt(m));
				if (n + r.length() > s.length() || r.compareTo(s.substring(n, n + r.length())) != 0) {
					goNext = false;
					break;
				}
				n += r.length();
			}
			if (goNext && doMatch(p, s, m, n, dict))
					return true;
			dict.remove(p.charAt(i));
		}
		return false;
	}
	
	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> dict = new HashMap<>();
		return doMatch(pattern, str, 0, 0, dict);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "aabb", str = "xyzabcxzyabc";
		System.out.println(new Solution().wordPatternMatch(pattern, str));
	}

}
