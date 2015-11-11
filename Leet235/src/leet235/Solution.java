package leet235;

public class Solution {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q || root.val > p.val && root.val < q.val || root.val > q.val && root.val < p.val)
			return root;
		if (root.val > p.val && root.val > q.val)
			return this.lowestCommonAncestor(root.left, p, q);
		else
			return this.lowestCommonAncestor(root.right, p, q);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6), left, right;
		left = root.left = new TreeNode(2);
		right = root.right = new TreeNode(8);
		left.left = new TreeNode(0);
		left.right = new TreeNode(4);
		left = left.right;
		left.left = new TreeNode(3);
		left.right = new TreeNode(5);
		right.left = new TreeNode(7);
		right.right = new TreeNode(9);
		TreeNode p = root.left.left, q = root.left.right.left;
		Solution obj = new Solution();
		TreeNode tn = obj.lowestCommonAncestor(root, p, q);
		System.out.println(tn.val);
	}

}
