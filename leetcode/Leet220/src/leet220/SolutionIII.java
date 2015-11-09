package leet220;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionIII {
	class TreeNode {
	long val;
	TreeNode left, right, parent;
	TreeNode(int val) {
		this.val = (long) val;
		left = right = parent = null;
	}
}

class BST {
	private TreeNode nil;
	BST() {
		this.nil = new TreeNode(0);
		this.nil.left = this.nil;
		this.nil.right = this.nil;
		this.nil.parent = this.nil;
	}

	public boolean addCompare(TreeNode node, int t) {
		TreeNode nd = this.nil.left, par = nil;
		while (nd != this.nil) {
			par = nd;
			if (Math.abs(node.val - nd.val) <= Math.abs((long) t))
				return true;
			if (node.val < nd.val)
				nd = nd.left;
			else
				nd = nd.right;
		}
		node.parent = par;
		if (par != this.nil){
		if (node.val < par.val)
			par.left = node;
		else
			par.right = node;
		} else {
			par.left = node;
		}
		node.left = node.right = this.nil;
		return false;
	}

	public void remove(TreeNode node) {
		TreeNode nd = node.left;
		if (node.right != this.nil) {
			nd = node.right;
			while (nd.left != this.nil)
				nd = nd.left;
			TreeNode right = nd.right;
			right.parent = nd.parent;
			if (nd == nd.parent.left)
				right.parent.left = right;
			else
				right.parent.right = right;
			nd.left = node.left;
			nd.right = node.right;
			nd.left.parent = nd;
			nd.right.parent = nd;
		}
		nd.parent = node.parent;
		if (node == node.parent.left)
			nd.parent.left = nd;
		else
			nd.parent.right = nd;
	}
}
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0 || t < 0)
			return false;
		BST bst = new BST();
		Deque<TreeNode> Q = new LinkedList<>();
		for (int i = 0; i < nums.length; i ++) {
			TreeNode nd = new TreeNode(nums[i]);
			if (bst.addCompare(nd, t))
				return true;
			Q.offer(nd);
			if (i - k >= 0)
				bst.remove(Q.poll());
		}
		return false;
	}
}
