package leet054;

import java.util.ArrayList;
import java.util.List;

public class SolutionII {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> rslt = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return rslt;
		int target = matrix.length * matrix[0].length, num = 0, i = 0, j = 0, dir = 0;
		while(num < target){
			rslt.add(matrix[i][j]);
			num ++;
			if (dir % 4 == 0){
				if (j == matrix[0].length - 1 - dir / 4){
					dir ++;
					i ++;
				}
				else
					j ++;
			}
			else if (dir % 4 == 1){
				if (i == matrix.length - 1 - dir / 4){
					dir ++;
					j --;
				}
				else
					i ++;
			}
			else if (dir % 4 == 2){
				if (j == dir / 4){
					dir ++;
					i --;
				}
				else
					j --;
			}
			else {
				if (i == 1 + dir / 4){
					dir ++;
					j ++;
				}
				else
					i --;
			}
		}
		return rslt;
	}
}
