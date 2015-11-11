package leet131;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> tmpList = new ArrayList<>();
		if(s.length() == 0)
			return result;
		/*		if(s.length() == 1)
		 */			
		int[][] isPal = new int[s.length()][s.length()];
		int i, j;
		for(i = 0; i < isPal.length; i ++){
			isPal[i][i] = 1;
			if(i + 1 < isPal.length && s.charAt(i) == s.charAt(i + 1))
				isPal[i][i+1] = 1;
		}

		for(i = isPal.length - 1; i >= 0; i --)
			for(j = i + 2; j < isPal.length; j ++)
				if(isPal[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j))
					isPal[i][j] = 1;

		Stack<Integer> st = new Stack<>();
		st.push(0);
		int next = 0;
		while(!st.isEmpty()){
			for(i = next; i < s.length() && isPal[st.peek()][i] != 1; i ++);
			if(i == s.length() - 1){
				tmpList.add(s.substring(st.peek(), i + 1));
				result.add(new ArrayList<String>(tmpList));
				tmpList.remove(tmpList.size() - 1);
				next = st.pop();
				if(tmpList.size() > 0)
					tmpList.remove(tmpList.size() - 1);
			}
			if(i > s.length() - 1){
				next = st.pop();
				if(tmpList.size() > 0)
					tmpList.remove(tmpList.size() - 1);
			}
			if(i < s.length() - 1){
				tmpList.add(s.substring(st.peek(), i + 1));
				st.push(i + 1);				
				next = i + 1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		Solution obj = new Solution();
		System.out.println(obj.partition(s));
	}

}
