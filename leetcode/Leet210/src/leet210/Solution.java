package leet210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> req = new ArrayList<>();
		Deque<Integer> queue = new ArrayDeque<>();
		int[] inDegree = new int[numCourses], order = new int[numCourses];
		int num = 0;
		for (int i = 0; i < numCourses; i ++)
			req.add(new ArrayList<>());
		for (int[] pair : prerequisites) {
			req.get(pair[1]).add(pair[0]);
			inDegree[pair[0]] ++;
		}
		for (int i = 0; i < numCourses; i ++) {
			if (inDegree[i] == 0)
				queue.add(i);
		}
		while (!queue.isEmpty()) {
			int i = queue.poll();
			order[num ++] = i;
			for (int j : req.get(i)) {
				inDegree[j] --;
				if (inDegree[j] == 0)
					queue.offer(j);
			}
		}
		if (num == numCourses)
			return order;
		else
			return new int[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}, {0, 1}};
		int[] order = new Solution().findOrder(numCourses, prerequisites);
		for (int i : order)
			System.out.format("%d ", i);
	}

}
