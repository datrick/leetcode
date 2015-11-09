package leet105;

import java.util.Stack;

public class Solution {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length, i = 0, j = 0;
		if(len <= 0)
			return null;
		Stack<TreeNode> st = new Stack<>();
		TreeNode head = new TreeNode(preorder[i ++]), pre = head;
		st.push(head);
//		System.out.printf("i: %d, j: %d, %d is pushed", i, j, st.peek().val);
		while(!st.isEmpty()){
			while(i < len && st.peek().val != inorder[j]){
				st.push(st.peek().left = new TreeNode(preorder[i ++]));
//				System.out.printf("i: %d, j: %d, %d is pushed", i, j, st.peek().val);
			}
			while(j < len && !st.isEmpty() && st.peek().val == inorder[j]){
				pre = st.pop();
				j ++;
//				System.out.printf("i: %d, j: %d, %d is popped", i, j, pre.val);
			}
			if(i < len){
				st.push(pre.right = new TreeNode(preorder[i ++]));
//				System.out.printf("i: %d, j: %d, %d is pushed", i, j, st.peek().val);
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {1, 2}, preorder = {2, 1};
		Solution obj = new Solution();
		System.out.println(obj.buildTree(preorder, inorder).left.val);
	}

}
