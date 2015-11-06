package leet022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	public List<String> generateParenthesis(int n) {
		List<List<String>> rslt = new ArrayList<>();
		for (int i = 0; i <= n; i ++)
			rslt.add(new ArrayList<String>());
		if (n == 0)
			return rslt.get(0);
		rslt.get(1).add("()");
		for (int i = 2; i <= n; i ++) {
			Set<String> dict = new HashSet<>();
			for (String s : rslt.get(i - 1))
				rslt.get(i).add("(" + s + ")");
			for (int j = 1; j < i; j ++) {
				for (String s : rslt.get(j))
					for (String t : rslt.get(i - j)) {
						String st = s + t;
						if (! dict.contains(st)) {
							rslt.get(i).add(st);
							dict.add(st);
						}
					}
			}
		}
		return rslt.get(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().generateParenthesis(4));
	}

}
