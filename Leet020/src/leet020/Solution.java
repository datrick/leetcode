package leet020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		Stack<Character> st = new Stack<>();
		for (char c: s.toCharArray()) {
			if (! map.containsKey(c))
				st.push(c);
			else 
				if (st.isEmpty() || st.peek().compareTo(map.get(c)) != 0)
					return false;
				else
					st.pop();
		}
		if (st.isEmpty())
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "}()";
		System.out.println(new Solution().isValid(s));
	}

}
