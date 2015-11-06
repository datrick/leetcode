package leet121;

public class Solusion {

	public int maxProfit(int[] prices) {
		if(prices.length <= 0)
			return 0;
		int[] opt = new int[prices.length];
		int max = 0;
		opt[0] = 0;
		for(int i = 1; i < prices.length; i ++)
			opt[i] = Math.max(0, opt[i-1] > 0 ? opt[i-1] + prices[i] - prices[i-1] : prices[i] - prices[i-1]);
		for(int i = 1; i < prices.length; i ++)
			if(opt[i] > max)
				max = opt[i];
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {4, 3, 2, 1, 9, 14, 6};
		Solusion obj = new Solusion();
		System.out.println(obj.maxProfit(prices));
	}

}
