package leet110;

public class Solution {

	private int balancedRec(TreeNode root){
		if(root == null)
			return 0;
		int l = balancedRec(root.left), r = balancedRec(root.right);
		if(l < 0 || r < 0 || Math.abs(l - r) > 1)
			return -1;
		return (1 + Math.max(l, r));
	}
	public boolean isBalanced(TreeNode root) {
		if(balancedRec(root) < 0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		Solution obj = new Solution();
		if(obj.isBalanced(root))
			System.out.println("Balanced");
		else
			System.out.println("NOT Balanced");
	}

}
