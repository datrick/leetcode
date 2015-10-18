package leet107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> rslt = new LinkedList<>();
		List<TreeNode> layer = new ArrayList<>();
		if(root == null)
			return rslt;
		layer.add(root);
		while(!layer.isEmpty()){
			List<Integer> tmplt = new ArrayList<>();
			List<TreeNode> newLayer = new ArrayList<>();
			tmplt.clear();
			for(TreeNode tn : layer){
				tmplt.add(tn.val);
				if(tn.left != null)
					newLayer.add(tn.left);
				if(tn.right != null)
					newLayer.add(tn.right);
			}
			rslt.add(0, tmplt);
			layer = newLayer;
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		Solution obj = new Solution();
		System.out.println(obj.levelOrderBottom(root));
	}

}
