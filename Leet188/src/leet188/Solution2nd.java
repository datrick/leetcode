package leet188;

public class Solution2nd {

	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (k <= 0 || n <= 1)
			return 0;
		int numOfPeaks = 0, max = 0;
		boolean up = false;
		for (int i = 1; i < n; i ++) {
			if (prices[i] > prices[i - 1]){
				max += prices[i] - prices[i - 1];
				up = true;
			}
			if (prices[i] < prices[i - 1] && up){
				numOfPeaks ++;
				up = false;
			}
		}
		if (up)
			numOfPeaks ++;
		if (k >= numOfPeaks)
			return max;
		int[][] dp = new int[2][n];
		for (int i = 1, mpp = 0; i <= k; i ++) {
			mpp = -prices[0];
			dp[i % 2][0] = 0;
			for (int j = 1; j < n; j ++) {
				dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], Math.max(dp[i % 2][j - 1], mpp + prices[j]));
				mpp = Math.max(mpp, dp[(i - 1) % 2][j - 1] - prices[j]);
			}
		}
		return dp[k % 2][n - 1];
	}
}
