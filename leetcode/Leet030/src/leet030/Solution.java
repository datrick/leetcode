package leet030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	private boolean isConcatenable(String S, int start, Map<String, Integer> dict, int maxLen, int minLen){
		if (dict.isEmpty())
			return true;
		for (int i = minLen; start + i <= S.length() && i <= maxLen; i ++){
			String s = S.substring(start, start + i);
			Integer intObj = dict.get(s);
			if (intObj != null){
				intObj -= 1;
				if (intObj == 0)
					dict.remove(s);
				else
					dict.put(s, intObj);
				boolean bl = this.isConcatenable(S, start + i, dict, maxLen, minLen);
				dict.put(s, intObj + 1);
				if (bl)
					return true;
			}
		}
		return false;
	}
	
	public List<Integer> findSubstring(String S, List<String> L) {
		Map<String, Integer> dict = new HashMap<>();
		List<Integer> rslt = new ArrayList<>();
		int minLen = Integer.MAX_VALUE, maxLen = 0, sumLen = 0;
		for (String s : L){
			Integer i = dict.get(s);
			if (i == null)
				dict.put(s, 1);
			else
				dict.put(s, i + 1);
			int l = s.length();
			sumLen += l;
			maxLen = l > maxLen ? l : maxLen;
			minLen = l < minLen ? l : minLen;
		}
		for (int i = 0; i <= S.length() - sumLen; i ++)
			if (this.isConcatenable(S, i, dict, maxLen, minLen))
				rslt.add(i);
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "abababab";
		String[] list = {"a","b","a"};
		List<String> L = new ArrayList<String>(Arrays.asList(list));
		System.out.println(L);
		System.out.println(new SolutionII().findSubstring(S, L));
	}

}
