package leet130;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public class Xy{
		public int x, y;
		public Xy(int i, int j){
			x = i;
			y = j;
		}
	}
	private void flow(char[][] board, int x, int y, boolean[][] visited){
		Queue<Xy> queue = new LinkedList<>();
		queue.offer(new Xy(x, y));
		visited[x][y] = true;
		while(!queue.isEmpty()){
			int i = queue.peek().x, j = queue.peek().y;
			if(i - 1 >= 0 && board[i - 1][j] == 'O' && !visited[i - 1][j]){
				queue.offer(new Xy(i - 1, j));
				visited[i - 1][j] = true;
			}
			if(i + 1 < board.length && board[i + 1][j] == 'O' && !visited[i + 1][j]){
				queue.offer(new Xy(i + 1, j));
				visited[i + 1][j] = true;
			}
			if(j - 1 >= 0 && board[i][j - 1] == 'O' && !visited[i][j - 1]){
				queue.offer(new Xy(i, j - 1));
				visited[i][j - 1] = true;
			}
			if(j + 1 < board[0].length && board[i][j + 1] == 'O' && !visited[i][j + 1]){
				queue.offer(new Xy(i, j + 1));
				visited[i][j + 1] = true;
			}
			queue.poll();
		}
	}
	public void solve(char[][] board) {
		if(board.length < 3)
			return;
		boolean[][] visited = new boolean[board.length][board[0].length];
		int i, j;
		for(i = 0; i < board[0].length; i ++)
			if(board[0][i] == 'O' && !visited[0][i])
				this.flow(board, 0, i, visited);
		for(i = 0; i < board[0].length; i ++)
			if(board[board.length - 1][i] == 'O' && !visited[board.length - 1][i])
				this.flow(board, board.length - 1, i, visited);
		for(i = 0; i < board.length; i ++)
			if(board[i][0] == 'O' && !visited[i][0])
				this.flow(board, i, 0, visited);
		for(i = 0; i < board.length; i ++)
			if(board[i][board[0].length - 1] == 'O' && !visited[i][board[0].length - 1])
				this.flow(board, i, board[0].length - 1, visited);
		for(i = 0; i < board.length; i ++)
			for(j = 0; j < board[0].length; j ++)
				if(board[i][j] == 'O' && !visited[i][j])
					board[i][j] = 'X';
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		Solution obj = new Solution();
		obj.solve(board);
		int i, j;
		for(i = 0; i < board.length; i ++){
			for(j = 0; j < board[0].length; j ++)
				System.out.printf("%c ", board[i][j]);
			System.out.format("\n");
		}
	}

}
