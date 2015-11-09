package amazon110315;

import java.util.Arrays;

public class Solution {

	public void rotate(int[][] matrix, boolean flag) {
		if (matrix.length == 1)
			return;
		for (int i = 1; i < matrix.length; i ++)
			for (int j = 0; j < i; j ++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		
		for (int i = 0; i < matrix.length; i ++) 
			for (int j = 0, k = matrix[0].length - 1; j < k; j ++, k --) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][k];
				matrix[i][k] = tmp;
			}
		
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {1, 2}, {3, 4} };
		new Solution().rotate(matrix, true);
		for (int[] a: matrix)
			System.out.println(Arrays.toString(a));
	}

}
