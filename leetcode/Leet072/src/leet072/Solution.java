package leet072;

public class Solution {

	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		char[] char1 = (" " + word1).toCharArray();
		char[] char2 = (" " + word2).toCharArray();
		int i, j, cr, cd = 1, ca = 1;
		for(i = 0; i <= word2.length(); i ++)
			dp[0][i] = i;
		for(i = 0; i <= word1.length(); i ++)
			dp[i][0] = i;
		for(i = 1; i <= word1.length(); i ++)
			for(j = 1; j <= word2.length(); j ++){
				cr = char1[i] == char2[j] ? 0 : 1;
				dp[i][j] = Math.min(Math.min(dp[i][j - 1] + ca, dp[i - 1][j] + cd), dp[i - 1][j - 1] + cr);
			}
		return dp[word1.length()][word2.length()];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "abcdefg", word2 = "abchhhhhhhhhhhhhhh";
		Solution obj = new Solution();
		System.out.println(obj.minDistance(word1, word2));
	}

}
