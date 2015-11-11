package leet289;

public class Solution {

	private int numOfNei(int[][] board, int x, int y) {
		int res = 0;
		for (int i = -1; i <= 1; i ++)
			for (int j = -1; j <= 1; j ++)
				if (x + i < board.length && x + i >= 0 && y + j >= 0 && y + j < board[0].length && board[x + i][y + j] % 2 == 1)
					res ++;
		if (board[x][y] == 1)
			res --;
		return res;
	}
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i ++)
			for (int j = 0; j < board[0].length; j ++) {
				int n = this.numOfNei(board, i, j);
				if (board[i][j] == 1 && (n < 2 || n > 3) || board[i][j] == 0 && (n == 3))
					board[i][j] += 2;
			}
		for (int i = 0; i < board.length; i ++)
			for (int j = 0; j < board[0].length; j ++)
				board[i][j] = board[i][j] % 3 == 0 ? 0 : 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { {1, 1, 1}, {1, 1, 1}, {1, 1, 1} };
		new Solution().gameOfLife(board);
		for (int i = 0; i < board.length; i ++) {
			for (int j = 0; j < board[i].length; j ++)
				System.out.format("%d ", board[i][j]);
			System.out.println("");
		}
	}

}
