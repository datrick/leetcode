package leet265;


public class Solution {

	private int minIndex (int[] array, int j, int k) {
		int m = -1, min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i ++) {
			if (i == j || i == k)
				continue;
			if (array[i] <= min) {
				min = array[i];
				m = i;
			}
		}
		return m;
	}
	public int minCostII(int[][] costs) {
		if (costs.length <= 0 || costs[0].length < 1)
			return 0;
		int pre = minIndex(costs[0], -1, -1);
		int[] mins = new int[2];
		mins[0] = costs[0][pre];
		mins[1] = costs[0][minIndex(costs[0], pre, -1)];
//		System.out.println(Arrays.toString(mins));	
		for (int i = 1; i < costs.length; i ++) {
			int j = minIndex(costs[i], pre, -1), k = minIndex(costs[i], pre, j);
			int tmp = costs[i][pre] + mins[1], tmp2 = costs[i][j] + mins[0];
			if (tmp > tmp2) {	//chosing a different color from last one get the minimum cost
				pre = j;
				if (k < 0 || costs[i][k] + mins[0] > tmp)
					mins[1] = tmp;
				else
					mins[1] = costs[i][k] + mins[0];
				mins[0] = tmp2;
			} else {
				mins[1] = tmp2;
				mins[0] = tmp;
			}
		}
		return mins[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs = { {1, 2, 3}, {2, 5, 1}, {1, 2, 5} };
		System.out.println(new Solution().minCostII(costs));
	}

}
