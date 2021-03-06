package leet236;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private List<TreeNode> findPath(TreeNode root, TreeNode p) {
		if (root == null)
			return null;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while (! st.isEmpty()){
			do {
				TreeNode tn = st.peek();
				if (tn == p)
					return new ArrayList<TreeNode>(st);
				if (tn.left != null)
					st.push(tn.left);
				else {
					if (tn.right != null)
						st.push(tn.right);
					else
						break;
				}
			} while (true);
			
			while (! st.isEmpty()) {
				TreeNode tn = st.pop();
				if (! st.isEmpty() && tn == st.peek().left && st.peek().right != null) {
						st.push(st.peek().right);
						break;
					}
			}
		}
		return new ArrayList<TreeNode>(st);
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pPath = findPath(root, p), qPath = findPath(root, q);
		TreeNode tn = null;
		for (int i = 0; i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i); i ++) {
			tn = pPath.get(i);
		}
		return tn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3), left, right;
		left = root.left = new TreeNode(5);
		right = root.right = new TreeNode(1);
		left.left = new TreeNode(6);
		left.right = new TreeNode(2);
		left = left.right;
		left.left = new TreeNode(7);
		left.right = new TreeNode(4);
		right.left = new TreeNode(0);
		right.right = new TreeNode(8);
		TreeNode p = root.left.left, q = root.left.right.left;
		Solution obj = new Solution();
		TreeNode tn = obj.lowestCommonAncestor(root, p, q);
		System.out.println(tn.val);
	}

}
