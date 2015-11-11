package leet140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solusion {

//	private List<String> tempList = new ArrayList<String>();
	public List<String> list = new ArrayList<String>();

/*	private void breakWord(String s, int i, Set<String> dict){
		if(i >= s.length()){
			StringBuilder sb = new StringBuilder();
			sb.append(tempList.get(0));
			for(int j = 1; j < tempList.size(); j ++)
				sb.append(" " + tempList.get(j));
			list.add(sb.toString());
			System.out.println(sb.toString());
		}
		else{
			StringBuilder sb = new StringBuilder();
			String t = null;
			for(int j = i; j < s.length(); j ++){
				sb.append(s.charAt(j));
				t = sb.toString();
				if(dict.contains(t)){
					tempList.add(t);
					System.out.println(t);
					breakWord(s, j+1, dict);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}*/
	
	public void add2List(Stack<Integer> st, String s){
		StringBuilder sb = new StringBuilder(s);
		for(int i = st.size() - 1; i > 0; i --)
			sb.insert(st.get(i), " ");
		list.add(sb.toString());
		System.out.println(sb.toString());
	}
	
	public List<String> wordBreak(String s, Set<String> dict) {
		if(s.length() == 0)
			return list;
		int[][] T = new int[s.length()][s.length()];
		int i = 0, j = 0;
		for(i = 0; i < T.length; i ++)
			for(j = i; j < T.length; j ++)
				if(dict.contains(s.substring(i, j+1)))
					T[i][j] = 1;
				else
					T[i][j] = 0;
		int sum = 0;
		for(i = 0; i <T.length; i ++)
			sum += T[0][i];
		if(sum == 0)
			return list;
		for(i = 0, sum = 0; i <T.length; i ++)
			sum += T[i][T.length - 1];
		if(sum == 0)
			return list;
			
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		int next = 0;
		while(!st.isEmpty()){
			i = st.peek();
			for(j = next; j < T.length && T[i][j] == 0; j ++);
			if(j == T.length - 1){
				//add the current string to the result
				this.add2List(st, s);
				next = st.pop();
			}
			if(j > T.length - 1)
				next = st.pop();
			if(j < T.length - 1){
				st.push(j + 1);
				next = j + 1;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] d = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		String[] e = {"cat", "cats", "and", "sand", "dog"};
		Set<String> dict = new HashSet<String>(Arrays.asList(d));
		String s = "catsanddog";
		String t = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Solusion obj = new Solusion();
		List<String> result = obj.wordBreak(t, dict);
		System.out.println(result);
	}
}
