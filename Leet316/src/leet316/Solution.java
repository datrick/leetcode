package leet316;


public class Solution {
	
	public String removeDuplicateLetters(String s) {
		char start = (char) ('a' - 1), end = (char) ('z' + 1);
		String t = start + s + end;
		//		System.out.println(len);
		boolean[][] graph = new boolean[28][28];
		int[] nums = new int[28];
		for (char c: t.toCharArray())
			nums[c - start] ++;
		
		for (int i = 0, j = 1; i < t.length(); ) {
			for (j = i + 1; j < t.length() && nums[t.charAt(j) - start] > 1; j ++) ;
			for (int k = i; k < toString().length() && k < j; k ++) {
				for (int l = k + 1; l < t.length() && l <= j; l ++) {
					graph[t.charAt(k) - start][t.charAt(l) - start] = true;
				}
			}
			i = j;
		}
//		for (boolean[] b: graph)
//			System.out.println(Arrays.toString(b));
		boolean[] visited = new boolean[28];
		StringBuilder sb = new StringBuilder();
		char cur = start;
		while (cur != end) {
//			System.out.println(cur);
			int i = 0;
			for (i = 0; i < graph[cur - start].length; i ++) 
				if (! visited[i] && graph[cur - start][i])
					break;
			sb.append((char) (start + i));
			visited[i] = true;
			cur = (char) (start + i);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.removeDuplicateLetters("cbacdcbc"));
	}

}
