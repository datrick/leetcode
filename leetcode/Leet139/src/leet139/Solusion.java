package leet139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solusion {

	public boolean wordBreak(String s, Set<String> dict) {
		if(s.length() == 0)
			return false;
		int next = 0, i = 0, j = 0;
		boolean matched = false;
		for(i = 0; i < s.length(); i ++){
			if(dict.contains(s.substring(0, i + 1))){
				matched = true;
				break;
			}
		}
		if(!matched)
			return false;
		matched = false;
		for(i = 0; i < s.length(); i ++){
			if(dict.contains(s.substring(i))){
				matched = true;
				break;
			}
		}
		if(!matched)
			return false;
		
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		next = 0;
		while(!st.isEmpty()){
			i = st.peek();
			for(j = next; j < s.length() && !dict.contains(s.substring(i, j + 1)); j ++);
			if(j == s.length() - 1)
				return true;
			if(j > s.length() - 1)
				next = st.pop();
			if(j < s.length() - 1){
				st.push(j + 1);
				next = j + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] d = {"a"};
		String[] e = {"cat", "cats", "and", "sand", "dog"};
		Set<String> dict = new HashSet<String>(Arrays.asList(d));
		String s = "catsanddog";
		String t = "a";
		Solusion obj = new Solusion();
		if(obj.wordBreak(t, dict))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
