package leet298;

public class Solution {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	private int helper(TreeNode root, int pl, int pv) {
		if (root == null)
			return 0;
		int cl = root.val == pv + 1 ? pl + 1 : 1;
		int ll = helper(root.left, cl, root.val), rl = helper(root.right, cl, root.val);
		return Math.max(cl, Math.max(rl, ll));
	}
	
	public int longestConsecutive(TreeNode root) {
		return helper(root, 0, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = null;
		System.out.println(new Solution().longestConsecutive(root));
	}

}
