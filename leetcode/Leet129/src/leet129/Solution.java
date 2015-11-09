package leet129;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;
		int sum = 0;
		Map<TreeNode, Integer> map = new HashMap<>();
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		map.put(root, root.val);
		while(!st.isEmpty()){
			TreeNode node = st.pop();
			if(node.right != null){
				st.push(node.right);
				map.put(node.right, map.get(node) * 10 + node.right.val);
			}
			if(node.left != null){
				st.push(node.left);
				map.put(node.left, map.get(node) * 10 + node.left.val);
			}
			if(node.left == null && node.right == null)
				sum += map.get(node);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		Solution obj = new Solution();
		System.out.println(obj.sumNumbers(root));
	}

}
