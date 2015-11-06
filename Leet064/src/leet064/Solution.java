package leet064;

public class Solution {

	public int minPathSum(int[][] grid) {
		if (grid.length <= 0 || grid[0].length <= 0)
			return 0;
        int[][] dp = new int[2][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i ++)
        	dp[0][i] = dp[0][i - 1] + grid[0][i];
        for (int i = 1; i < grid.length; i ++)
        	for (int j = 0; j < grid[i].length; j ++)
        		if (j == 0)
        			dp[i % 2][j] = dp[(i - 1) % 2][j] + grid[i][j];
        		else 
        			dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j];
        return dp[(grid.length - 1) % 2][grid[0].length - 1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { {1, 2, 3}, {1, 2, 3}, {1, 2, 3} };
		Solution obj = new Solution();
		System.out.println(obj.minPathSum(grid));
	}

}
