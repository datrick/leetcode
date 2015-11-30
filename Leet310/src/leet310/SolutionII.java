package leet310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionII {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> rslt = new ArrayList<>();
		if(n <= 0)
			return rslt;
		int[] degree = new int[n];
		Map<Integer, List<Integer>> tree = new HashMap<>();
		for (int[] edge: edges) {
			if (! tree.containsKey(edge[0]))
				tree.put(edge[0], new ArrayList<>());
			if (! tree.containsKey(edge[1]))
				tree.put(edge[1], new ArrayList<>());
			tree.get(edge[0]).add(edge[1]);
			tree.get(edge[1]).add(edge[0]);
			degree[edge[0]] ++;
			degree[edge[1]] ++;
		}
		for (int i = 0; i < degree.length; i ++) {
			if (degree[i] <= 1)
				rslt.add(i);
		}
		while (!(rslt.size() <= 1 || rslt.size() == 2 && tree.get(rslt.get(0)).contains(rslt.get(1)))) {
			List<Integer> list = new ArrayList<>();
			for (int v: rslt) {
				if (tree.containsKey(v)) {
					for (int u: tree.get(v)) {
						if (--degree[u] == 1)
							list.add(u);
					}
				}
			}
			rslt = list;
		}
		return rslt;
	}
}
