package leet318;

public class TrieNode {
	public char val;
	public TrieNode[] children;
	public boolean end;
	public TrieNode (char c) {
		this.val = c;
		this.children = new TrieNode[26];
		this.end = false;
	}
}
