package leet113;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	private int pushNode(TreeNode root, Stack<TreeNode> st, List<Integer> lt, int tt){
		TreeNode tn = root.left != null ? root.left : (root.right != null ? root.right : null);
		while(tn != null){
			st.push(tn);
			lt.add(tn.val);
			tt += tn.val;
			tn = tn.left != null ? tn.left : (tn.right != null ? tn.right : null);
		}
		return tt;
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> rslt = new ArrayList<>();
		List<Integer> lt = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		if(root == null)
			return rslt;
		st.push(root);
		lt.add(root.val);
		TreeNode tmp = null;
		int tt = root.val;
		while(!st.isEmpty()){
			tt = this.pushNode(st.peek(), st, lt, tt);
			System.out.println(tt);
			if(tt == sum)
				rslt.add(new ArrayList<Integer>(lt));
			while(!st.isEmpty()){
				tmp = st.pop();
				tt -= tmp.val;
				lt.remove(lt.size() - 1);
				if(!st.isEmpty() && tmp == st.peek().left && st.peek().right != null){
					st.push(st.peek().right);
					lt.add(st.peek().val);
					tt += st.peek().val;
					break;
				}
			}
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(2);
		Solution obj = new Solution();
		System.out.println(obj.pathSum(root, 6));
		
	}

}
