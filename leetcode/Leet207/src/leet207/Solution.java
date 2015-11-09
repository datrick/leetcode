package leet207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0)
			return false;
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] inDegree = new int[numCourses];
		int num = 0;
		for (int i = 0; i < numCourses; i ++) {
			List<Integer> list = new ArrayList<>();
			map.put(i, list);
		}
		for (int i = 0; i < prerequisites.length; i ++) {
			int child = prerequisites[i][0], parent = prerequisites[i][1];
			map.get(parent).add(child);
			inDegree[child] += 1;
		}
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < numCourses; i ++) {
			if (inDegree[i] == 0)
				st.push(i);
		}
		while (!st.isEmpty()) {
			int parent = st.pop();
			num ++;
			for (int i : map.get(parent)) {
				inDegree[i] --;
				if (inDegree[i] == 0){
					st.push(i);
				}
			}
		}
		if (num == numCourses)
			return true;
		return false;
	}
	
	public static void main(String[] argv) {
		int[][] prerequisites = { {0, 1} };
		int numCourses = 2;
		System.out.println(new Solution().canFinish(numCourses, prerequisites));
	}
}