package leet052;

public class Solution {

	private boolean noConflict(int x, int y, int[] cor) {
		for (int i = 0; i < x; i ++) {
			double slope = (double) (y - cor[i]) / (double) (x - i);
			if (slope == 0.0 || slope == 1.0 || slope == -1.0)
				return false;
		}
		return true;
	}
	public int totalNQueens(int n) {
		int[] y = new int[n];
		int i = 0, j = 0, k = 0, num = 0;
		while (k >= 0) {
			if (k == n) {
				num ++;
				k --;
				i = y[k] + 1;
			}
			for (j = i; j < n; j ++) {
				if (noConflict(k, j, y)) {
					y[k] = j;
					k ++;
					i = 0;
					break;
				}
			}
			if (j >= n) {
				k --;
				if (k >= 0)
					i = y[k] + 1;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().totalNQueens(5));
	}

}
