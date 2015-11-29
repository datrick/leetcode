package leet215;

public class Solution {

	private int doFindkth(int[] nums, int s, int e, int k) {
		int pivot = nums[e - 1], ind = s, j = s;
		while (ind < e && nums[ind] < pivot)
			ind ++;
		for (j = ind + 1; j < e; j ++) {
			if (nums[j] < pivot) {
				int tmp = nums[j];
				nums[j] = nums[ind];
				nums[ind ++] = tmp;
			}
		}
		nums[e - 1] = nums[ind];
		nums[ind] = pivot;
		if (e - ind == k)
			return pivot;
		if (e - ind > k)
			return doFindkth(nums, ind + 1, e, k);
		return doFindkth(nums, s, ind, k - (e - ind));
	}
	
	public int findKthLargest(int[] nums, int k) {
		if (k <= 0 || k > nums.length)
			return -1;
		return doFindkth(nums, 0, nums.length, k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 2, 1, 5, 6, 4};
		System.out.println(new Solution().findKthLargest(nums, 3));
	}

}
