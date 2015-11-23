package amazonOA1;

import java.util.Arrays;

public class RotateMatrix {

	public static int[][] rotate(int[][] input, int flag){
		if (input == null || input.length <= 0 || input[0].length <= 0)
			return input;
		int row = input.length, col = input[0].length;
		int[][] output = new int[col][row];	//transpose the input matrix, the result is the output matrix
		for (int i = 0; i < row; i ++)
			for (int j = 0; j < col; j ++)
				output[j][i] = input[i][j];
		if (flag == 0) {	//rotate clockwise
			for (int i = 0; i < output.length; i ++) {
				for (int j = 0, k = output[i].length - 1; j < k; j ++, k --) {
					int tmp = output[i][j];
					output[i][j] = output[i][k];
					output[i][k] = tmp;
				}
			}
		} else {	//rotate counterclockwise
			for (int j = 0; j < output[0].length; j ++) {
				for(int i = 0, k = output.length - 1; i < k; i ++, k --) {
					int tmp = output[i][j];
					output[i][j] = output[k][j];
					output[k][j] = tmp;
				}
			}
		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12} };
		int[][] output = RotateMatrix.rotate(input, 0);
		for (int[] row: output)
			System.out.println(Arrays.toString(row));
	}

}
