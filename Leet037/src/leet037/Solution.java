package leet037;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {

	private static class Coordinates {
		public int i, j;
		public Coordinates (int x, int y) {
			i = x;
			j = y;
		}
	}

	public void solveSudoku(char[][] board) {
		List<List<Set<Character>>> existed = new ArrayList<>();
		for (int i = 0; i < 3; i ++){
			existed.add(new ArrayList<>());
			for (int j = 0; j < board.length; j ++)
				existed.get(i).add(new HashSet<>());
		}
		int init_i = -1, init_j = -1;
		for (int i = 0; i < board.length; i ++){
			for (int j = 0; j < board.length; j ++){
				if (board[i][j] != '.'){
					existed.get(0).get(i).add(board[i][j]);
					existed.get(1).get(j).add(board[i][j]);
					existed.get(2).get(j / 3 * 3 + i / 3).add(board[i][j]);
				} else {
					if (init_i < 0){
						init_i = i;
						init_j = j;
					}
				}
			}
		}
		if (init_i < 0)
			return;
		Stack<Coordinates> curSt = new Stack<>();
		Stack<Coordinates> nextSt = new Stack<>();
		Stack<Character> value = new Stack<>();
		curSt.push(new Coordinates(init_i, init_j));
		char nextCandidate = '1';
		while (! curSt.isEmpty()){
			Coordinates cur = curSt.peek();
			char c = nextCandidate;
			for (; c <= '9' && c >= '1'; c ++){
				if (! (existed.get(0).get(cur.i).contains(c) || existed.get(1).get(cur.j).contains(c) || existed.get(2).get(cur.j / 3 * 3 + cur.i / 3).contains(c))){
					value.push(c);
					existed.get(0).get(cur.i).add(c);
					existed.get(1).get(cur.j).add(c);
					existed.get(2).get(cur.j / 3 * 3 + cur.i / 3).add(c);
					board[cur.i][cur.j] = c;
					break;
				}
			}
			if (c <= '9' && c >= '1'){
				if (! nextSt.isEmpty())
					curSt.push(nextSt.pop());
				else {
					int k = cur.i, l = cur.j;
					for (k = cur.i; k < board.length; k ++){
						for (l = 0; l < board.length; l ++){
							if (board[k][l] == '.')
								break;
						}
						if (l < board.length)
							break;
					}
					if ( !(k < board.length && l < board.length) )
						return;
					curSt.push(new Coordinates(k, l));
				}
				nextCandidate = '1';
			} else {
				nextSt.push(curSt.pop());
				nextCandidate = ! value.isEmpty() ? value.pop() : '0';
				if (! curSt.isEmpty()){
					int i = curSt.peek().i, j = curSt.peek().j;
					board[i][j] = '.';
					existed.get(0).get(i).remove(nextCandidate);
					existed.get(1).get(j).remove(nextCandidate);
					existed.get(2).get(j / 3 * 3 + i / 3).remove(nextCandidate);
				}
				nextCandidate = (char) (nextCandidate + 1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { 	{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
							{'6', '.', '.', '1', '9', '5', '.', '.','.',},
							{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
							{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
							{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
							{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
							{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
							{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
							{'.', '.', '.', '.', '8', '.', '.', '7', '9'} };
		for (int i = 0; i < board.length; i ++){
			for (int j = 0; j < board.length; j ++)
				System.out.format("%c ", board[i][j]);
			System.out.println("");
		}
		System.out.format("\n");
		new Solution().solveSudoku(board);
		for (int i = 0; i < board.length; i ++){
			for (int j = 0; j < board.length; j ++)
				System.out.format("%c ", board[i][j]);
			System.out.format("\n");
		}
		System.out.println((char) ('0' + 1));
	}

}
