package leet269;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public String alienOrder(String[] words) {
		if (words.length <= 0)
			return "";
		boolean[][] adj = new boolean[26][26];
		for (int i = 0; i < adj.length; i ++)
			for (int j = 0; j < adj[0].length; j ++)
				adj[i][j] = false;
		boolean[] inTree = new boolean[26], exist = new boolean[26];
		for (int i = 0; i < inTree.length; i ++) {
			inTree[i] = false;
			exist[i] = false;
		}
		int[] indegree = new int[26];
		int n = 0;
		char[] s = words[0].toCharArray(), t = null;
		for (char c : s)
			exist[c - 'a'] = true;
		for (int i = 1; i < words.length; i ++) {
			t = words[i].toCharArray();
			int j = 0;
			for (; j < s.length && j < t.length && s[j] == t[j]; j ++) ;
			if (j < s.length && j < t.length) {
				adj[s[j] - 'a'][t[j] - 'a'] = true;
				inTree[s[j] - 'a'] = true;
				inTree[t[j] - 'a'] = true;
				indegree[t[j] - 'a'] ++;
			}
			for (; j < t.length; j ++)
				exist[t[j] - 'a'] = true;
			s = t;
		}
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < indegree.length; i ++)
			if (inTree[i] && indegree[i] == 0)
				list.add(i);
		for (int i = 0; i < inTree.length; i ++)
			if (inTree[i])
				n ++;
		StringBuilder sb = new StringBuilder();
		while (! list.isEmpty()) {
			int i = list.remove(0);
			sb.append((char) (i + 'a'));
			for (int j = 0; j < adj[i].length; j ++) {
				if (adj[i][j]) {
					if (-- indegree[j] == 0)
						list.add(j);
				}
			}
		}
		if (sb.length() != n)
			return "";
		for (int i = 0; i < exist.length; i ++)
			if (exist[i] && !inTree[i])
				sb.append((char) (i + 'a'));
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"wrt","wrf","er","ett","rftt"};
		System.out.println(new Solution().alienOrder(words));
	}

}
