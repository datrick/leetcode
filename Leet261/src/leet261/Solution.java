package leet261;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	public boolean validTree(int n, int[][] edges) {
		if (n <= 0)
			return false;
		Map<Integer, List<Integer>> map = new HashMap<>();
		if (edges != null) {
			for (int[] edge: edges) {
				if (! map.containsKey(edge[0]))
					map.put(edge[0], new ArrayList<>());
				if (! map.containsKey(edge[1]))
					map.put(edge[1], new ArrayList<>());
				map.get(edge[0]).add(edge[1]);
				map.get(edge[1]).add(edge[0]);
			}
		}
		boolean[] visited = new boolean[n];
		int count = 0;
		Deque<Integer> deque = new LinkedList<>();
		deque.offer(0);
		visited[0] = true;
		while (! deque.isEmpty()) {
			int node = deque.pop();
			count ++;
			List<Integer> children = map.get(node);
			if (children == null)
				continue;
			int v = 0;
			for (int j: children) {
				if (visited[j])
					v ++;
				else {
					visited[j] = true;
					deque.offer(j);
				}
			}
			if (v > 1)
				return false;
		}
		if (count < n)
			return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		System.out.println(new Solution().validTree(5, edges));
	}

}
