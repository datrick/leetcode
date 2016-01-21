package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseMatrix {

	public List<List<Integer>> rows, values;
	public int col;
	public SparseMatrix(int[][] matrix) {
		if (matrix == null)
			return;
		this.col = matrix[0].length;
		this.rows = new ArrayList<>(matrix.length);
		this.values = new ArrayList<>(matrix.length);
		for (int i = 0; i < matrix.length; i ++) {
			ArrayList<Integer> row = new ArrayList<>();
			ArrayList<Integer> value = new ArrayList<>();
			rows.add(row);
			values.add(value);
			for (int j = 0; j < matrix[i].length; j ++) {
				if (matrix[i][j] != 0) {
					row.add(j);
					value.add(matrix[i][j]);
				}
			}
		}
		for (int i = 0; i < this.rows.size(); i ++) {
			List<Integer> row = this.rows.get(i), value = this.values.get(i);
			for (int j = 0; j < row.size(); j ++) {
				System.out.print("(" + row.get(j) + ", " + value.get(j) + ") ");
			}
			System.out.println("");
		}
	}
	
	int[][] multiply(SparseMatrix B) {
		int[][] res = new int[this.rows.size()][B.col];
		List<List<Integer>> cols = new ArrayList<>(B.col), values = new ArrayList<>(B.col);
		for (int i = 0; i < B.col; i ++) {
			cols.add(new ArrayList<>());
			values.add(new ArrayList<>());
		}
		for (int i = 0; i < B.rows.size(); i ++) {
			List<Integer> row = B.rows.get(i), value = B.values.get(i);
			for (int j = 0; j < row.size(); j ++) {
				System.out.printf("row: %d, col: %d%n", i, row.get(j));
				cols.get(row.get(j)).add(i);
				values.get(row.get(j)).add(value.get(j));
			}
		}
		for (int i = 0; i < rows.size(); i ++) {
			List<Integer> row = rows.get(i), rowVal = this.values.get(i);
			for (int j = 0; j < cols.size(); j ++) {
				List<Integer> col = cols.get(j), colVal = values.get(j);
				int sum = 0;
				for (int k = 0, l = 0; k < row.size() && l < cols.size(); ) {
					if (row.get(k) == col.get(l)) {
						sum += rowVal.get(k ++) * colVal.get(l ++);
					} else {
						if (row.get(k) < col.get(l))
							k ++;
						else
							l ++;
					}
				}
				res[i][j] = sum;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{0, 0, 0, 1}, {0, 0, 1, 0}, {0, 1, 0, 0}}, B = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
		SparseMatrix SA = new SparseMatrix(A), SB = new SparseMatrix(B);
		int[][] res = SA.multiply(SB);
		for (int[] row: res)
			System.out.println(Arrays.toString(row));
	}

}
