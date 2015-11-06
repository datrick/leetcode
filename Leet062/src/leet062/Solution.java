package leet062;

public class Solution {

	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		int[][] dp = new int[2][n];
		for (int i = 0; i < m; i ++)
			for (int j = 0; j < n; j ++){
				if (j == 0 || i == 0)
					dp[i % 2][j] = 1;
				else{
					dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
				}
			}
		return dp[(m - 1) % 2][n - 1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 2, n = 2;
		Solution obj = new Solution();
		System.out.println(obj.uniquePaths(m, n));
	}

}
