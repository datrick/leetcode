package leet051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	private void setTerritory(int i, int j, int[][] intBoard, int operation){
		int n = intBoard.length;
		for (int k = 0; k < n; k ++)
			if (!(k == j))
				intBoard[i][k] += operation;
		for (int k = 0; k < n; k ++)
			if (!(k == i))
				intBoard[k][j] += operation;
		for (int k = i <= j ? 0 : i - j, l = k + j - i; k < n && l < n; k ++, l ++)
			intBoard[k][l] += operation;
		for (int k = i - 1, l = j + 1; k >= 0 && l < n; k --, l ++)
			intBoard[k][l] += operation;
		for (int k = i + 1, l = j - 1; k < n && l >= 0; k ++, l --)
			intBoard[k][l] += operation;
	}
	
	private String[] toResult(char[][] board){
		String[] result = new String[board.length];
		for (int i = 0; i < board.length; i ++){
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < board[i].length; j ++)
				sb.append(board[i][j]);
			result[i] = sb.toString();
		}
		return result;
	}
	
	private void solveNQueuesRec(int num, int i, char[][] board, int[][] intBoard, List<String[]> rslt){
		if (num > board.length){
			rslt.add(this.toResult(board));
			return;
		}
//		System.out.format("num is %d, (%d, %d) is being tested\n",num, i, j);
//		for (int x = 0; x < intBoard.length; x ++){
//			for (int y = 0; y < intBoard.length; y ++)
//				System.out.format("%d ", intBoard[x][y]);
//			System.out.println("");
//		}
//		for (int x = 0; x < intBoard.length; x ++){
//			for (int y = 0; y < intBoard.length; y ++)
//				System.out.format("%c ", board[x][y]);
//			System.out.println("");
//		}
		for (; i < board.length; i ++){
			for (int j = 0; j < board.length; j ++){
//				System.out.format("board (%d, %d) is %d\n", i, j, intBoard[i][j]);
				if (intBoard[i][j] == 0){
//					System.out.format("board (%d, %d) %d is empty", i, j, intBoard[i][j]);
					this.setTerritory(i, j, intBoard, 1);
//					System.out.format("after set (%d, %d): \n", i, j);
//					for (int x = 0; x < intBoard.length; x ++){
//						for (int y = 0; y < intBoard.length; y ++)
//							System.out.format("%d ", intBoard[x][y]);
//						System.out.println("");
//					}
					board[i][j] = 'Q';
//					for (int x = 0; x < intBoard.length; x ++){
//						for (int y = 0; y < intBoard.length; y ++)
//							System.out.format("%c ", board[x][y]);
//						System.out.println("");
//					}
					this.solveNQueuesRec(num + 1, i + 1, board, intBoard, rslt);
					board[i][j] = '.';
					this.setTerritory(i, j, intBoard, -1);
				}
			}
		}
		return;
	}
	
	public List<String[]> solveNQueens(int n) {
		List<String[]> rslt = new ArrayList<>();
		if (n == 0)
			return rslt;
		char[][] board = new char[n][n];
		for (char[] line : board)
			Arrays.fill(line, '.');
		int[][] intBoard = new int[n][n];
		this.solveNQueuesRec(1, 0, board, intBoard, rslt);
		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String[]> rslt = new Solution().solveNQueens(4);
		System.out.println(rslt);
		for (String[] solution : rslt){
			for (String s : solution)
				System.out.println(s);
			System.out.println("abc");
		}
	}

}
