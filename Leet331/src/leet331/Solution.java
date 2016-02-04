package leet331;

import java.util.Stack;

public class Solution {

	public boolean isValidSerialization(String preorder) {
<<<<<<< HEAD
		Stack<Character> st = new Stack<>();
		
=======
		if (preorder == null || preorder.length() == 0)
			return true;
		Stack<String> st = new Stack<>();
		String[] nodes = preorder.split(",");
		int idx = 0;
		do {
			String s = nodes[idx ++];
			if (s.compareTo("#") == 0) {
				if (st.isEmpty()) {
					if (idx == nodes.length)
						return true;
					return false;
				}
				st.pop();
			} else {
				st.push(s);
			}
		} while (idx < nodes.length);
//		if (st.isEmpty() && idx == preorder.length())
//			return true;
		return false;
>>>>>>> f0b09903c191c7e14c9c1d713867fb13a0e490c4
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD

=======
		String preorder = "232,#,#";
		System.out.println(new Solution().isValidSerialization(preorder));
>>>>>>> f0b09903c191c7e14c9c1d713867fb13a0e490c4
	}

}
