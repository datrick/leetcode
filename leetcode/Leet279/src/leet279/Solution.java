package leet279;

import java.util.Arrays;

public class Solution {

	public int numSquares(int n) {
		if (n == 0)
			return 0;
		int min = n, m = (int) Math.sqrt((double) n);
		if (n % (m * m) == 0)
			return n / (m * m);
		for (int i = m; i > 0; -- i) {
			if (n / (i * i) >= min)
				return min;
			int res = n / (i * i) + numSquares(n % (i * i));
			min = min > res ? res : min;
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[10];	// 
		Solution obj = new Solution();
		for (int i = 0; i < 10; i ++) {
			array[i] = obj.numSquares(i + 10);
		}
		System.out.println(Arrays.toString(array));
//		System.out.println(obj.numSquares(12));
	}

}
