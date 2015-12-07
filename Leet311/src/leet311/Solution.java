package leet311;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public int[][] multiply(int[][] A, int[][] B) {
		if (A == null || A.length <= 0 || B == null || B.length <= 0)
			return new int[0][0];
		List<List<Integer>> rows = new ArrayList<>(), cols = new ArrayList<>();
		for (int i = 0; i < A.length; i ++) {
			List<Integer> row = new ArrayList<>();
			rows.add(row);
			for (int j = 0; j < A[0].length; j ++) {
				if (A[i][j] != 0)
					row.add(j);
			}
		}
		for (int i = 0; i < B[0].length; i ++) {
			List<Integer> col = new ArrayList<>();
			for (int j = 0; j < B.length; j ++)
				if(B[j][i] != 0)
					col.add(j);
			cols.add(col);
		}
		System.out.printf("A: %s%nB: %s%n", rows.toString(), cols.toString());
		int[][] res = new int[A.length][B[0].length];
		for (int i = 0; i < res.length; i ++)
			for (int j = 0; j < res[0].length; j ++) {
				List<Integer> row = rows.get(i), col = cols.get(j);
				for (int l = 0, k = 0; l < row.size() && k < col.size(); ) {
					if (row.get(l) == col.get(k))
						res[i][j] += A[i][row.get(l ++)] * B[col.get(k ++)][j];
					else {
						if (row.get(l) < col.get(k))
							l ++;
						else
							k ++;
					}
				}
			}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1, 0, 0}, {-1, 0, 3}}, B = { {7, 0, 0}, {0, 0, 0}, {0, 0, 1} };
		int[][] res = new Solution().multiply(A, B);
		for (int[] i: res)
			System.out.println(Arrays.toString(i));
	}

}
