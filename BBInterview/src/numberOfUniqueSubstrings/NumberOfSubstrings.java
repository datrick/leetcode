package numberOfUniqueSubstrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfSubstrings {

	private int commonPrefixLength(String s, String t) {
		if (s == null || t == null)
			return 0;
		int i = 0;
		for (i = 0; i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i); i ++) ;
		return i;
	}
	public int numberOfUniqueSubstrings(String s) {
		if (s == null || s.length() <= 0)
			return 0;
		List<String> suffixList = new ArrayList<>();
		for (int i = 0; i < s.length(); i ++)
			suffixList.add(s.substring(i));
		Collections.sort(suffixList);
		String pre = suffixList.get(0);
		int sum = pre.length();
		for (int i = 1; i < suffixList.size(); i ++) {
			String t = suffixList.get(i);
			sum += t.length() - this.commonPrefixLength(pre, t);
			pre = t;			
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "kincenvizh";
		System.out.println(new NumberOfSubstrings().numberOfUniqueSubstrings(s));
	}

}
