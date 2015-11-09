package leet208;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
	// Initialize your data structure here.
	public String key = "";
	public List<TrieNode> children;
	public boolean isKey;
	public TrieNode() {
		this.children = new ArrayList<>();
		this.isKey = false;
	}
}

public class Trie {
	private TrieNode root;

//	public static void main(String[] argc) {	// 
//		Trie trie = new Trie();
//		trie.insert("abc");
//		System.out.println(trie.search("ab"));
//		System.out.println(trie.startsWith("bc"));
//		
//	}
	public Trie() {
		root = new TrieNode();
	}

	private TrieNode matchedTo(String word) {
		TrieNode cur = this.root;
		for (int l = 0; l < word.length(); l ++) {
			char c = word.charAt(l);
			int i = 0;
			List<TrieNode> list = cur.children;
			for (; i < list.size(); i ++) {
				if (list.get(i).key.charAt(list.get(i).key.length() - 1) == c){
					cur = list.get(i);
					break;
				}
			}
			if (i >= list.size())
				break;
		}
		return cur;
	}
	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode start = this.matchedTo(word);
		TrieNode cur = start;
		for (int i = start.key.length(); i < word.length(); i ++) {
			TrieNode tmp = new TrieNode();
			tmp.key = word.substring(0, i + 1);
			cur.children.add(tmp);
			cur = tmp;
		}
		cur.isKey = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode end = this.matchedTo(word);
		if (word.compareTo(end.key) == 0 && end.isKey)
			return true;
		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode end = this.matchedTo(prefix);
		if (prefix.compareTo(end.key) == 0)
			return true;
		return false;
	}
}

