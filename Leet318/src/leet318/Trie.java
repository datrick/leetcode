package leet318;

public class Trie {
	public TrieNode root;
	public Trie() {
		this.root = new TrieNode('$');
	}
	public void insert(String s) {
		if (s.length() <= 0)
			return;
		TrieNode cur = this.root;
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i ++){
			if (cur.children[a[i] - 'a'] == null)
				cur.children[a[i] - 'a'] = new TrieNode(a[i]);
			cur = cur.children[a[i] - 'a'];
		}
		cur.end = true;
	}
}
