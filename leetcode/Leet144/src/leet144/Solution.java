package leet144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;
		Stack<TreeNode> st = new Stack<>();
		TreeNode tmp = null;
		st.push(root);
		while(!st.isEmpty()){
			tmp = st.pop();
			result.add(tmp.val);
			if(tmp.right != null)
				st.push(tmp.right);
			if(tmp.left != null)
				st.push(tmp.left);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
