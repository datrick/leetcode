package leet221;

public class Solution {

	public int maximalSquare(char[][] matrix) {
		int max = 0, row = matrix.length, col = row > 0 ? matrix[0].length : 0;
		int[][] A = new int[2][col + 1];
		for (int i = 1; i <= row; i ++) {
			for (int j = 1; j <= col; j ++) {
				int len = A[(i - 1) % 2][j - 1], k = 0, l = 0;
				for (k = 0; k <= len && i - 1 - k >= 0 && matrix[i - 1 - k][j - 1] == '1'; k ++);
				for (l = 0; l <= len && j - 1 - l >= 0 && matrix[i - 1][j - 1 - l] == '1'; l ++);
				A[i % 2][j] = Math.min(Math.min(k, l), len + 1);
				max = Math.max(max, A[i % 2][j]);
			}
		}
		return max * max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = { {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'} };
		System.out.println(new Solution().maximalSquare(matrix));
	}

}
