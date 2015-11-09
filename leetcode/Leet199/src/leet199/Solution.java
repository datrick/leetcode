package leet199;

import java.util.List;
import java.util.ArrayList;

public class Solution {

	private void doRight(TreeNode root, int h, List<Integer> rslt) {
		if (root == null)
			return;
		if (rslt.size() <= h)
			rslt.add(root.val);
		else
			rslt.set(h, root.val);
		doRight(root.left, h + 1, rslt);
		doRight(root.right, h + 1, rslt);
		return;
	}
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rslt = new ArrayList<>();
		doRight(root, 0, rslt);
		return rslt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5, 6);
		System.out.println(list.toString());
	}
}
