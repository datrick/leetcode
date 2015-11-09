package leet106;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	private TreeNode buildTreeRec(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map){
		if(is > ie)
			return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int mid = map.get(postorder[pe]);
		root.left = this.buildTreeRec(inorder, is, mid - 1, postorder, ps, ps + mid - 1 - is, map);
		root.right = this.buildTreeRec(inorder, mid + 1, ie, postorder, ps + mid - is, pe - 1, map);
		return root;
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map  = new HashMap<>();
		for(int i = 0; i < inorder.length; i ++)
			map.put(inorder[i], i);
		return this.buildTreeRec(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {1}, postorder = {1};
		Solution obj = new Solution();
		System.out.println(obj.buildTree(inorder, postorder).right);
	}

}
