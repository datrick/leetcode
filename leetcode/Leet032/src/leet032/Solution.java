package leet032;

public class Solution {

	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int max = 0;
		for (int i = 1; i < s.length(); i ++){
			int j = i - dp[i - 1] - 1;
			if (j >= 0 && s.charAt(i) == ')' && s.charAt(j) == '('){
					dp[i] = dp[i - 1] + 2;
					dp[i] = j - 1 >= 0 ? dp[i] + dp[j - 1] : dp[i];
					max = dp[i] > max ? dp[i] : max;
			}
			else
				dp[i] = 0;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(((()()))(()))";
		System.out.println(new Solution().longestValidParentheses(s));
	}

}
