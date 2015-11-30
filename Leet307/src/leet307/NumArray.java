package leet307;

public class NumArray {

	public static void main(String[] args) {
		int[] nums = {1, 3, 5};
		NumArray obj = new NumArray(nums);
		obj.update(1, 2);
		System.out.println(obj.sumRange(0, 2));
	}
	private int[] tree, nums;
	private void updateTree(int i, int val) {
		int delta = val - nums[i];
		nums[i] = val;
		i ++;
		while (i < tree.length) {
			tree[i] += delta;
			i += (i & -i);
		}
	}
	private int getSum(int i) {
		i ++;
		int res = 0;
		while (i > 0) {
			res += tree[i];
			i -= (i & -i);
		}
		return res;
	}
	public NumArray(int[] nums) {
		if (nums == null || nums.length <= 0)
			return;
		this.nums = new int[nums.length];
		this.tree = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i ++)
			this.updateTree(i, nums[i]);
	}

	void update(int i, int val) {
		if (i >= this.nums.length || this.nums[i] == val)
			return;
		this.updateTree(i, val);
	}

	public int sumRange(int i, int j) {
		return this.getSum(j) - this.getSum(i) + this.nums[i];
	}
}
