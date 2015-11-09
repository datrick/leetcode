package leet122;

public class Solution {

	public int maxProfit(int[] prices) {
		if(prices.length <= 0)
			return 0;
		int max = 0, i = 0, t = 0;
		for(i = 1; i < prices.length; i ++){
			t = prices[i] - prices[i-1];
			if(t > 0)
				max += t;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 2, 1, 2, 1, 2, 3};
		Solution obj = new Solution();
		System.out.println(obj.maxProfit(prices));
	}

}
