package leet272;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Solution {

	private static class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	TreeNode precedant(TreeNode root, double target) {
		TreeNode pre = null;
		while (null != root) {
			double val = (double) root.val;
			if (target <= val)
				root = root.left;
			else {
				pre = root;
				root = root.right;
			}
		}
		return pre;
	}
	
	TreeNode descendant(TreeNode root, double target) {
		TreeNode next = null;
		while (null != root) {
			double val = (double) root.val;
			if (target >= val)
				root = root.right;
			else {
				next = root;
				root = root.left;
			}
		}
		return next;
	}
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> rslt = new ArrayList<>();
		long wpart = (long) target;
		double fpart = target - wpart;
		if (fpart == 0.0)
			target += 0.001;
		TreeNode pre = this.precedant(root, target), next = this.descendant(root, target);
		while (k > 0) {
			if (pre == null && next == null)
				return rslt;
			k --;
			if (pre == null) {
				rslt.add(next.val);
				next = this.descendant(root, (double) next.val);
				continue;
			} 
			if (next == null) {
				rslt.add(pre.val);
				pre = this.precedant(root, (double) pre.val);
				continue;
			}
			if (Math.abs((double) pre.val - target) > Math.abs((double) next.val - target)) {
				rslt.add(next.val);
				next = this.descendant(root, (double) next.val);
			} else {
				rslt.add(pre.val);
				pre = this.precedant(root, (double) pre.val);
			}
		}
		return rslt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		System.out.println(new Solution().closestKValues(root, 2.0, 2));
	}

}
