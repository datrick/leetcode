package leet308;

public class NumMatrix {

	private int[][] matrix, tree;
	
	private void updateTree(int row, int col, int val) {
		int delta = val - this.matrix[row][col];
		if (delta == 0)
			return;
		this.matrix[row][col] = val;
//		System.out.printf("row: %d, col: %d val: %d%n", row, col, val);
		for (int i = row + 1; i < tree.length; i += (i & -i)) 
			for (int j = col + 1; j < tree[0].length; j += (j & -j)) {
//				System.out.printf("(%d, %d) ", i, j);
				tree[i][j] += delta;
			}
				
		return;
	}
	
	private int getSum(int row, int col) {
		int res = 0;
		for (int i = row + 1; i > 0; i -= (i & -i))
			for (int j = col + 1; j > 0; j -= (j & -j))
				res += tree[i][j];
		return res;
	}
	
	public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length <= 0)
			return;
		this.matrix = new int[matrix.length][matrix[0].length];
		this.tree = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i ++)
			for (int j = 0; j < matrix[0].length; j ++)
				this.update(i, j, matrix[i][j]);
		return;
	}

	public void update(int row, int col, int val) {
		this.updateTree(row, col, val);
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int s0 = this.getSum(row2, col2), 
			s1 = row1 - 1 >= 0 && col1 - 1 >= 0 ? this.getSum(row1 - 1, col1 - 1) : 0,
			s2 = row1 - 1 >= 0 ? this.getSum(row1 - 1, col2) : 0,
			s3 = col1 - 1 >= 0 ? this.getSum(row2, col1 - 1) : 0;
		return s0 - s2 - s3 + s1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}
		};
//		int[][] matrix = { };
		NumMatrix obj = new NumMatrix(matrix);
		obj.update(3, 2, 2);
		System.out.println(obj.sumRegion(2, 1, 4, 3));
	}

}
