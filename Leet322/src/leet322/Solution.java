package leet322;

import java.util.Arrays;

public class Solution {
	
	private int changeCoin(int[] coins, int i, int amount) {
		if (amount == 0)
			return 0;
		if (i < 0)
			return -1;
		int min = Integer.MAX_VALUE;
		for (int j = amount / coins[i]; j >= 0; j --) {
			int k = changeCoin(coins, i - 1, amount - coins[i] * j);
			if (k >= 0)
				min = Math.min(min, j + k);
		}
		if (min == Integer.MAX_VALUE)
			return -1;
		return min;
	}
	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		return changeCoin(coins, coins.length - 1, amount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1, 2, 5};
		int amount = 19;
		System.out.println(new Solution().coinChange(coins, amount));
	}

}
