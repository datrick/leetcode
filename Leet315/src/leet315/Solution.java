package leet315;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private static class BNode {
		public int val, num, dup;
		public BNode left, right;
		public BNode(int v, int n) {
			this.val = v;
			this.num = n;
			this.dup = 1;
		}
	}
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> rslt = new ArrayList<>(nums.length);
		if (nums == null || nums.length <= 0)
			return rslt;
		BNode root = new BNode(nums[nums.length - 1], 1);
		rslt.add(0);
		for (int i = nums.length - 2; i >= 0; i --) {
			BNode cur = root, pre = null;
			int n = 0;
			while(cur != null) {
				cur.num ++;
				if (nums[i] == cur.val) {
					cur.dup ++;
					n += cur.left != null ? cur.left.num : 0;
					break;
				}
				pre = cur;
				if (nums[i] < cur.val)
					cur = cur.left;
				else{
					n += cur.dup + (cur.left != null ? cur.left.num : 0);
					cur = cur.right;
				}
			}
			if (cur == null) {
				if (nums[i] > pre.val)
					pre.right = new BNode(nums[i], 1);
				else
					pre.left = new BNode(nums[i], 1);
			}
			rslt.add(0, n);
		}
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
		List<Integer> rslt = new Solution().countSmaller(nums);
		System.out.println(rslt.toString());
	}

}
