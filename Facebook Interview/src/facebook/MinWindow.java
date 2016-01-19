package facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow {

	public int[] findMinWindow(String s, Set<Character> dict) {
		if (s == null || dict == null)
			return null;
		int[] res = new int[] {-1, -1};
		int count = dict.size(), i = 0, j = 0, min = Integer.MAX_VALUE;
		if (count == 0)
			return res;
		Map<Character, Integer> visited = new HashMap<>();
		for (j = 0; j < s.length(); j ++) {
			char c = s.charAt(j);
			if (!dict.contains(c))
				continue;
			if (!visited.containsKey(c) || visited.get(c) == 0) {
				count --;
				visited.put(c, 1);
			} else
				visited.put(c, visited.get(c) + 1);
			if (count == 0) {
				while (i <= j && count <= 0) {
					char ch = s.charAt(i);
					if (visited.containsKey(ch)) {
						int n = visited.get(ch);
						if (n == 1)
							count ++;
						visited.put(ch, n - 1);
					}
					i ++;
				}
				int len = j - i + 2;
				if (len <= min) {
					min = len;
					res[0] = i - 1;
					res[1] = j;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] array = {'a', 'c'};
		Set<Character> dict = new HashSet<Character>();
		for (char c: array)
			dict.add(c);
		String s = "abcabcabc";
		int[] window = new MinWindow().findMinWindow(s, dict);
		System.out.println(Arrays.toString(window));
	}

}
