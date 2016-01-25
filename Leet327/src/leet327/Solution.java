package leet327;

public class Solution {

	private static class BSCNode {

		public long value;
		public int sum;
		public BSCNode left, right;
		public BSCNode(long value) {
			this.value = value;
			this.sum = 1;
			this.left = this.right = null;
		}
	}
	
	private void insert(BSCNode root, long val) {
		BSCNode pre = null, cur = root;
		while (cur != null) {
			cur.sum ++;
			if (val == cur.value)
				break;
			pre = cur;
			if (val < cur.value)
				cur = cur.left;
			else
				cur = cur.right;
		}
		if (cur == null) {
			if (val < pre.value)
				pre.left = new BSCNode(val);
			else
				pre.right = new BSCNode(val);
		}
	}
	
	private int countNodes(BSCNode root, long val, boolean smaller) {
		int res = 0;
		BSCNode cur = root;
		while (cur != null) {
			if (cur.value == val) {
				if (smaller)
					res += cur.left == null ? 0 : cur.left.sum;
				else
					res += cur.right == null ? 0 : cur.right.sum;
				break;
			} else {
				if (cur.value < val) {
					res += smaller ? (cur.sum - (cur.right == null ? 0 : cur.right.sum)) : 0;
					cur = cur.right;
				} else {
					res += smaller ? 0 : (cur.sum - (cur.left == null ? 0 : cur.left.sum));
					cur = cur.left;
				}
			}
		}
		return res;
	}
	
	public int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0)
			return 0;
		BSCNode root = new BSCNode(0);
		long ref = (long) nums[0];
		int res = nums[0] <= upper && nums[0] >= lower ? 1 : 0;
		for (int i = 1; i < nums.length; i ++) {
			this.insert(root, -1 * ref);
			ref += (long) nums[i];
			int s = this.countNodes(root, (long) lower - ref, true), l = this.countNodes(root, (long) upper - ref, false);
			res += (i + 1) - s - l;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2147483647,0,-2147483647,2147483647};
		int lower = -564, upper = 3864;
		System.out.println(new Solution().countRangeSum(nums, lower, upper));
	}

}
