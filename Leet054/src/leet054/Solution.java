package leet054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> rslt = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return rslt;
		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, i;
		while (left <= right && top <= bottom){
			for (i = left; i <= right; i ++)
				rslt.add(matrix[top][i]);
			if (top == bottom)
				break;
			for (i = top + 1; i <= bottom; i ++)
				rslt.add(matrix[i][right]);
			if (left == right)
				break;
			for (i = right - 1; i >= left; i --)
				rslt.add(matrix[bottom][i]);
			if (top == bottom - 1)
				break;
			for (i = bottom - 1; i > top; i --)
				rslt.add(matrix[i][left]);
			left ++;
			right --;
			top ++;
			bottom --;
		}
		return rslt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		SolutionII obj = new SolutionII();
		System.out.println(obj.spiralOrder(matrix));
	}

}
