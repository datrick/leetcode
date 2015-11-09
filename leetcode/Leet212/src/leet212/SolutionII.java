package leet212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionII {

	private static class Node {
		public int depth;
		public boolean end;
		public Node[] children;

		public Node(int d) {
			this.children = new Node[26];
			this.end = false;
			this.depth = d;
		}
	}
	
	private static class Trie {
		public Node root = new Node(0);
		
		// Adds a word into the data structure.
		public void addWord(String word) {
			Node node = this.root;
			for (int i = 0, n = word.length(); i < n; i ++) {
				char c = word.charAt(i);
				if (node.children[(int)(c - 'a')] == null)
					node.children[(int)(c - 'a')] = new Node(node.depth + 1);
				node = node.children[(int)(c - 'a')];
			}
			node.end = true;	
		}
	}
	
	private int[] deltX = {-1, 1, 0, 0}, deltY = {0, 0, -1, 1};
	
	private boolean isQualified(int i, int j, int row, int col, Set<Integer> visited) {
		if (i < 0 || i >= row || j < 0 || j >= col)
			return false;
		if (visited.contains(i * col + j))
			return false;
		return true;
	}
	
	private void doFind(char[][] board, int i, int j, Node root, Set<Integer> visited, StringBuilder sb, List<String> rslt) {
		char c = board[i][j];
		int k = c - 'a';
		if (root.children[k] == null)
			return;
		visited.add(i * board[0].length + j);
		sb.append(c);
		if (root.children[k].end) {
			rslt.add(sb.toString());
			root.children[k].end = false;
		}
		for (int l = 0; l < 4; l ++) {
			if (this.isQualified(i + deltX[l], j + deltY[l], board.length, board[0].length, visited))
				this.doFind(board, i + deltX[l], j + deltY[l], root.children[k], visited, sb, rslt);
		}
		sb.deleteCharAt(sb.length() - 1);
		visited.remove(i * board[0].length + j);
		return;
	}
	public List<String> findWords(char[][] board, String[] words) {
		int row = board.length, col = board[0].length;
		Trie trie = new Trie();
		for (String word : words)
			trie.addWord(word);
		List<String> rslt = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row; i ++)
			for (int j = 0; j < col; j ++) {
				if (rslt.size() >= words.length)
					return rslt;
				this.doFind(board, i, j, trie.root, visited, sb, rslt);
			}
		return rslt;
	}
}
