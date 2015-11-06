package leet063;

public class Solution {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int[][] dp = new int[2][obstacleGrid[0].length];
		dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		for (int i = 1; i < dp[0].length; i ++)
			dp[0][i] = obstacleGrid[0][i] == 0 ? dp[0][i - 1] : 0;
		for (int i = 1; i < obstacleGrid.length; i ++)
			for (int j = 0; j < obstacleGrid[i].length; j ++){
				if (j == 0)
					dp[i % 2][0] = obstacleGrid[i][0] == 0 ? dp[(i - 1) % 2][0] : 0;
				else {
					if (obstacleGrid[i][j] == 1)
						dp[i % 2][j] = 0;
					else
						dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
				}
			}
		return dp[(obstacleGrid.length - 1) % 2][obstacleGrid[0].length - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = { {0, 0, 0}, {0, 1, 0}, {0, 0, 0} };
		Solution obj = new Solution();
		System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
	}

}
