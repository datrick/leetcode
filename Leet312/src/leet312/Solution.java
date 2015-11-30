package leet312;

public class Solution {

	public int maxCoins(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 0;
		int n = nums.length;
		int[] tmp = new int[nums.length + 2];
		for (int i = 0; i < nums.length; i ++)
			tmp[i + 1] = nums[i];
		tmp[0] = 1;
		tmp[tmp.length - 1] = 1;
		nums = tmp;
		int[][] dp = new int[nums.length + 1][nums.length + 1];
		for (int l = 1; l <= n; l ++) {
			for (int i = 1; i + l - 1 <= n; i ++) {
				int max = Integer.MIN_VALUE, k = i;
				for (k = i, max = Integer.MIN_VALUE; k < i + l; k ++) {
					int coin = nums[k] * nums[i - 1] * nums[i + l] + dp[i][k - 1] + dp[k + 1][i + l - 1];
					max = Math.max(max, coin);
				}
				dp[i][i + l - 1] = max;
			}
		}
		return dp[1][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 1, 5, 8};
		System.out.println(new Solution().maxCoins(nums));
	}

}
