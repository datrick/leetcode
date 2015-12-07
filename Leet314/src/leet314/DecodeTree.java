package leet314;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DecodeTree {

	private static TreeNode rebuildTree(Deque<String> code) {
		if (code.isEmpty())
			return null;
		String s = code.pollFirst();
		if (s.compareTo("#") == 0)
			return null;
		TreeNode root = new TreeNode(Integer.valueOf(s));
		root.left = rebuildTree(code);
		root.right = rebuildTree(code);
		return root;
	}
	public static TreeNode decodeTree(String s) {
		Deque<String> code = new LinkedList<>(Arrays.asList(s.split("\\s")));
		return rebuildTree(code);
		
	}
	
	public static void inOrder(TreeNode root) {
		if (root == null) {
			System.out.print('#');
			return;
		}
		System.out.printf("%d ", root.val);
		inOrder(root.left);
		inOrder(root.right);
	}
	public static void main(String[] args) {
		String s = "30 10 50 # # # 20 45 # # 35 # #";
		DecodeTree.inOrder(DecodeTree.decodeTree(s));
		// TODO Auto-generated method stub

	}

}
