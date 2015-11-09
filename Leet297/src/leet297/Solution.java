package leet297;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
			left = null;
			right = null;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		List<Integer> list = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		list.add(root.val);
		list.add(-1);
		list.add(-1);
		int cur = 0;
		while (!deque.isEmpty()) {
			TreeNode tn = deque.poll();
			if (tn.left != null) {
				list.add(tn.left.val);
				list.add(-1);
				list.add(-1);
				deque.offer(tn.left);
				list.set(cur + 1, list.size() - 3);
			}
			if (tn.right != null) {
				list.add(tn.right.val);
				list.add(-1);
				list.add(-1);
				deque.offer(tn.right);
				list.set(cur + 2, list.size() - 3);
			}
			cur += 3;
		}
		StringBuilder sb = new StringBuilder();
		for (int i: list) {
			if (sb.length() != 0)
				sb.append(", ");
			sb.append(i);
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() <= 0)
			return null;
//		System.out.println(data);
		String[] array = data.split("\\s*,\\s*");
		List<Integer> list = new ArrayList<>();
		for (String s: array)
			list.add(Integer.valueOf(s));
//		System.out.println(list.toString());
		Deque<TreeNode> deque = new LinkedList<>();
		TreeNode root = new TreeNode(list.get(0));
		deque.offer(root);
		int cur = 0;
		while (!deque.isEmpty()) {
			TreeNode tn = deque.poll();
			if (list.get(cur + 1) != -1) {
				tn.left = new TreeNode(list.get(list.get(cur + 1)));
				deque.offer(tn.left);
			}
			if (list.get(cur + 2) != -1) {
				tn.right = new TreeNode(list.get(list.get(cur + 2)));
				deque.offer(tn.right);
			}
			cur += 3;
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		Solution obj = new Solution();
		String data = obj.serialize(root);
		root = obj.deserialize(data);
		System.out.printf("%d, %d, %d", root.val, root.left.val, root.right.val);
	}

}
