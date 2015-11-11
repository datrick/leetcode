package leet145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solusion {

	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	public List<Integer> postorderTraversal(TreeNode root) {
/*		if(root == null)
			return null;*/
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode t = null, o = null;
		boolean exit = false;
		if(root != null)
			st.push(root);
		while(!st.isEmpty()){
			t = st.peek();
			while(t.left != null){
				st.push(t.left);
				t = t.left;
			}
			if(t.right != null)
				st.push(t.right);
			else{
				list.add(st.pop().val);
				o = t;
				exit = false;
				while(!st.isEmpty() && !exit){
					t = st.peek();
					if(o == t.left){
						if(t.right == null){
							o = st.pop();
							list.add(o.val);
							continue;
						}
						else{
							st.push(t.right);
							exit = true;
						}
					}
					else{
						o = st.pop();
						list.add(o.val);
						continue;
					}
				}
			}
		}
		return list;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = null;
		TreeNode root2 = null;
		Solusion obj = new Solusion();
		List<Integer> list = obj.postorderTraversal(root2);
		System.out.println(list);
	}

}
