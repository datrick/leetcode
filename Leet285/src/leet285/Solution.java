package leet285;

import java.util.Stack;

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) {
			this.val = x;
			this.left = null;
			this.right = null;
		}
	}
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null)
			return null;
		TreeNode tn = null;
		if (p.right != null) {
			tn = p.right;
			while (tn.left != null)
				tn = tn.left;
			return tn;
		}
		boolean pFound = false;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			tn = st.peek();
			while (tn.left != null) {
				st.push(tn.left);
				tn = tn.left;
			}
			do {
				tn = st.pop();
				if (pFound) {
					return tn;
					}
				if (tn == p){
					pFound = true;
				}
				if (tn.right != null) {
					st.push(tn.right);
					break;
				}
			} while (! st.isEmpty());
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		System.out.println(new Solution().inorderSuccessor(root, root));
	}

}
