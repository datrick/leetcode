package leet300;

public class Solution {

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int max = 0;
		for (int i = 1; i < dp.length; i ++)
			dp[i] = 1;
		for (int i = 1; i < nums.length; i ++) {
			for (int j = 0; j < i; j ++)
				dp[i] = nums[i] > nums[j] ? Math.max(dp[i], dp[j] + 1) : dp[i];
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(new Solution().lengthOfLIS(nums));
	}

}
