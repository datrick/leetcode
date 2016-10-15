package leet322;


public class SolutionII {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		int min = -1;
		for (int i = 1; i <= amount; i ++) {
			min = -1;
			for (int j = 0; j < coins.length; j ++) {
				if (i - coins[j] < 0 || dp[i - coins[j]] < 0)
					continue;
				if (min == -1 || min > 1 + dp[i - coins[j]])
					min = 1 + dp[i - coins[j]];
			}
			dp[i] = min;
		}
		return dp[amount];
	}
}
