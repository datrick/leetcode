package leet111;

public class Solution {

	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		int left = minDepth(root.left), right = minDepth(root.right);
		if(left == 0)
			return right + 1;
		if(right == 0)
			return left + 1;
		return Math.min(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
