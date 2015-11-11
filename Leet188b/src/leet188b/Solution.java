package leet188b;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int MAX;
	public class Peek{
		int high, low;
		public Peek(int x, int y){
			this.low = x;
			this.high = y;
		}
	}

	public Peek[] findPeek(int[] prices){
		List<Peek> list = new ArrayList<Peek>();
		int i, minIndex = 0;
		boolean findMin = false;
		this.MAX = 0;
		for(i = 1; i < prices.length; i ++){
			if(prices[i] > prices[i-1] && findMin == false){
				findMin = true;
				minIndex = i-1;
			}
			if(prices[i] < prices[i-1] && findMin == true){
				Peek t = new Peek(minIndex, i-1);
				list.add(t);
				this.MAX += prices[t.high] - prices[t.low];
				findMin = false;
			}
		}
		if(findMin == true){
			Peek t = new Peek(minIndex, i-1);
			list.add(t);
			this.MAX += prices[t.high] - prices[t.low];
		}
		Peek[] result = new Peek[list.size()];
		for(i = 0; i < list.size(); i ++)
			result[i] = list.get(i);
		return result;
	}

	public int maxProfit(int k, int[] prices) {
		Peek[] list = this.findPeek(prices);
		if(k >= list.length)
			return this.MAX;
		int[][] T = new int[k+1][list.length];
		int currentBest = 0, i = 0, j = 0;
		for(i = 1; i <= k; i ++){
			currentBest = - prices[list[0].low];
			T[i][0] = prices[list[0].high] - prices[list[0].low];
			for(j = 1; j < list.length; j ++){
				currentBest = Math.max(currentBest, T[i-1][j-1] - prices[list[j].low]);
				T[i][j] = Math.max(T[i][j-1], currentBest + prices[list[j].high]);
			}
		}
		return T[k][list.length-1];
	}

	// TODO test task function
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		int[] prices = {48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
		Peek[] list = obj.findPeek(prices);
		System.out.format("number of peeks: %d, max: %d\n", list.length, obj.MAX);
		for(int i = 0; i < list.length; i ++)
			System.out.format("the %d peek: (%d, %d)\n", i, list[i].low, list[i].high);
		System.out.println(obj.maxProfit(7, prices));
	}

}
