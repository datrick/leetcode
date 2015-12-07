package leet309;

public class Solution {

	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int[] dp = new int[1 + prices.length];
		int maxs = - prices[0], max = 0;
		for (int i = 1; i < prices.length; i ++) {
			max = Math.max(maxs + prices[i], max);
			dp[i + 1] = max;
			maxs = Math.max(dp[i - 1] - prices[i], maxs);
		}
		return dp[prices.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 2, 3, 0, 2};
		System.out.println(new Solution().maxProfit(prices));
	}

}
