package leet310;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	private int getTreeHight(int root, Map<Integer, List<Integer>> tree) {
		int h = 0;
		Deque<Integer> deque = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		visited.add(root);
		deque.offerLast(root);
		while (! deque.isEmpty()) {
			Deque<Integer> next = new LinkedList<>();
			h ++;
			while (! deque.isEmpty()) {
				int node = deque.pollFirst();
				if (tree.containsKey(node)) {
					for (int v: tree.get(node)) {
						if (! visited.contains(v)) {
							next.offerLast(v);
							visited.add(v);
						}
					}
				}
			}
			deque = next;
		}
		return h;
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> rslt = new ArrayList<>();
		if(n <= 0)
			return rslt;
		int min = n + 1;
		Map<Integer, List<Integer>> tree = new HashMap<>();
		for (int[] edge: edges) {
			if (! tree.containsKey(edge[0]))
				tree.put(edge[0], new ArrayList<>());
			if (! tree.containsKey(edge[1]))
				tree.put(edge[1], new ArrayList<>());
			tree.get(edge[0]).add(edge[1]);
			tree.get(edge[1]).add(edge[0]);
		}
		for (int i = 0; i < n; i ++) {
			int h = this.getTreeHight(i, tree);
//			System.out.printf("%d: %d%n", i, h);
			if (h < min) {
				rslt.clear();
				rslt.add(i);
				min = h;
			} else {
				if (h == min)
					rslt.add(i);
			}
		}
		return rslt;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = { {0, 1}, {0, 2} };
		System.out.println(new SolutionII().findMinHeightTrees(3, edges).toString());
	}

}
