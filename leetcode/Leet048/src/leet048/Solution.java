package leet048;

public class Solution {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i ++){
			int js = n - 1 - i;
			for (int j = i; j < js; j ++){
				int temp = matrix[i][j];
				for (int k = 0; k < 3; k ++){
					matrix[i][j] = matrix[n - 1 - j][i];
					int l = n - 1 - j;
					j = i;
					i = l;
				}
				matrix[i][j] = temp;
				int l = n - 1 - j;
				j = i;
				i = l;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {1, 2}, {15, 16} };
		new Solution().rotate(matrix);
		for (int[] line : matrix){
			for (int i : line)
				System.out.format("%d ", i);
			System.out.println("");
		}
	}

}
