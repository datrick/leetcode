package leet329;

public class Solution {

	private int findPath(int[][] matrix, int[][] path, int i, int j) {
		int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
		if (path[i][j] != 0)
			return path[i][j];
		path[i][j] = 1;
		for (int k = 0; k < dx.length; k ++) {
			int x = i + dx[k], y = j + dy[k];
			if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
				continue;
			if (matrix[x][y] > matrix[i][j])
				path[i][j] = Math.max(path[i][j], 1 + findPath(matrix, path, x, y));
		}
		return path[i][j];
	}
	
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int max = 0;
		int[][] path = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i ++)
			for (int j = 0; j < matrix[0].length; j ++) 
				max = Math.max(max, findPath(matrix, path, i, j));
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{9,19,453},
				{6,63,-1},
				{2,1,0}
		};
		System.out.println(new Solution().longestIncreasingPath(matrix));
	}

}
