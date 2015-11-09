package leet222;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; left = right = null;}
	}
	
	public int countNodes(TreeNode root) {
		int left = this.calHeight(root, false), right = this.calHeight(root, true),
				nextR = 0, num = 0;
		int[] pow = new int[64];
		pow[0] = 1;
		for (int i = 1; i < pow.length; i ++) {
			pow[i] = pow[i - 1] * 2;
		}
		while (left != right) {
			nextR = this.calHeight(root.left, true);
//			nextL = this.calHeight(root.right, false);
			if (nextR == left - 1) {
				num += pow[nextR];
				left = this.calHeight(root.right, false);
				right -= 1;
				root = root.right;
			} else {
				num += pow[nextR];
				left -= 1;
				right = nextR;
				root = root.left;
			}
		}
		num += pow[left] - 1;
		return num;
	}

	private int calHeight(TreeNode node, boolean right) {
		int h = 0;
		while (node != null) {
			h += 1;
			if (right)
				node = node.right;
			else
				node = node.left;
		}
		return h;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<TreeNode> Q = new LinkedList<>();
		TreeNode root = null, tmp = null;
		Solution obj = new Solution();
		for (int ref = 0; ref < 8621; ref ++) {
			Q.clear();
			root = null;
			int num = ref;
			if (num > 0) {
				root = new TreeNode(num);
				num -= 1;
				Q.offer(root);
			}
			while (num > 0) {
				tmp = Q.poll();
				tmp.left = new TreeNode(num --);
				if (num > 0)
					tmp.right = new TreeNode(num --);
				Q.offer(tmp.left);
				Q.offer(tmp.right);
			}
			int count = obj.countNodes(root);
			if(count != ref) {
				System.err.printf("error! ref: %d, count: %d", ref, count);
				System.exit(-1);
			}
		}
		System.out.println("pass");
	}
}




























