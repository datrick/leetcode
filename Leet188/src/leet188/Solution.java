package leet188;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int MAX;
	public class Peek{
		int high, low, profit, minPeekIndex;
		boolean o;
		public Peek(int x, int y){
			this.low = x;
			this.high = y;
			this.profit = -1;
			this.o = false;
		}
	}

	public List<Peek> findPeek(int[] prices){
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
				findMin = false;
			}
		}
		if(findMin == true){
			Peek t = new Peek(minIndex, i-1);
			list.add(t);
		}
		if(list.size() <= 0)
			return list;
		list.get(0).profit = prices[list.get(0).high] - prices[list.get(0).low];
		list.get(0).minPeekIndex = 0;
		this.MAX = list.get(0).profit;
		for(i = 1, minIndex = 0; i < list.size(); i ++){
			if(prices[list.get(i).low] <= prices[list.get(minIndex).low])
				minIndex = i;
			list.get(i).profit = prices[list.get(i).high] - prices[list.get(minIndex).low];
			list.get(i).minPeekIndex = minIndex;
			this.MAX += prices[list.get(i).high] - prices[list.get(i).low];
		}
		return list;
	}

	public void updateValue(List<Peek> list, int m, int[][] T, int[] prices){
		for(int i = list.get(m).minPeekIndex; i < m; i ++)
			list.get(i).profit -= prices[list.get(T[i+1][m]).low] - prices[list.get(list.get(m).minPeekIndex).low];
		for(int i = m + 1; i < list.size() && list.get(i).minPeekIndex <= m; i ++){
			if(!list.get(i).o){
				list.get(i).profit -= prices[list.get(T[m+1][i]).low] - prices[list.get(list.get(i).minPeekIndex).low];
				list.get(i).minPeekIndex = T[m+1][i];
			}
		}
	}
	public int maxProfit(int k, int[] prices) {
		List<Peek> list = this.findPeek(prices);
		if(k >= list.size())
			return this.MAX;
		int max = 0, result = 0, m = 0;
		int[][] T = new int[list.size()][list.size()];
		for(int i = 0; i < list.size(); i ++)
			T[i][i] = i;
		for(int i = 0; i < list.size(); i ++)
			for(int j = i+1; j < list.size(); j ++)
				T[i][j] = prices[list.get(j).low] <= prices[list.get(T[i][j-1]).low] ? j : T[i][j-1];
/*		for(int i = 0; i < list.size(); i ++){
			for(int j = i+1; j < list.size(); j ++)
				System.out.format("(%d, %d): %d", i, j, list.get(T[i][j]).low);
			System.out.format("\n");
		}*/
		for(int i = 0; i < k; i ++){
			max = 0;
			for(int j = 0; j < list.size(); j ++){
				if(!list.get(j).o && list.get(j).profit > max){
					max = list.get(j).profit;
					m = j;
				}
			}
			list.get(m).o = true;
			result += max;
			this.updateValue(list, m, T, prices);
			System.out.printf("After choosing %d: the profit is: %d\n", m, result);
			for(int l = 0; l < list.size(); l ++)
				System.out.format("(%d, %d): %d, ",list.get(l).low, list.get(l).high, list.get(l).profit);
			System.out.format("\n");
		}
		return result;
	}

	// TODO test task function
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2nd obj = new Solution2nd();
		int[] prices = {48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94};
//		List<Peek> list = obj.findPeek(prices);
//		System.out.format("number of peeks: %d, max: %d\n", list.size(), obj.MAX);
//		for(int i = 0; i < list.size(); i ++)
//			System.out.format("the %d peek: (%d, %d)\n", i, list.get(i).low, list.get(i).high);
		System.out.println(obj.maxProfit(7, prices));
	}

}
