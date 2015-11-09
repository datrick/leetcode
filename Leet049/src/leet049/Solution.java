package leet049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		Map<String, List<String>> map = new HashMap<>();
		for (String s: strs) {
			char[] array = s.toCharArray();
			Arrays.sort(array);
			String key = new String(array);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}
		List<List<String>> rslt = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry: map.entrySet())
			rslt.add(entry.getValue());
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> rslt = new Solution().groupAnagrams(strs);
		System.out.println(rslt.toString());
	}

}
