package leet213;

public class Solution {

	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return nums[0] > nums[1] ? nums[0] : nums[1];
			int max = 0;
			int[] dp = new int[nums.length];
			dp[0] = nums[0];
			dp[1] = nums[0];
			for (int i = 2; i < nums.length - 1; i ++)
				dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
			max = dp[nums.length - 2];
			dp[0] = 0;
			dp[1] = nums[1];
			for (int i = 2; i < nums.length; i ++)
				dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
			max = Math.max(max, dp[nums.length - 1]);
			return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(new Solution().rob(nums));
	}

}
