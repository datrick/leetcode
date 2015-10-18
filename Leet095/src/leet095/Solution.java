package leet095;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public List<TreeNode> generateTrees(int n) {
		Object[][] dp = new Object[n + 1][n + 1];
		dp[0][0] = new ArrayList<TreeNode>();
		(List<>) dp[0][0].add(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
