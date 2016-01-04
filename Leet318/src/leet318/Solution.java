package leet318;

public class Solution {

	public int maxLength(TrieNode root, int pattern) {
		if (root == null)
			return 0;
		int mask = 1, max = root.end ? 0 : -1, len = 0;
		for (int j = 0; j < 26; j ++) {
			if ((mask & pattern) == 0 && root.children[j] != null) {
				len = maxLength(root.children[j], pattern);
				if (len >= 0)
					max = Math.max(max, 1 + len);
			}
			mask <<= 1;
		}

		return max;
	}
	
	public int getPattern(String word) {
		int pattern = 0;
		int[] count = new int[26];
		for (int i = 0; i < word.length(); i ++) {
			count[word.charAt(i) - 'a'] ++;
		}
		for (int i = 0, mask = 1; i < 26; i ++, mask <<= 1) {
			if (count[i] != 0)
				pattern |= mask;
		}
		return pattern;
	}
	
	public int maxProduct(String[] words) {
		if (words.length <= 1)
			return 0;
		Trie trie = new Trie();
		int max = 0;
		for (String word: words)
			trie.insert(word);
		for (String word: words) {
			int pattern = getPattern(word);
			int len = maxLength(trie.root, pattern);
			max = Math.max(max, word.length() * len);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		Solution sol = new Solution();
		System.out.println(sol.maxProduct(words));
	}

}
