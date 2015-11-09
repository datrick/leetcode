package leet211;

public class Solution {
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

	private Node root = new Node(0);

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

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		if (word.length() <= 0)
			return false;
		return this.searchRec(word, 0, this.root);
	}

	private boolean searchRec(String word, int i, Node node) {
		if (i == word.length())
			return node.end;
		char c = word.charAt(i);
		if (c != '.') {
			if (node.children[(int)(c - 'a')] != null)
				return this.searchRec(word, i + 1, node.children[(int)(c - 'a')]);
			else
				return false;
		} else {
			for (int j = 0; j < 26; j ++) {
				if (node.children[j] != null && this.searchRec(word, i + 1, node.children[j]))
					return true;
			}
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		obj.addWord("a");
		obj.addWord("a");
		//obj.addWord("mad");
		System.out.println(obj.search("."));
		System.out.println(obj.search("a"));
		System.out.println(obj.search("aa"));
		System.out.println(obj.search("a"));
		System.out.println(obj.search(".a"));
		System.out.println(obj.search("a."));
		System.out.println(obj.search("a.."));
	}

}
