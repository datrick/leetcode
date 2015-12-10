package leet259;

import java.util.Arrays;

public class Solution {

	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length <= 0)
			return 0;
		Arrays.sort(nums);
		int n = 0;
		for (int i = 0; i < nums.length - 2; i ++) {
			for (int j = i + 1, k = nums.length - 1; j < k; ) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					n += k - j;
					j ++;
				} else {
					k --;
				}
			}
		}
		return n;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, -1, 1, -1};
		System.out.println(new Solution().threeSumSmaller(nums, -1));
	}
}
