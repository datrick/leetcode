package leet308;

public class NumMatrix {

	private static class SumNode {
		public int row1, row2, col1, col2, sum;
		public SumNode[] child;
		public SumNode(int r1, int c1, int r2, int c2) {
			row1 = r1;
			row2 = r2;
			col1 = c1;
			col2 = c2;
			child = new SumNode[4];
		}
	}
	
	private SumNode root;
	private int[][] matrix = null;
	private SumNode buildTree(int[][] matrix, int row1, int col1, int row2, int col2) {
		if (row1 > row2 || col1 > col2)
			return null;
		int rowm = (row1 + row2) / 2, colm = (col1 + col2) / 2;
		SumNode node = new SumNode(row1, col1, row2, col2);
		if (row1 == row2 && col1 == col2) {
			node.sum = matrix[row1][col1];
			return node;
		}
		node.child[0] = buildTree(matrix, row1, col1, rowm, colm);
		if (rowm + 1 <= row2)
			node.child[1] = buildTree(matrix, rowm + 1, col1, row2, colm);
		if (colm + 1 <= col2)
			node.child[2] = buildTree(matrix, row1, colm + 1, rowm, col2);
		if (rowm + 1 <= row2 && colm + 1 <= col2)
			node.child[3] = buildTree(matrix, rowm + 1, colm + 1, row2, col2);
		for (SumNode t: node.child)
			node.sum += t == null ? 0 : t.sum;
		return node;
	}
	public NumMatrix(int[][] matrix) {
		this.matrix = matrix;
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
			this.root = null;
			return;
		}
		this.root = this.buildTree(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
	}

	public void update(int row, int col, int val) {
		SumNode node = this.root;
		int delta = val - this.matrix[row][col];
		this.matrix[row][col] = val;
		while (node != null) {
			node.sum += delta;
			SumNode tmp = null;
			for (int i = 0; i < node.child.length; i ++) {
				if (node.child[i] != null && row >= node.child[i].row1 && row <= node.child[i].row2
						&& col >= node.child[i].col1 && col <= node.child[i].col2) {
					tmp = node.child[i];
					break;
				}
			}
			node = tmp;
		}
	}

	private int doSum(SumNode node, int row1, int col1, int row2, int col2) {
		if (row1 == node.row1 && col1 == node.col1 && row2 == node.row2 && col2 == node.col2)
			return node.sum;
		int res = 0;
		for (SumNode child: node.child) {
			if (child == null)
				continue;
			int r1 = Math.max(child.row1, row1), r2 = Math.min(child.row2, row2),
					c1 = Math.max(child.col1, col1), c2 = Math.min(child.col2, col2);
			if (r1 <= r2 && c1 <= c2)
				res += this.doSum(child, r1, c1, r2, c2);
		}
		return res;
	}
	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (this.root == null)
			return 0;
		return this.doSum(this.root, row1, col1, row2, col2);
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
