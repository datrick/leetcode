package leet314;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> rslt = new ArrayList<>();
		if (root == null)
			return rslt;
		int level = 0;	//the level corresponding to list[0]
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> levels = new LinkedList<>();
		queue.offer(root);
		levels.offer(0);
		while (! queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int l = levels.poll();
			if (l < level) {
				rslt.add(0, new ArrayList<>());
				level = l;
			} else {
				if (l - level + 1 > rslt.size())
					rslt.add(new ArrayList<>());
			}
			rslt.get(l - level).add(cur.val);
			if (cur.left != null) {
				queue.offer(cur.left);
				levels.offer(l - 1);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				levels.offer(l + 1);
			}
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String code = "3 9 4 # # 15 # # 20 2 # # 7 # #";
		TreeNode root = DecodeTree.decodeTree(code);
		List<List<Integer>> rslt = new Solution().verticalOrder(root);
		System.out.println(rslt);
	}

}
