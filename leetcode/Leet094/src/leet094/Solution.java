package leet094;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int v) {
			this.val = v;
			this.left = this.right = null;
		}
	}
	
	public List<Integer> inorderTraversal (TreeNode root) {
		List<Integer> rslt = new ArrayList<>();
		TreeNode cur = root, tmp = null;
		while (cur != null) {
			if (cur.left != null) {
				for (tmp = cur.left; tmp.right != null && tmp.right != cur; tmp = tmp.right) ;
				if (tmp.right == cur) {
					rslt.add(cur.val);
					tmp.right = null;
					cur = cur.right;
				} else {
					tmp.right = cur;
					cur = cur.left;
				}
			} else {
				rslt.add(cur.val);
				cur = cur.right;
			}
		}
		return rslt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
